package org.action;

import org.dao.UserDao;
import org.model.Userinfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DLAction {
	ApplicationContext context=new FileSystemXmlApplicationContext("C:/Users/lenovo/myeclipseworkspace/SofeWareFile/src/applicationContext.xml");
	UserDao userDao=(UserDao) context.getBean("UserDaoImp");
	private Userinfo user_regJsp;
	private Userinfo user_loginJsp;
	
	public Userinfo getUser_loginJsp() {
		return user_loginJsp;
	}

	public void setUser_loginJsp(Userinfo user_loginJsp) {
		this.user_loginJsp = user_loginJsp;
	}

	public Userinfo getUser_regJsp() {
		return user_regJsp;
	}

	public void setUser_regJsp(Userinfo user_regJsp) {
		this.user_regJsp = user_regJsp;
	}
	
	//µÇÂ¼
	public String user_loginJsp(){
		String name=user_loginJsp.getLoginName();
		String pwd=user_loginJsp.getUserPwd();
		Userinfo user=userDao.findUserByNaPw(name, pwd);
		if(user!=null){
			System.out .print("Find"+user.toString());
			return "success";
		}else{
			return "error";
		}		
	}	
	
	//×¢²áÓÃ»§
	public String user_regJsp(){	
		userDao.addUser(user_regJsp);
		return "success";
	}

}
