package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;

import org.apache.struts2.ServletActionContext;
import org.model.Fileinfo;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private Fileinfo File_upJsp;
	private File File_upJsp1;
	private String File_upJsp1Type;
	private String File_upJsp1Name;

	public String getFile_upJsp1Type() {
		return File_upJsp1Type;
	}

	public void setFile_upJsp1Type(String file_upJsp1Type) {
		File_upJsp1Type = file_upJsp1Type;
	}

	public String getFile_upJsp1Name() {
		return File_upJsp1Name;
	}

	public void setFile_upJsp1Name(String file_upJsp1Name) {
		File_upJsp1Name = file_upJsp1Name;
	}

	public Fileinfo getFile_upJsp() {
		return File_upJsp;
	}

	public void setFile_upJsp(Fileinfo file_upJsp) {
		File_upJsp = file_upJsp;
	}

	public File getFile_upJsp1() {
		return File_upJsp1;
	}

	public void setFile_upJsp1(File file_upJsp1) {
		File_upJsp1 = file_upJsp1;
	}

	public String File_up() {
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/WEB-INF/upload");
		File tmpFile = new File(savePath);
		if (!tmpFile.exists()) {
			tmpFile.mkdir();
		}
		try {
			InputStream is = new FileInputStream(File_upJsp1);
			String fileNameNew = File_upJsp1Name + "." + File_upJsp1Type;
			File toFile = new File(savePath, fileNameNew);
			OutputStream os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];// ÉèÖÃ»º´æ
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			
			
			return "success";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
