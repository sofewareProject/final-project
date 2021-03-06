package org.dao;

import java.util.List;

import org.model.Fileinfo;

public interface FileDao {
	public void saveFile(Fileinfo fileInfo);
	public void deleteFile(Fileinfo fileInfo);
	public List findAllFile();
	public Fileinfo findfileInfoByID(int fileId);
	public List findfileInfoByName(String fileName);
	public List findfileInfoByTitle(String file_searchJspTitle);

}
