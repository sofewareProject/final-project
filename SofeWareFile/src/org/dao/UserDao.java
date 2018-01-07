package org.dao;


import org.model.Userinfo;


public interface UserDao {
	public void addUser(Userinfo user);
	public Userinfo findUserByNaPw(String name,String pwd);

}
