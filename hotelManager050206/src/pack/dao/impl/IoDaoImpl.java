package pack.dao.impl;

import java.util.List;

import pack.beans.Io;
import pack.beans.Report;
import pack.dao.IoDao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

//IoDao��ʵ����
public class IoDaoImpl 
	extends HibernateDaoSupport implements IoDao{
	//����id��ȡ��ס��¼
	public Io get(int id){
		return getHibernateTemplate()
				.get(Io.class,id);
	}
	
	//�ҳ���ǰ��ס��¼
	public List<Io> getCurrentIos(){
		return (List<Io>)getHibernateTemplate()
				.find("from Io where state=0");
	};
	
	//��ȡ������ס��¼
	public List<Io> getAllIos(){
		return (List<Io>)getHibernateTemplate()
				.find("from Io");
	}
	
	//������ס��¼
	public void saveOrUpdate(Io io){
		int id=io.getId();
		Io i=get(id);
		if(i==null){
			getHibernateTemplate().save(io);
		}else{
			getHibernateTemplate().merge(io);
		}
	}
	
	//������סid��ȡδ�˷��ļ�¼
	public Io getCurrentIoById(int id){
		List<Io> ios=(List<Io>)getHibernateTemplate()
				.find("from Io where id=? and state=false",id);
		
		if(ios.size()!=0){
			return ios.get(0);
		}else{
			return null;
		}
	}
		
	//���ݿͻ����֤��ȡδ�˷��ļ�¼
	public Io getCurrentIoByCustomerId(int id){
		List<Io> ios=(List<Io>)getHibernateTemplate()
				.find("from Io where customerId=? and state=false",id);
		
		if(ios.size()!=0){
			return ios.get(0);
		}else{
			return null;
		}
	}
}
