package pack.service.impl;

import pack.beans.*;
import pack.dao.*;
import pack.service.GetService;

import java.util.*;
import java.text.*;

public class GetServiceImpl 
	implements GetService{
	private BookDao bookDao;		//ԤԼ��¼Dao
	private RoomDao roomDao;		//����Dao
	private CustomerDao customerDao;		//�ͻ�Dao
	private TypeDao typeDao;		//��������Dao
	private IoDao ioDao;			//�����¼Dao
	private ReportDao reportDao;	//����Dao
	
	//bookDao��getter��setter����
	public void setBookDao(BookDao bookDao){
		this.bookDao=bookDao;
	}
	
	public BookDao getBookDao(){
		return this.bookDao;
	}
	
	//bookDao��getter��setter����
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}
	
	public RoomDao getRoomDao(){
		return this.roomDao;
	}
	
	//adminDao��getter��setter����
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao=customerDao;
	}
		
	public CustomerDao getCustomerDao(){
		return this.customerDao;
	}
	
	//typeDao��getter��setter����
	public void setTypeDao(TypeDao typeDao){
		this.typeDao=typeDao;
	}
	
	public TypeDao getTypeDao(){
		return this.typeDao;
	}
	
	//IoDao��getter��setter����
	public void setIoDao(IoDao ioDao){
		this.ioDao=ioDao;
	}
	
	public IoDao getIoDao(){
		return this.ioDao;
	}
	
	//reportDao��getter��setter����
	public void setReportDao(ReportDao reportDao){
		this.reportDao=reportDao;
	}
	
	public ReportDao getReportDao(){
		return this.reportDao;
	}
	
	//��ȡԤԼ��¼
	public Book getBook(int id){
		return bookDao.get(id);
	}
	
	//��ȡָ��id,δ��ס��ԤԼ��¼
	public Book getCrudeBook(int id){
		return bookDao.getCrudeById(id);
	}
	
	//���ݿͻ�������ȡԤԼ��¼
	public List<Book> getBooksByName(String name){
		List<Customer> customers=customerDao.getByName(name);
		List<Book> results=new ArrayList<Book>();
		for(int i=0;i<customers.size();i++){
			Customer customer=customers.get(i);
			List<Book> books=bookDao.getByCustomerId(customer.getId());
			if(books.size()!=0){
				results.addAll(books);
			}
		}
		
		return results;
	}
	
	//��ȡָ���ͻ����֤��ԤԼ��¼
	public List<Book> getBooksByIc(String ic){
		Customer customer=customerDao.getByIc(ic);
		List<Book> books=new ArrayList<Book>();
		if(customer!=null){
			books=bookDao.getByCustomerId(customer.getId());
		}
		
		return books;
	}
	
	//��ȡָ���ͻ����֤��ԤԼ��¼
	public List<Book> getCrudeBooksByIc(String ic){
		Customer customer=customerDao.getByIc(ic);
		List<Book> books=new ArrayList<Book>();
		if(customer!=null){
			books=bookDao.getCrudeByCustomerId(customer.getId());
		}
		
		return books;
	}
	
	//��ȡָ���ͻ��ֻ��ŵ�ԤԼ��¼
	public List<Book> getBooksByPhone(String phone){
		Customer customer=customerDao.getByPhone(phone);
		List<Book> books=new ArrayList<Book>();
		if(customer!=null){
			books=bookDao.getByCustomerId(customer.getId());
		}
		
		return books;
	}
	
	//��ȡָ��ԤԼʱ���ԤԼ��¼
	public List<Book> getBooksByTime(String time){
		return bookDao.getByTime(time);
	}
	
	//��ȡָ��ԤԼ��סʱ���ԤԼ��¼
	public List<Book> getBooksByStart(String start){
		return bookDao.getByStart(start);
	}
	
	//��ȡָ��ԤԼ�˷�ʱ���ԤԼ��¼
	public List<Book> getBooksByLeave(String leave){
		return bookDao.getByLeave(leave);
	}
	
	//��ȡָ������ŵ�ԤԼ��¼
	public List<Book> getBooksByRoomNum(int roomNum){
		Room room=roomDao.getByNum(roomNum);
		List<Book> books=new ArrayList<Book>();
		if(room!=null){
			books=bookDao.getByRoomId(room.getId());
		}
		
		return books;
	}
	
	//��ȡ����δ��ɼ�¼
	public List<Book> getCrudeBooks(){
		return bookDao.getCrudeBooks();
	}
	
	//��ȡ����ԤԼ��¼
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	
	//��ȡ����δ�˷�����ס��¼
	public List<Io> getCurrentIos(){
		return ioDao.getCurrentIos();
	}
	
	//��ȡ������ס��¼
	public List<Io> getAllIos(){
		return ioDao.getAllIos();
	}
	
	//������סid��ȡδ�˷�����ס��¼
	public Io getCurrentIoById(int id){
		return ioDao.getCurrentIoById(id);
	}
	
	//���ݿͻ����֤�Ż�ȡδ�˷�����ס��¼
	public Io getCurrentIoByIc(String ic){
		Customer customer=customerDao.getByIc(ic);
		return ioDao.getCurrentIoByCustomerId(customer.getId());
	}
	
	//��ȡ������
	public Room getRoomByNum(int num){
		return roomDao.getByNum(num);
	}
	
	//��ȡ���з���
	public List<Room> getAllRooms(){
		return roomDao.getAllRooms();
	}
	
	//��ȡ���з�������
	public List<Type> getAllTypes(){
		return typeDao.getAllTypes();
	}
	
	//��ȡָ��ic���û���
	public Customer getCustomer(String ic){
		return customerDao.getByIc(ic);
	}
	
	//��ȡ�����û���
	public List<Customer> getAllCustomers(){
		return customerDao.getAllCustomers();
	}
	
	//��ȡ���ձ���
	public Report getTodayReport(){
		Date date=new Date();
		Report report=reportDao.getByDate(date);
		
		return report;
	}
}
