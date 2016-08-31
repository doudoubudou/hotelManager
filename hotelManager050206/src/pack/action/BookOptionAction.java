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
public class BookOptionAction 
	extends ActionSupport{
	private int option;			//��������
	private int bookId;			//ԤԼ���
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
	public void setBookId(int bookId){
		this.bookId=bookId;
	}
	
	public int getBookId(){
		return this.bookId;
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
		Book book=getService.getBook(bookId);
		//��ס����
		if(option==0){
			book.setFlag(1);
			//������ס��¼
			int last=(int)(book.getLeave().getTime()-book.getStart().getTime())/3600000;
			Io io=new Io(book.getCustomerId(),book.getRoomId(),new Date(),
					last);
			saveService.saveIo(io);
		}//ȡ������
		else{
			book.setFlag(2);
		}
		saveService.saveBook(book);
		ctx.put("tip","�����ɹ�");
		//����ԤԼ��
		List<Book> books=getService.getCrudeBooks();
		ctx.put("books",books);
		
		return "bookIn";
	}
}
