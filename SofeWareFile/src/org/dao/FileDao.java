package org.dao;

import org.model.Fileinfo;

public interface FileDao {
	public void saveFile(Fileinfo fileInfo);
	public void deleteFile(Fileinfo fileInfo);

}
