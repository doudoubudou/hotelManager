package pack.dao;

import pack.beans.Room;

import java.util.*;

//����Room�ӿ�
public interface RoomDao {
	//����RoomId�õ�������
	Room getById(int id);
	
	//����RoomNum�õ�������
	Room getByNum(int num);
	
	//�õ����з���Room��
	List<Room> getAllRooms();
}
