package b.bean;
import java.io.Serializable;

public class UserBean implements Serializable
{
      private String password;
      private int id;
      private String name;
      private String address;
      private String number1;
      private String number2;
      private String number3;
      private String birthday1;
      private String birthday2;
      private String birthday3;
      private String sex;
      private String userrole;

      public UserBean(int id, String password){
            this.id = id;
            this.password = password;
      }

      public UserBean(int id, String password, String userrole){
            this.id = id;
            this.password = password;
            this.userrole = userrole;
      }

      public UserBean(String password, int id, String name, String address, String number1, String number2, String number3,
                      String birthday1, String birthday2, String birthday3, String sex){
            this.password = password;
            this.id = id;
            this.name = name;
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

      public int id(){
    	     return id;
      }

      public String getName(){
             return name;
      }

      public void setName(String name){
             this.name = name;

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

      public void getNumber1(String number1){
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

      public String getbirthday1(){
    	     return birthday1;
      }

      public void setBirthday1(String birthday1){
    	     this.birthday1 = birthday1;
      }

      public String getbirthday2(){
 	     return birthday2;
      }

      public void setBirthday2(String birthday2){
 	     this.birthday2 = birthday2;
      }

      public String getbirthday3(){
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

      public String getUserrole(){
    	     return userrole;
      }

      public void setUserrole(String userrole){
    	     this.userrole = userrole;
      }
}
