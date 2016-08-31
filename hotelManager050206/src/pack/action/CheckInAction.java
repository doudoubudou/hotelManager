package pack.action;

import java.util.Date;
import java.util.List;
import java.text.*;

import pack.beans.*;
import pack.service.*;

import java.util.*;
import java.io.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//�û���¼�Ŀ�����Action
public class CheckInAction 
	extends ActionSupport{	
	private int last=0;					//��ס����ʱ��
	private String intime;				//��סʱ��
	private int roomId;					//����id
	private Customer customer;			//�ͻ���
	private GetService getService;		//��ȡService
	private SaveService saveService;	//����Service
	private SortService sortService;	//ɸѡService
	
	//last��getter��setter����
	public void setLast(int last){
		this.last=last;
	}
	
	public int getLast(){
		return this.last;
	}
	
	//last��getter��setter����
	public void setIntime(String intime){
		this.intime=intime;
	}
	
	public String getIntime(){
		return this.intime;
	}
	
	//roomId��getter��setter����
	public void setRoomId(int roomId){
		this.roomId=roomId;
	}
	
	public int getRoomId(){
		return this.roomId;
	}
	
	//customer��getter��setter����
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	//sortService��getter��setter����
	public void setSortService(SortService sortService){
		this.sortService=sortService;
	}
	
	public SortService getSortService(){
		return this.sortService;
	}
	
	//getService��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//saveService��getter��setter����
	public void setSaveService(SaveService saveService){
		this.saveService=saveService;
	}
	
	public SaveService getSaveService(){
		return this.saveService;
	}
	
	//Actionִ�з�����ֱ����ס
	public String execute()
		throws Exception{
		if(last!=0){
			ActionContext ctx=ActionContext.getContext();
			//��ȡ��ԤԼ�ͷ�
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date start=new Date();
			List<Room> rooms=sortService.checkInSort(df.format(start),last);
			ctx.put("rooms",rooms);
			//�����û�ԤԼ����
			ctx.put("checkIn_last",last);
		}
		return "checkIn";
	}
	
	//��ס�����ύ
	public String registCheckIn()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		//����ͻ���Ϣ
		saveService.saveCustomer(customer);
		
		//����ԤԼ��¼
		Room room=getService.getRoomByNum(roomId);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Customer c=getService.getCustomer(customer.getIc());
		Io io=new Io(c.getId(),room.getId(),df.parse(intime),last);
		saveService.saveIo(io);
		
		//��ȡ���пͻ�
		List<Customer> customers=getService.getAllCustomers();
		ctx.getSession().put("customers",customers);
		
		ctx.put("tip","��ס�ɹ���");
		
		return "checkIn";
	}
	
	//Actionִ�з���
	public String bookIn()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		List<Book> books=getService.getCrudeBooks();
		ctx.put("books",books);
		return "bookIn";
	}
}