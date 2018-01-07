package org.model;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginName;
	private String userName;
	private String userPwd;
	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", loginName=" + loginName
				+ ", userName=" + userName + ", userPwd=" + userPwd
				+ ", gender=" + gender + ", grade=" + grade + ", cell=" + cell
				+ ", email=" + email + ", role=" + role + "]";
	}

	private String gender;
	private String grade;
	private String cell;
	private String email;
	private String role;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String loginName, String userName) {
		this.loginName = loginName;
		this.userName = userName;
	}

	/** full constructor */
	public Userinfo(String loginName, String userName, String userPwd,
			String gender, String grade, String cell, String email, String role) {
		this.loginName = loginName;
		this.userName = userName;
		this.userPwd = userPwd;
		this.gender = gender;
		this.grade = grade;
		this.cell = cell;
		this.email = email;
		this.role = role;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}