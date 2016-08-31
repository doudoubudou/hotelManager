package pack.service.impl;

import java.util.*;
import java.text.*;

import pack.beans.*;
import pack.dao.*;
import pack.service.SortService;

//���߼�����ӿڵ�ʵ����
public class SortServiceImpl 
	implements SortService{
	private BookDao bookDao;
	private RoomDao roomDao;
	private IoDao ioDao;

	public void setBookDao(BookDao bookDao){
		this.bookDao=bookDao;
	}

	public BookDao getBookDao(){
		return bookDao;
	}
	
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}

	public RoomDao getRoomDao(){
		return roomDao;
	}
	
	public void setIoDao(IoDao ioDao){
		this.ioDao=ioDao;
	}

	public IoDao getIoDao(){
		return ioDao;
	}

	//ԤԼɸѡ
	public List<Room> bookSort(String s,String l){
		//���ַ���ת��Ϊ����
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date c_start=null;
		Date c_leave=null;
		try{
			c_start=df.parse(s);
			c_leave=df.parse(l);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<Book> books=bookDao.getCrudeBooks(); 
		List<Room> rooms=roomDao.getAllRooms();
		List<Room> results=new ArrayList<Room>();
		List<Io> ios=ioDao.getCurrentIos();
		//���ų��ķ���ű��浽�б���
		List<Integer> remove=new ArrayList<Integer>();
		
		/*����ɸѡ���ҳ������������ķ����*/
		boolean flag=true;
		int roomId=0;
		//����ԤԼ��¼ɸѡ
		for(int i=0;i<books.size();i++){
			Book book=books.get(i);
			Date start=book.getStart();
			Date leave=book.getLeave();
			
			//�Ƴ�12Сʱ
			Calendar c=Calendar.getInstance();
			c.setTime(start);
			c.add(Calendar.MINUTE,12*60);
			start=c.getTime();
			
			c.setTime(leave);
			c.add(Calendar.MINUTE,12*60);
			leave=c.getTime();
			
			int id=book.getRoomId();
			if(!flag){
				if(id!=roomId){
					flag=true;
				}
			}
			
			if(flag){
				if(((start.after(c_start)||start.equals(c_start))&&start.before(c_leave))
						||(leave.after(c_start)&&leave.before(c_leave))
						||((start.before(c_start)||start.equals(c_start))&&leave.after(c_leave))){
					roomId=id;
					remove.add(id);
					flag=false;
				}
			}
		}
		
		//������ס��¼ɸѡ
		for(int i=0;i<ios.size();i++){
			Io io=ios.get(i);
			Date intime=io.getIntime();
			int last=io.getLast();
			Calendar c=Calendar.getInstance();
			c.setTime(intime);
			c.add(Calendar.MINUTE,last*60);
			
			Date leave=c.getTime();
			if(leave.after(c_start)){
				boolean r_flag=true;
				int r_id=io.getRoomId();
				for(int j=0;j<remove.size();j++){
					if(r_id==remove.get(j)){
						r_flag=false;
						break;
					}
				}
				if(r_flag){
					remove.add(r_id);
				}
			}
		}
		
		/*�������������ķ���ô�results�б����Ƴ�*/
		for(int i=0;i<rooms.size();i++){
			boolean r_flag=true;
			int r_id=rooms.get(i).getId();
			for(int j=0;j<remove.size();j++){
				if(r_id==remove.get(j)){
					r_flag=false;
					break;
				}
			}
			if(r_flag){
				results.add(rooms.get(i));
			}
		}
		
		return results;
	}
	
	//������סɸѡ
	public List<Room> checkInSort(String s,int last){
		//ת�����ڸ�ʽ
		DateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
		Date i_start=null;
		Date i_leave=null;
		try{
			i_start=df2.parse(s);
			Calendar c=Calendar.getInstance();
			c.setTime(i_start);
			c.add(Calendar.MINUTE,last*60);
			i_leave=c.getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<Book> books=bookDao.getCrudeBooks(); 
		List<Room> rooms=roomDao.getAllRooms();
		List<Room> results=new ArrayList<Room>();
		List<Io> ios=ioDao.getCurrentIos();
		//���ų��ķ���ű��浽�б���
	    List<Integer> remove=new ArrayList<Integer>();
	    /*����ɸѡ���ҳ������������ķ����*/
		boolean flag=true;
		int roomId=0;
		//����ԤԼ��¼ɸѡ
		for(int i=0;i<books.size();i++){
			Book book=books.get(i);
			Date start=book.getStart();
			Date b_leave=book.getLeave();
			
			//�Ƴ�12Сʱ
			Calendar c=Calendar.getInstance();
			c.setTime(start);
			c.add(Calendar.MINUTE,12*60);
			start=c.getTime();
			
			c.setTime(b_leave);
			c.add(Calendar.MINUTE,12*60);
			b_leave=c.getTime();
			
			int id=book.getRoomId();
			if(!flag){
				if(id!=roomId){
					flag=true;
				}
			}
			
			if(flag){
				if((start.before(i_leave)&&start.after(i_start))){
					roomId=id;
					remove.add(id);
					flag=false;
				}
			}
		}
		//����IOɸѡ
				for(int i=0;i<ios.size();i++){
					Io io=ios.get(i);
					boolean r_flag=true;
				    int r_id=io.getRoomId();
					for(int j=0;j<remove.size();j++){
							if(r_id==remove.get(j)){
								r_flag=false;
								break;
							}
						}
						if(r_flag){
							remove.add(r_id);
						}
			      
			   }
				//������Ŵ�result����ɾ��
				for(int i=0;i<rooms.size();i++){
					boolean r_flag=true;
					int r_id=rooms.get(i).getId();
					for(int j=0;j<remove.size();j++){
						if(r_id==remove.get(j)){
							r_flag=false;
							break;
						}
					}
					if(r_flag){
						results.add(rooms.get(i));
					}
				}
				
				return results;
	}
}
