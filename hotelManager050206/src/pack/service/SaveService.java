package pack.service;

import pack.dao.*;
import pack.beans.*;

//�����¼��ҵ���߼��Ľӿ�
public interface SaveService {
	//����ͻ���Ϣ
	void saveCustomer(Customer customer);
	
	//����ԤԼ��¼
	void saveBook(Book book);
	
	//����ԤԼ��¼
	void saveReport(Report report);
	
	//��������¼
	void saveIo(Io io);
}
