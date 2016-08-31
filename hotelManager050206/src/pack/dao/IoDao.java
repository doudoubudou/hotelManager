package pack.dao;

import pack.beans.Io;
import java.util.*;

public interface IoDao {
	//����id��ȡ��ס��¼
	Io get(int id);
	
	//��ȡ������ס��¼
	List<Io> getCurrentIos();
	
	//��ȡ������ס��¼
	List<Io> getAllIos();
	
	//������סid��ȡδ�˷��ļ�¼
	Io getCurrentIoById(int id);
	
	//���ݿͻ����֤��ȡδ�˷��ļ�¼
	Io getCurrentIoByCustomerId(int id);
	
	//������ס��¼
	void saveOrUpdate(Io io);
}
