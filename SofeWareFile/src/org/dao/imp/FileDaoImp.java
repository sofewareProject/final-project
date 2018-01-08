package org.dao.imp;

import java.util.List;

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

	public List findAllFile() {
		List list=getHibernateTemplate().find("from Fileinfo order by id");		
		return list;
	}

	public Fileinfo findfileInfoByID(int fileId) {
		List list=getHibernateTemplate().find("from Fileinfo where id=?",fileId);	
		if(list.size()>0){
			return (Fileinfo) list.get(0);
		}
		return null;
	}

}
