package org.dao.imp;

import org.dao.FileDao;
import org.model.Fileinfo;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FileDaoImp extends HibernateDaoSupport implements FileDao {

	public void saveFile(Fileinfo fileInfo) {
		getHibernateTemplate().save(fileInfo);
	}

	public void deleteFile(Fileinfo fileInfo) {
		getHibernateTemplate().delete(fileInfo);
	}

}
