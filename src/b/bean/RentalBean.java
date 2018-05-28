package b.bean;
import java.io.Serializable;
import java.sql.Date;

public class RentalBean implements Serializable
{
	//ユーザーID
	private int userid;
	//ユーザーの名前
	private String username;
	//ユーザーの借りている本
	private String userbooks;
	//ユーザーの借りた本の日
    private Date userbooksday;
    //ユーザーの返却日
    private Date userbooksrenday;

    public RentalBean ()
    {

    }
    public RentalBean (int userid,String username)
    {
    	this.userid = userid;
    	//ユーザーの名前
    	this.username = username;
    }
    public RentalBean(int id,String name,String books,Date booksday,Date booksrenday)
    {
    	//ユーザーID
    	this.userid = id;
    	//ユーザーの名前
    	this.username = name;
    	//ユーザーの本
    	this.userbooks = books;
    	//ユーザーの借りた本の日
    	this.userbooksday = booksday;
        //ユーザーの返却日
    	this.userbooksrenday = booksrenday;
    }
    public int getId()
    {
	     return userid;
	}
    public void setId(int id)
    {
        this.userid = id;
    }
    public String getName()
    {
	     return username;
	}
    public void setName(String name)
    {
        this.username = name;
    }
    public String getUserbooks()
    {
	     return userbooks;
	}
    public void setUserbooks(String userbooks)
    {
        this.userbooks = userbooks;
    }
    public Date getUserbooksday()
    {
	     return userbooksday;
	}
    public void setUserbooksday(Date userbooksday)
    {
        this.userbooksday = userbooksday;
    }
    public Date getUserbooksrenday()
    {
	     return userbooksrenday;
	}
    public void setUserbooksrenday(Date userbooksrenday)
    {
        this.userbooksrenday = userbooksrenday;
    }
}
