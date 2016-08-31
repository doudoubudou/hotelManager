package pack.dao;

import pack.beans.Customer;

import java.util.*;

//�ͻ���Dao
public interface CustomerDao {
	//�����û�id�õ�ָ���û�
	Customer getById(int id);
	
	//���ݿͻ����֤�ŵõ�ָ���ͻ�
	Customer getByIc(String ic);
	
	//���ݿͻ������õ�ָ���ͻ�
	List<Customer> getByName(String name);
	
	//���ݿͻ��绰�õ�ָ���ͻ�
	Customer getByPhone(String phone);
	
	//��ȡ���ݿ��е����пͻ�
	List<Customer> getAllCustomers();
	
	//����ͻ���
	void saveOrUpdate(Customer customer);
}
