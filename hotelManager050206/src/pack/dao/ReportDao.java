package pack.dao;

import pack.beans.Report;

import java.util.*;

public interface ReportDao {
	//�������ͳ�Ʊ���
	void saveOrUpdate(Report report);
	//�������ڵõ�ͳ�Ʊ���
	Report getByDate(Date date);
	//����id��ȡͳ�Ʊ���
	Report get(int id);
}
