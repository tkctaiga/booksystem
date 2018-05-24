package b.bean;
import java.io.Serializable;
import java.sql.Date;

public class UserTopBean implements Serializable
{
    private String name;
    private Date bookday;
    private Date bookdayr;

    public UserTopBean()
    {

    }
    public UserTopBean(String name,Date day,Date dayr)
    {
        this.name = name;
        this.bookday = day;
        this.bookdayr = dayr;
    }
    public String getName()
    {
	     return name;
	}
    public void setName(String name)
    {
        this.name = name;
    }
    public Date getBookday()
    {
	     return bookday;
	}
    public void setBookday(Date bookday)
    {
        this.bookday = bookday;
    }
    public Date getBookdayr()
    {
	     return bookdayr;
	}
    public void setBookdayr(Date bookdayr)
    {
        this.bookdayr = bookdayr;
    }
}
