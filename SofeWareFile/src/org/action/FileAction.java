package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.FileDao;
import org.dao.UserDao;
import org.model.Fileinfo;
import org.model.Userinfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	private File File_upJsp1;
	private String File_upJsp1Type, File_upJsp1Name, File_upJsp1Des,
			File_upJsp1Tit;
	String savePath = ServletActionContext.getServletContext().getRealPath(
			"/WEB-INF/upload");
	String downPath = ServletActionContext.getServletContext().getRealPath(
			"/WEB-INF/download");

	private Userinfo login_userJsp;
	ApplicationContext context = new FileSystemXmlApplicationContext(
			"C:/Users/lenovo/myeclipseworkspace/SofeWareFile/src/applicationContext.xml");
	UserDao userDao = (UserDao) context.getBean("UserDaoImp");
	FileDao fileDao = (FileDao) context.getBean("FileDaoImp");
	Map session = ActionContext.getContext().getSession();
	List AllfilesJsp;
	public int fileId;
	public File file_downJsp;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	// 文件上传
	public String File_up() {
		File tmpFile = new File(savePath);
		if (!tmpFile.exists())
			tmpFile.mkdir();

		try {
			InputStream is = new FileInputStream(File_upJsp1);
			String fileNameNew = File_upJsp1Name + "." + File_upJsp1Type;
			File toFile = new File(savePath, fileNameNew);
			OutputStream os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];// 设置缓存
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();

			// 将上传的文件信息填写到数据库
			login_userJsp = (Userinfo) session.get("LoginUser");
			System.out.println("login_userJsp" + login_userJsp.toString());

			Fileinfo fileUpJsp = new Fileinfo();
			fileUpJsp.setDescription(File_upJsp1Des);
			fileUpJsp.setFileName(File_upJsp1Name);
			fileUpJsp.setTitle(File_upJsp1Tit);
			fileUpJsp.setType(File_upJsp1Type);
			fileUpJsp.setHitCount(0);
			fileUpJsp.setFilePath(toFile.getPath());
			fileUpJsp.setCreateUser(login_userJsp.getId());
			fileDao.saveFile(fileUpJsp);

			return "success";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 文件查看
	public String File_list() {
		AllfilesJsp = fileDao.findAllFile();
		return "success";
	}

	// 文件下载
	public String File_down() {
		System.out.println("fileId=" + fileId);
		Fileinfo fileDown = fileDao.findfileInfoByID(fileId);
		System.out.println("fileDown=" + fileDown.toString());

		File tmpFile = new File(downPath);
		if (!tmpFile.exists())
			tmpFile.mkdir();
		//找到这个文件	
		String fileDownName= fileDown.getFileName()+"."+fileDown.getType();
		System.out .println(" fileDown.getFileName()="+ fileDown.getFileName()+fileDown.getType());
		file_downJsp = new File(savePath, fileDownName);
		try {
			String fileNameTemp = URLEncoder.encode(fileDown.getFileName(), "utf-8");
			System.out .println("fileNameTemp="+fileNameTemp);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if (file_downJsp.exists()) {
			return "success";
		} else {
			toClient("该文档不存在！");
			return null;
		}
	}

	private void toClient(String message) {
		// TODO Auto-generated method stub

		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=GBK");
			PrintWriter out;
			out = response.getWriter();
			out.write("<font size=\"3\" color=\"red\"><B>");
			out.write(message);
			out.write("</B></font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List getAllfilesJsp() {
		return AllfilesJsp;
	}

	public void setAllfilesJsp(List allfilesJsp) {
		AllfilesJsp = allfilesJsp;
	}

	public String getFile_upJsp1Type() {
		return File_upJsp1Type;
	}

	public String getFile_upJsp1Des() {
		return File_upJsp1Des;
	}

	public void setFile_upJsp1Des(String file_upJsp1Des) {
		File_upJsp1Des = file_upJsp1Des;
	}

	public String getFile_upJsp1Tit() {
		return File_upJsp1Tit;
	}

	public void setFile_upJsp1Tit(String file_upJsp1Tit) {
		File_upJsp1Tit = file_upJsp1Tit;
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

	public File getFile_upJsp1() {
		return File_upJsp1;
	}

	public void setFile_upJsp1(File file_upJsp1) {
		File_upJsp1 = file_upJsp1;
	}

	public Userinfo getLogin_userJsp() {
		return login_userJsp;
	}

	public void setLogin_userJsp(Userinfo login_userJsp) {
		this.login_userJsp = login_userJsp;
	}

}
