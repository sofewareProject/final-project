package org.handle;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileListAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uploadFilePath=this.getServletContext().getRealPath("/WEB-INF/upload");
		Map<String,String> fileNameMap=new HashMap<String,String>();
		listfile(new File(uploadFilePath),fileNameMap);
		req.setAttribute("fileNameMap", fileNameMap);
		req.getRequestDispatcher("/listfile.jsp").forward(req, resp);		
	}
	
	public void listfile(File file,Map<String,String> map){
		if(!file.isFile()){
			File files[]=file.listFiles();
			for(File f:files){
				listfile(f,map);
			}
		}else{
			String realName=file.getName().substring(file.getName().indexOf("_")+1);
			map.put(file.getName(), realName);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
