package pack.dao;

import pack.beans.Book;

import java.util.*;

//ԤԼ��¼DAO�ӿ�
public interface BookDao {
	//����ԤԼid�õ�ԤԼ��¼
	Book get(int id);
	
	//����ԤԼid�õ�δ���ԤԼ��¼
	Book getCrudeById(int id);
	
	//���ݿͻ�id�õ�ԤԼ��¼
	List<Book> getByCustomerId(int id);
	
	//���ݿͻ�id�õ�δ��ɵ�ԤԼ��¼
	List<Book> getCrudeByCustomerId(int id);
	
	//����ԤԼʱ��õ�ԤԼ��¼
	List<Book> getByTime(String time);
	
	//����ԤԼ��סʱ��õ�ԤԼ��¼
	List<Book> getByStart(String start);
	
	//����ԤԼ�˷�ʱ��õ�ԤԼ��¼
	List<Book> getByLeave(String leave);
	
	//���ݷ���id�õ�ԤԼ��¼
	List<Book> getByRoomId(int roomId);
	
	//�õ�����δ���ԤԼ
	List<Book> getCrudeBooks();
	
	//�õ�����ԤԼ
	List<Book> getAllBooks();
	
	//����ԤԼ
	void saveOrUpdate(Book book);
}
