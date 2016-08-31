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

//����Ŀ�����Action
public class CheckOutAction 
	extends ActionSupport{
	private GetService getService;		//��ȡService
	
	//getService��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//Actionִ�з��������ҿ�ԤԼ����
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		//��ȡδ�˷�����ס��¼
		List<Io> ios=getService.getCurrentIos();
		ctx.put("ios",ios);
		
		return "checkOut";
	}
}