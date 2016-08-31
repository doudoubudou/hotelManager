package pack.action;

import pack.beans.*;
import pack.service.*;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
//�ͻ�����Action
public class CustomerAction 
	extends ActionSupport{
	private GetService getService;		//��ȡ����Service
	
	//GetService��getter��setter����
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
		
		//��ȡ�ͻ���Ϣ
		List<Customer> customers=getService.getAllCustomers();
		ctx.put("customers",customers);
		
		return "customerInf";
	}
}
