package org.handle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	     String fileName=req.getParameter("filename"); 
	     fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
	     String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
	     String path=findFileSavePathByFileName(fileName,fileSaveRootPath);
	     File file=new File(path+"\\"+fileName);
	     if(!file.exists()){
	    	 System.out .println("path +  fileName"+path+"\\"+fileName);
	    	 req.setAttribute("message", "您要下载的资源已被删除！");
	    	 req.getRequestDispatcher("/message.jsp").forward(req, resp);
	    	 return ;
	     }
	     
	     String realName=fileName.substring(fileName.indexOf("_")+1);
	     resp.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(realName,"UTF-8"));
	     FileInputStream in=new FileInputStream(path+"\\"+fileName);
	     OutputStream out=resp.getOutputStream();
	     byte buffer[]=new byte[1024];
	     int len=0;
	     while((len=in.read(buffer))>0){
	    	 out.write(buffer,0,len);
	     }
	     in.close();
	     out.close();   
	}

	private String findFileSavePathByFileName(String fileName,
			String fileSaveRootPath) {
		int hashcode=fileName.hashCode();
		int dir1=hashcode & 0xf;
		int dir2=(hashcode & 0xf0) >> 4;
		String dir=fileSaveRootPath+"\\"+dir1+"\\"+dir2;
		
		File file=new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
		return dir;				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
