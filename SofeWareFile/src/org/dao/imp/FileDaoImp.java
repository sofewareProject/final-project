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

	public List findfileInfoByName(String fileName) {
		List list=getHibernateTemplate().find("from Fileinfo where fileName LIKE ?","%"+fileName+"%");	
		if(list.size()>0){
			return list;
		}
		return null;
	}

	public List findfileInfoByTitle(String file_searchJspTitle) {
		List list=getHibernateTemplate().find("from Fileinfo where title=?",file_searchJspTitle);	
		if(list.size()>0){
			return list;
		}
		return null;
	}

}
