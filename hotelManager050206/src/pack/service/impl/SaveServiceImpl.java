package pack.service.impl;

import pack.beans.*;
import pack.dao.*;
import pack.service.SaveService;

import java.util.*;

//����ҵ���߼��ӿڵ�ʵ����
public class SaveServiceImpl 
	implements SaveService{
	private CustomerDao customerDao;
	private BookDao bookDao;
	private ReportDao reportDao;
	private IoDao ioDao;
	private RoomDao roomDao;
	private TypeDao typeDao;
	
	//customerDao��getter��setter����
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao=customerDao;
	}
	
	public CustomerDao getCustomerDao(){
		return this.customerDao;
	}
	
	//bookDao��getter��setter����
	public void setBookDao(BookDao bookDao){
		this.bookDao=bookDao;
	}
	
	public BookDao getBookDao(){
		return this.bookDao;
	}
	
	//reportDao��getter��setter����
	public void setReportDao(ReportDao reportDao){
		this.reportDao=reportDao;
	}
	
	public ReportDao getReportDao(){
		return this.reportDao;
	}
	
	//reportDao��getter��setter����
	public void setIoDao(IoDao ioDao){
		this.ioDao=ioDao;
	}
	
	public IoDao getIoDao(){
		return this.ioDao;
	}
	
	//roomDao��getter��setter����
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}
	
	public RoomDao getRoomDao(){
		return this.roomDao;
	}
	
	//typeDao��getter��setter����
	public void setTypeDao(TypeDao typeDao){
		this.typeDao=typeDao;
	}
	
	public TypeDao getTypeDao(){
		return this.typeDao;
	}
	
	//����ͻ���Ϣ
	public void saveCustomer(Customer customer){
		customerDao.saveOrUpdate(customer);
	}
		
	//����ԤԼ��¼
	public void saveBook(Book book){
		bookDao.saveOrUpdate(book);
		Report report=reportDao.getByDate(new Date());
		if(report==null){
			report=new Report(new Date());
			reportDao.saveOrUpdate(report);
		}
		report.setOrdersum(report.getOrdersum()+1);
		saveReport(report);
	}
	
	//��������¼
	public void saveIo(Io io){
		ioDao.saveOrUpdate(io);
		Report report=reportDao.getByDate(new Date());
		if(report==null){
			report=new Report(new Date());
			reportDao.saveOrUpdate(report);
		}
		report.setCheckin(report.getCheckin()+1);
		Room room=roomDao.getById(io.getRoomId());
		Type type=typeDao.get(room.getTypeId());
		report.setIncome(report.getIncome()+type.getPrice());
		saveReport(report);
	}
	
	//���汨���¼
	public void saveReport(Report report){
		reportDao.saveOrUpdate(report);
	}
}
