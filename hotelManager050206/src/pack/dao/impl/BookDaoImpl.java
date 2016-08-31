package pack.dao.impl;

import java.util.*;
import java.text.*;

import pack.beans.Book;
import pack.dao.BookDao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//ԤԼ��¼DAO�ӿڵ�ʵ����
public class BookDaoImpl 
	extends HibernateDaoSupport implements BookDao{
	//����ԤԼid�õ�ԤԼ��¼
	public Book get(int id){
		return getHibernateTemplate().get(Book.class,id);
	};
	
	//���ݿͻ�id�õ�ԤԼ��¼
	public Book getCrudeById(int id){
		List<Book> books=(List<Book>)getHibernateTemplate()
				.find("from Book where id=? and flag=0",id);
		
		if(books.size()!=0){
			return books.get(0);
		}else{
			return null;
		}
	}
	
	//���ݿͻ�id�õ�ԤԼ��¼
	public List<Book> getByCustomerId(int customerId){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where customerId=?",customerId);
	}
	
	//���ݿͻ�id�õ�δ��ɵ�ԤԼ��¼
	public List<Book> getCrudeByCustomerId(int customerId){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where customerId=? and flag=0",customerId);
	}
	
	//���ݷ���id�õ�ԤԼ��¼
	public List<Book> getByRoomId(int roomId){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where roomId=?",roomId);
	}
	
	//����ԤԼʱ��õ�ԤԼ��¼
	public List<Book> getByTime(String time){
		Date t=null;
		try{
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			t=df.parse(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (List<Book>)getHibernateTemplate()
				.find("from Book where time=?",t);
	}
	
	//����ԤԼ��סʱ��õ�ԤԼ��¼
	public List<Book> getByStart(String start){
		Date t=null;
		try{
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			t=df.parse(start);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (List<Book>)getHibernateTemplate()
				.find("from Book where start=?",t);
	}
		
	//����ԤԼ�˷�ʱ��õ�ԤԼ��¼
	public List<Book> getByLeave(String leave){
		Date t=null;
		try{
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			t=df.parse(leave);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (List<Book>)getHibernateTemplate()
				.find("from Book where leave=?",t);
	}
		
	//�õ�����δ���ԤԼ
	public List<Book> getCrudeBooks(){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where flag=0 order by roomId");
	};
		
	//�õ�����ԤԼ
	public List<Book> getAllBooks(){
		return (List<Book>)getHibernateTemplate()
				.find("from Book");
	};
	
	//����ԤԼ
	public void saveOrUpdate(Book book){
		try{
			getHibernateTemplate().saveOrUpdate(book);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
