package b.bean;
import java.io.Serializable;

public class bookBean implements Serializable
{
	//ISBNコード
	private String book_isbn;
	//カテゴリーコード
	private String book_categorycode;
	//出版社
	private String book_publishercode;
	//本の名前
	private String book_name;
	//本の著者
	private String book_author;

	public bookBean(String isbn,String categorycode,String publishercode,String name,String author)
	{
		//ISBNコード
		this.book_isbn = isbn;
		//カテゴリーコード
		this.book_categorycode = categorycode;
		//出版社
		this.book_publishercode = publishercode;
		//本の名前
		this.book_name = name;
		//本の著者
		this.book_author = author;
	}

	public bookBean()
	{
	}
	public String getIsbn()
	{
		return book_isbn;
	}
	public void setIsbn(String isbn)
	{
		this.book_isbn = isbn;
	}
	public String getCategorycode()
	{
		return book_categorycode;
	}
	public void setCategorycode(String categorycode)
	{
		this.book_categorycode = categorycode;
	}
	public String getPublishercode()
	{
		return book_publishercode;
	}
	public void setPublishercode(String publishercode)
	{
		this.book_publishercode = publishercode;
	}
	public String getName()
	{
		return book_name;
	}
	public void setName(String name)
	{
		this.book_name = name;
	}
	public String getAuthor()
	{
		return book_author;
	}
	public void setAuthor(String author)
	{
		this.book_author = author;
	}

}