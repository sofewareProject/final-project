package org.handle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = this.getServletContext().getRealPath(
				"/WEB-INF/upload");
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			tmpFile.mkdir();
		}

		
		String message = "";
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 100);
			factory.setRepository(tmpFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength,
						int arg2) {
					//文件进度   pContentLength：文件大小      pBytesRead：当前已处理
					//文件大小为：94641,当前已处理：94641
				    //System.out.println("文件大小为：" + pContentLength + ",当前已处理："	+ pBytesRead);
				}
			});
			upload.setHeaderEncoding("UTF-8");
			if (!ServletFileUpload.isMultipartContent(request)) {
				return;
			}

			upload.setFileSizeMax(1024 * 1024);
			upload.setSizeMax(1024 * 1024 * 10);
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					//上传的用户名：  value ：用户名
					//username=更好的
			//		System.out.println(name + "=" + value);
					
				} else {
					String filename = item.getName();
					String filenameOld=filename;									
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					String fileExtName = filename.substring(filename
							.lastIndexOf(".") + 1);
					
					
					//上传的文件的扩展名是：jpg
					System.out.println("\n\n上传原始的文件的扩展名是：" + fileExtName);			
					System.out.println("上传原始的文件名是：" + filename);
					System.out.println("上传原始的文件：" +filenameOld);
					
					
					InputStream in = item.getInputStream();				
					String saveFilename = makeFileName(filename);					
					String realSavePath = makePath(saveFilename, savePath);				
					FileOutputStream out = new FileOutputStream(realSavePath
							+ "\\" + saveFilename);
					
					//保存后的文件的相关信息
					System.out.println("\n上传保存的文件名是：" + saveFilename);	
					System.out.println("上传保存的路径是：" + realSavePath);
					System.out.println("上传保存是：" + realSavePath+ "\\" + saveFilename);
					
					
					
					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					message = "文件上传成功！";
				}
			}
		} catch (Exception e) {
			message = "文件上传失败！";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	private String makePath(String filename, String savePath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		String dir = savePath + "\\" + dir1 + "\\" + dir2;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
