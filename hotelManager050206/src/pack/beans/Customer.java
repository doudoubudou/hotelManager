package pack.beans;

import java.io.*;

public class Customer
	implements Serializable{
	 private int id;		//�ͻ�id
     private String ic;     //�ͻ����֤��
     private String name;   //�ͻ�����
     private String phone;  //�ͻ��绰
     private boolean sex;   //�ͻ��Ա�
     
     //Customer�Ĺ��췽��
     public Customer(){}
     
     public Customer(String ic,String name,String phone,boolean sex){
    	 this.ic=ic;
    	 this.name=name;
    	 this.phone=phone;
    	 this.sex=sex;
     }
     
     public void setId(int id){
          this.id=id;
     }
  
     public int getId(){
          return id;
     }
     
     public void setIc(String ic){
    	 this.ic=ic;
     }
     
     public String getIc(){
    	 return this.ic;
     }

     public void setName(String name){
          this.name=name;
     }
  
     public String getName(){
          return name;
     }

     public void setPhone(String phone){
          this.phone=phone;
     }
  
     public String getPhone(){
          return phone;
     }

     public void setSex(boolean sex){
          this.sex=sex;
     }
  
     public boolean getSex(){
          return sex;
     }
}