package pack.action;

import java.util.Date;
import java.util.List;
import java.text.*;

import pack.dao.*;
import pack.beans.*;
import pack.service.*;

import java.util.*;
import java.io.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//�û���¼�Ŀ�����Action
public class BookAction 
	extends ActionSupport{
	private String start;			//�û�ԤԼ��ʼʱ��
	private String leave;			//�û�ԤԼ�뿪ʱ��
	private Customer customer;		//�ͻ���
	private int roomId;		//ԤԼ�����
	private SaveService saveService;			//����Service
	private GetService getService;				//��ȡService
	private SortService sortService;	//ɸѡService
	private InputStream inputStream;	//��װ�������Ķ�������
	
	//start��getter��setter����
	public void setStart(String start){
		this.start=start;
	}
	
	public String getStart(){
		return this.start;
	}
	
	//leave��getter��setter����
	public void setLeave(String leave){
		this.leave=leave;
	}
	
	public String getLeave(){
		return this.leave;
	}
	
	//user��getter��setter����
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	//roomId��getter��setter����
	public void setRoomId(int roomId){
		this.roomId=roomId;
	}
	
	public int getRoomId(){
		return this.roomId;
	}
	
	//saveService��getter��setter����
	public void setSaveService(SaveService saveService){
		this.saveService=saveService;
	}
	
	public SaveService getSaveService(){
		return this.saveService;
	}
	
	//getService��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//sortService��getter��setter����
	public void setSortService(SortService sortService){
		this.sortService=sortService;
	}
	
	public SortService getSortService(){
		return this.sortService;
	}
	
	//InputStream��getter����
	public InputStream getResult(){
		return this.inputStream;
	}
	
	//Actionִ�з��������ҿ�ԤԼ����
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		if(start!=null){
			//��ȡ��ԤԼ�ͷ�
			List<Room> rooms=sortService.bookSort(start,leave);
			ctx.put("rooms",rooms);
			//�����û�ԤԼ����
			ctx.put("book_start",start);
			ctx.put("book_leave",leave);
		}
		return "book";
	}
	
	//ԤԼ�����ύ
	public String regist()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		//����ͻ���Ϣ
		saveService.saveCustomer(customer);
		
		//����ԤԼ��¼
		Room room=getService.getRoomByNum(roomId);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Customer c=getService.getCustomer(customer.getIc());
		Book book=new Book(room.getId(),c.getId(),df.parse(start),df.parse(leave));
		saveService.saveBook(book);
		
		//��ȡ���пͻ�
		List<Customer> customers=getService.getAllCustomers();
		ctx.getSession().put("customers",customers);
		ctx.put("tip","ԤԼ�ɹ���");
		
		return "book";
	}
}