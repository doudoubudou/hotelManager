package pack.action;

import java.util.ArrayList;
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

public class BookQueryAction 
	extends ActionSupport{
	private int condition;		//��ѯ����
	private String value;			//��ѯ����
	private GetService getService;	//��ȡ����Service
	
	//condition��getter��setter����
	public void setCondition(int condition){
		this.condition=condition;
	}
	
	public int getCondition(){
		return this.condition;
	}
	
	//value��getter��setter����
	public void setValue(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	//getService��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//Action��ִ�з���
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		List<Book> books=new ArrayList<Book>();
		//����ԤԼ�Ż�ȡԤԼ��¼
		if(condition==1){
			books.add(getService.getCrudeBook(Integer.parseInt(value)));
		}else if(condition==2){
			books=getService.getCrudeBooksByIc(value);
		}
		ctx.put("books",books);
		
		return "bookIn";
	}
}
