package pack.service;

import pack.beans.*;

import java.util.*;

//��ȡ���ݿ����ݵĽӿ�
public interface GetService {
	//��ȡָ��id��ԤԼ��¼
	Book getBook(int id);
	//��ȡָ��id,δ��ס��ԤԼ��¼
	Book getCrudeBook(int id);
	//��ȡָ���ͻ�������ԤԼ��¼
	List<Book> getBooksByName(String name);
	//��ȡָ���ͻ����֤��ԤԼ��¼
	List<Book> getBooksByIc(String ic);
	//��ȡָ���ͻ����֤,δ��ס��ԤԼ��¼
	List<Book> getCrudeBooksByIc(String ic);
	//��ȡָ���ͻ��ֻ��ŵ�ԤԼ��¼
	List<Book> getBooksByPhone(String phone);
	//��ȡָ��ԤԼʱ���ԤԼ��¼
	List<Book> getBooksByTime(String time);
	//��ȡָ��ԤԼ��סʱ���ԤԼ��¼
	List<Book> getBooksByStart(String start);
	//��ȡָ��ԤԼ�˷�ʱ���ԤԼ��¼
	List<Book> getBooksByLeave(String leave);
	//��ȡָ������ŵ�ԤԼ��¼
	List<Book> getBooksByRoomNum(int roomNum);
	//��ȡ����δ���ԤԼ��¼
	List<Book> getCrudeBooks();
	//��ȡ����ԤԼ��¼
	List<Book> getAllBooks();
	//��ȡ������ס��¼
	List<Io> getAllIos();
	//��ȡ����δ�˷�����ס��¼
	List<Io> getCurrentIos();
	//������סid��ȡδ�˷�����ס��¼
	Io getCurrentIoById(int id);
	//���ݿͻ����֤�Ż�ȡδ�˷�����ס��¼
	Io getCurrentIoByIc(String ic);
	//��ȡ�ͷ�
	Room getRoomByNum(int num);
	//��ȡ���пͷ�
	List<Room> getAllRooms();
	//��ȡ��������
	List<Type> getAllTypes();
	//��ȡָ��id�Ŀͻ�
	Customer getCustomer(String ic);
	//��ȡ�����û�
	List<Customer> getAllCustomers();
	//��ȡ���ձ���
	Report getTodayReport();
}
