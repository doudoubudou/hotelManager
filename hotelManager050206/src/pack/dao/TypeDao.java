package pack.dao;

import pack.beans.Type;

import java.util.*;

//Type���Dao�ӿ�
public interface TypeDao {
	//����ID�õ�Type��
	Type get(int id);
	
	//��ȡ����Type��
	List<Type> getAllTypes();
}
