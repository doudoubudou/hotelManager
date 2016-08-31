package pack.dao.impl;

import java.util.List;

import pack.beans.Customer;
import pack.dao.CustomerDao;

import java.util.*;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//�ͻ���Dao��ʵ����
public class CustomerDaoImpl 
	extends HibernateDaoSupport implements CustomerDao{
	//���ݿͻ�id�õ�ָ���ͻ�
	public Customer getById(int id){
		return getHibernateTemplate().get(Customer.class,id);
	}
	
	//���ݿͻ����֤�ŵõ�ָ���ͻ�
	public Customer getByIc(String ic){
		List<Customer> customers=(List<Customer>)getHibernateTemplate()
				.find("from Customer where ic=?",ic);
				
		if(customers.size()!=0){
			return customers.get(0);
		}else{
			return null;
		}		
	}
		
	//���ݿͻ������õ�ָ���ͻ�
	public List<Customer> getByName(String name){
		return (List<Customer>)getHibernateTemplate()
				.find("from Customer where name=?",name);
	}
		
	//���ݿͻ��绰�õ�ָ���ͻ�
	public Customer getByPhone(String phone){
		List<Customer> customers=(List<Customer>)getHibernateTemplate()
				.find("from Customer where phone=?",phone);
			
		if(customers.size()!=0){
			return customers.get(0);
		}else{
			return null;
		}
	}
		
	//��ȡ���ݿ��е����пͻ�
	public List<Customer> getAllCustomers(){
		return (List<Customer>)getHibernateTemplate()
				.find("from Customer");
	}
		
	//����ͻ���
	public void saveOrUpdate(Customer customer){
		try{
			String ic=customer.getIc();
			Customer c=getByIc(ic);
			
			if(c==null){
				getHibernateTemplate().save(customer);
			}else{
				customer.setId(c.getId());
				getHibernateTemplate().merge(customer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
