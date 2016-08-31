package pack.action;

import java.util.List;
import java.text.*;

import pack.beans.*;
import pack.dao.TypeDao;
import pack.service.*;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//�û���¼�Ŀ�����Action
public class LoginAction 
	extends ActionSupport{
	private String userName;		//����Ա�û���
	private String password;		//����Ա����
	private GetService getService;		//��ȡService
	private LoginService loginService;	//��¼Service
	
	//typeDao��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//��¼Service��getter��setter����
	public void setLoginService(LoginService loginService){
		this.loginService=loginService;
	}
	
	public LoginService getLoginService(){
		return this.loginService;
	}
	
	//userName��getter��setter����
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	//password��getter��setter����
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	//actionִ�з���
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		//���ݲ�����ȡ����Ա����
		boolean flag=loginService.check(userName, password);
		if(!flag){
			ctx.put("tip","�û��������벻ƥ�䣡");
			return "loginPage";
		}else{
			//�������Ա
			Admin admin=new Admin(userName,password);
			ctx.getSession().put("admin",admin);
			
			//��ȡ���������б�
			List<Type> types=getService.getAllTypes();
			ctx.getSession().put("types",types);
			
			//��ȡ���з���
			List<Room> rooms=getService.getAllRooms();
			ctx.getSession().put("rooms",rooms);
			
			//��ȡ���пͻ�
			List<Customer> customers=getService.getAllCustomers();
			ctx.getSession().put("customers",customers);
			return "book";
		}
	}
}
