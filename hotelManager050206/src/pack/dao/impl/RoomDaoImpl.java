package pack.dao.impl;

import java.util.List;

import pack.beans.Room;
import pack.dao.RoomDao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//������Dao�ӿڵ�ʵ����
public class RoomDaoImpl 
	extends HibernateDaoSupport implements RoomDao{
	//����RoomId�õ�������
	public Room getById(int id){
		return getHibernateTemplate().get(Room.class,id);
	};
	
	//����RoomNum�õ�������
	public Room getByNum(int num){
		List<Room> rooms=(List<Room>)getHibernateTemplate()
				.find("from Room where num=?", num);
		if(rooms.size()==0){
			return null;
		}else{
			return rooms.get(0);
		}
	};
		
	//�õ����з���Room��
	public List<Room> getAllRooms(){
		return (List<Room>)getHibernateTemplate()
				.find("from Room");
	};
}
