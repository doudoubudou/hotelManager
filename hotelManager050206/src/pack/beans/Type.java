package pack.beans;

import java.io.*;

public class Type
	implements Serializable{
     private int id;    //�������ͺ�
     private String name;   //����������
     private int price;		//����۸�
     
     public void setId(int id){
          this.id=id;         
     }
     
     public int getId(){
          return id;
     }
     
     public void setName(String name){
          this.name=name;
     }

     public String getName(){
          return name;     
     }
     
     public void setPrice(int price){
         this.price=price;
     }

     public int getPrice(){
         return price;
     }     
}