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
public class IoOptionAction 
	extends ActionSupport{
	private int option;			//��������
	private int ioId;			//ԤԼ���
	private int value;			//��ס����
	private GetService getService;		//��ȡ����Service
	private SaveService saveService;	//��������Service
	
	//option��getter��setter����
	public void setOption(int option){
		this.option=option;
	}
	
	public int getOption(){
		return this.option;
	}
	
	//bookId��getter��setter����
	public void setIoId(int ioId){
		this.ioId=ioId;
	}
	
	public int getIoId(){
		return this.ioId;
	}
	
	//value��getter��setter����
	public void setValue(int value){
		this.value=value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	//saveService��getter��setter�ķ���
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
	
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		Io io=getService.getCurrentIoById(ioId);
		//�˷�����
		if(option==0){
			io.setState(true);
			io.setOuttime(new Date());
			
			saveService.saveIo(io);
		}//��ס����
		else{
			io.setLast(io.getLast()+value*24);
		}
		saveService.saveIo(io);
		ctx.put("tip","�����ɹ�");
		//����ԤԼ��
		List<Io> ios=getService.getCurrentIos();
		ctx.put("ios",ios);
		
		return "checkOut";
	}
}
