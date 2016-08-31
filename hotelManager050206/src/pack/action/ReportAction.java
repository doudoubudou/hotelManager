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
public class ReportAction 
	extends ActionSupport{
	private int state;					//��������ѡ��
	private GetService getService;		//��ȡ����Service
	private SaveService saveService;	//��������Service
	
	//state��getter��setter����
	public void setState(int state){
		this.state=state;
	}
	
	public int getState(){
		return this.state;
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
	
	//Actionִ�з��������ҿ�ԤԼ����
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		List<Report> reports=new ArrayList<Report>();
		//���ձ���
		if(state==0){
			Report report=getService.getTodayReport();
			if(report==null){
				report=new Report(new Date());
				saveService.saveReport(report);
			}
			report=getService.getTodayReport();
			reports.add(report);
		}
		ctx.put("reports",reports);
		
		return "report";
	}
}