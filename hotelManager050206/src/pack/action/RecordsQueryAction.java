package pack.action;

import pack.beans.*;
import pack.service.*;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//��¼��ѯAction
public class RecordsQueryAction 
	extends ActionSupport{
	private int state;					//���ò�ѯ����
	private int condition=0;			//���ò�ѯ��׼
	private String value;				//���þ����ѯ����
	private GetService getService;		//��ȡ���ݿ�Service
	
	//state��getter��setter����
	public void setState(int state){
		this.state=state;
	}
	
	public int getState(){
		return this.state;
	}
	
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
		//state=0:��ȡԤԼ��¼
		if(state==0){
			List<Book> books=new ArrayList<Book>();
			if(condition==0){
				books=getService.getAllBooks();
			}else{
				//ԤԼ�Ų���
				if(condition==1){
					books.add(getService.getBook(Integer.parseInt(value)));
				}//�ͻ���������
				else if(condition==2){
					books=getService.getBooksByName(value);
				}//�ͻ����֤����
				else if(condition==3){
					books=getService.getBooksByIc(value);
				}//�ͻ��ֻ��Ų���
				else if(condition==4){
					books=getService.getBooksByPhone(value);
				}//ԤԼʱ�����
				else if(condition==5){
					books=getService.getBooksByTime(value);
				}//ԤԼ��סʱ�����
				else if(condition==6){
					books=getService.getBooksByStart(value);
				}//ԤԼ�˷�ʱ�����
				else if(condition==7){
					books=getService.getBooksByLeave(value);
				}
				//����id����
				else if(condition==8){
					books=getService.getBooksByRoomNum(Integer.parseInt(value));
				}
			}
			ctx.put("books",books);
			return "bookRecords";
		}//state=1:��ȡ��ס��¼
		else{
			//��ȡ������ס��¼
			List<Io> ios=getService.getAllIos();
			ctx.put("ios",ios);
			
			return "ioRecords";
		}
	}
}