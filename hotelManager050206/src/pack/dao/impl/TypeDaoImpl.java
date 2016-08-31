package pack.dao.impl;

import pack.beans.Type;
import pack.dao.TypeDao;

import java.util.*;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

//Type��Dao��ʵ����
public class TypeDaoImpl 
	extends HibernateDaoSupport implements TypeDao{
	//����ID�õ�Type������
	public Type get(int id){
		return getHibernateTemplate().get(Type.class,id);
	}
	
	//��ȡ��������
	public List<Type> getAllTypes(){
		return (List<Type>)getHibernateTemplate().
				find("from Type");
	}
}
