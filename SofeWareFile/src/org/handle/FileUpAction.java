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
					//�ļ�����   pContentLength���ļ���С      pBytesRead����ǰ�Ѵ���
					//�ļ���СΪ��94641,��ǰ�Ѵ���94641
				    //System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���"	+ pBytesRead);
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
					//�ϴ����û�����  value ���û���
					//username=���õ�
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
					
					
					//�ϴ����ļ�����չ���ǣ�jpg
					System.out.println("\n\n�ϴ�ԭʼ���ļ�����չ���ǣ�" + fileExtName);			
					System.out.println("�ϴ�ԭʼ���ļ����ǣ�" + filename);
					System.out.println("�ϴ�ԭʼ���ļ���" +filenameOld);
					
					
					InputStream in = item.getInputStream();				
					String saveFilename = makeFileName(filename);					
					String realSavePath = makePath(saveFilename, savePath);				
					FileOutputStream out = new FileOutputStream(realSavePath
							+ "\\" + saveFilename);
					
					//�������ļ��������Ϣ
					System.out.println("\n�ϴ�������ļ����ǣ�" + saveFilename);	
					System.out.println("�ϴ������·���ǣ�" + realSavePath);
					System.out.println("�ϴ������ǣ�" + realSavePath+ "\\" + saveFilename);
					
					
					
					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					message = "�ļ��ϴ��ɹ���";
				}
			}
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ�ܣ�";
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
