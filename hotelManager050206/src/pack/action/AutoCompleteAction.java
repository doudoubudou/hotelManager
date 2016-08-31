package pack.action;

import java.io.*;

import pack.beans.Customer;
import pack.service.GetService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//�Զ���д��Action
public class AutoCompleteAction 
	extends ActionSupport{
	private String ic;		//���֤��
	private GetService getService;	//��ȡ���ݵ�Service
	private InputStream inputStream;//��װ�������Ķ�������
	
	//id��setter��getter����
	public void setIc(String ic){
		this.ic=ic;
	}
	
	public String getIc(){
		return this.ic;
	}
	
	//getService��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//InputStream��getter����
	public InputStream getResult(){
		return this.inputStream;
	}
	
	//action��ִ�з���
	public String execute()
		throws Exception{
		Customer customer=getService.getCustomer(ic);
		String s="";
		if(customer!=null){
			s+=customer.getName()+"@";
			s+=customer.getPhone()+"@";
			s+=customer.getSex();
		}
		inputStream=(customer==null)?
				new ByteArrayInputStream(" ".getBytes("UTF-8")):
				new ByteArrayInputStream(s.getBytes("UTF-8"));
				
		return "complete";
	}
}
