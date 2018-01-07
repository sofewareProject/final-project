package org.model;

/**
 * Lyinfo entity. @author MyEclipse Persistence Tools
 */

public class Lyinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String title;
	private String lyContent;
	private Integer fileId;

	// Constructors

	/** default constructor */
	public Lyinfo() {
	}

	/** full constructor */
	public Lyinfo(Integer userId, String title, String lyContent, Integer fileId) {
		this.userId = userId;
		this.title = title;
		this.lyContent = lyContent;
		this.fileId = fileId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyContent() {
		return this.lyContent;
	}

	public void setLyContent(String lyContent) {
		this.lyContent = lyContent;
	}

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

}