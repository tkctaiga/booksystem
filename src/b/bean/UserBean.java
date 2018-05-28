package b.bean;
import java.io.Serializable;

public class UserBean implements Serializable
{
      private String password;
      private String id;
      private String name;
      private String postal1;
      private String postal2;
      private String address;
      private String number1;
      private String number2;
      private String number3;
      private String birthday1;
      private String birthday2;
      private String birthday3;
      private String sex;

      public UserBean(String id, String password){
            this.id = id;
            this.password = password;
      }

      public UserBean(String password, String name, String postal1, String postal2, String address,
    		  String number1, String number2, String number3, String birthday1, String birthday2, String birthday3, String sex){
            this.password = password;
            this.name = name;
            this.postal1 = postal1;
            this.postal2 = postal2;
            this.address = address;
            this.number1 = number1;
            this.number2 = number2;
            this.number3 = number3;
            this.birthday1 = birthday1;
            this.birthday2 = birthday2;
            this.birthday3 = birthday3;
            this.sex = sex;
      }

      public UserBean(){

      }

      public String getPassword(){
    	     return password;

      }

      public void setPassword(String password){
             this.password = password;
      }

      public String getId(){
    	     return id;
      }

      public void setId(String id){
    	     this.id = id;
      }

      public String getName(){
             return name;
      }

      public void setName(String name){
             this.name = name;

      }

      public String getPostal1(){
    	     return postal1;
      }

      public void setPostal1(String postal1){
    	     this.postal1 = postal1;
      }

      public String getPostal2(){
 	         return postal2;
      }

      public void setPostal2(String postal2){
 	         this.postal2 = postal2;
      }

      public String getAddress(){
             return address;
      }

      public void setAddress(String address){
             this.address = address;
      }

      public String getNumber1(){
    	     return number1;

      }

      public void setNumber1(String number1){
             this.number1 =number1;
      }

      public String getNumber2(){
             return number2;
      }

      public void setNumber2(String number2){
             this.number2 = number2;
      }

      public String getNumber3(){
             return number3;
      }

      public void setNumber3(String number3){
             this.number3 =number3;
      }

      public String getBirthday1(){
    	     return birthday1;
      }

      public void setBirthday1(String birthday1){
    	     this.birthday1 = birthday1;
      }

      public String getBirthday2(){
 	     return birthday2;
      }

      public void setBirthday2(String birthday2){
 	     this.birthday2 = birthday2;
      }

      public String getBirthday3(){
  	     return birthday3;
      }

      public void setBirthday3(String birthday3){
  	     this.birthday3 = birthday3;
      }


      public String getSex(){
             return sex;
      }

      public void setSex(String sex){
    	     this.sex = sex;
      }

}
