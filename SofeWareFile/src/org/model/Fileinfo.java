package org.model;

import java.sql.Timestamp;

/**
 * Fileinfo entity. @author MyEclipse Persistence Tools
 */

public class Fileinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String fileName;
	private String filePath;
	private String title;
	private String type;
	private String description;
	private Integer createUser;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Integer hitCount;

	// Constructors

	/** default constructor */
	public Fileinfo() {
	}

	/** minimal constructor */
	public Fileinfo(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
	}

	/** full constructor */
	public Fileinfo(String fileName, String filePath, String title,
			String type, String description, Integer createUser,
			Timestamp createDate, Timestamp updateDate, Integer hitCount) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.title = title;
		this.type = type;
		this.description = description;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.hitCount = hitCount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getHitCount() {
		return this.hitCount;
	}

	public void setHitCount(Integer hitCount) {
		this.hitCount = hitCount;
	}

}