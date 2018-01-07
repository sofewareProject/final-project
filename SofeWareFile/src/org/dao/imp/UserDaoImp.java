package org.dao.imp;

import java.util.List;

import org.dao.UserDao;
import org.model.Userinfo;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImp extends HibernateDaoSupport implements UserDao{

	public void addUser(Userinfo user) {
		getHibernateTemplate().save(user);
	}

	public Userinfo findUserByNaPw(String name, String pwd) {
		String str[]={name,pwd};
		List list=getHibernateTemplate().find("from Userinfo where loginName=? and userPwd=?",str);
		if(list.size()>0){
			return (Userinfo) list.get(0);
		}
		return null;
	}
}
