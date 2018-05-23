package b.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import b.bean.bookBean;

public class bookDao
{
	private Connection con;
	public bookDao() throws DAOException
	{
		getConnection();
	}
	public List<bookBean>findAll() throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "SELECT * FROM Bookinfo";

			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<bookBean>list = new ArrayList<bookBean>();
			while(rs.next())
			{
				String isbn = rs.getString("bookinfo_isbn");
				String ccode = rs.getString("category_code");
				String pcode = rs.getString("publisher_code");
				String name = rs.getString("bookinfo_name");
				String author = rs.getString("bookinfo_author");
				bookBean bean = new bookBean(isbn,ccode,pcode,name,author);
				list.add(bean);
			}
		return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}finally{
			try
			{
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e)
			{
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	public List<bookBean>findsearch(String searchname,String category) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql;
			if(searchname.equals(""))
			{
				//ケース1 検索名なしカテゴリ検索なしの場合
				if(category.equals("10"))
				{
					sql = "SELECT b.bookinfo_isbn,c.category_name,b.bookinfo_name,b.bookinfo_author,p.publisher_name FROM bookinfo b, publisher p,category c WHERE b.publisher_code = p.publisher_code AND b.category_code = c.category_code";
					st = con.prepareStatement(sql);

				}
				//ケース2 検索名なしカテゴリ検索ありの場合
				else
				{
					sql = "SELECT b.bookinfo_isbn,c.category_name,b.bookinfo_name,b.bookinfo_author,p.publisher_name FROM bookinfo b, publisher p,category c WHERE b.category_code = ? AND b.publisher_code = p.publisher_code AND b.category_code = c.category_code";
					st = con.prepareStatement(sql);
					st.setString(1,category);
				}
			}
			else
			{
				//ケース3 検索名ありカテゴリ検索なしの場合
				if(category.equals("10"))
				{
					sql = "SELECT b.bookinfo_isbn,c.category_name,b.bookinfo_name,b.bookinfo_author,p.publisher_name FROM bookinfo b, publisher p,category c WHERE b.publisher_code = p.publisher_code AND b.category_code = c.category_code AND b.bookinfo_name LIKE ?";
					st = con.prepareStatement(sql);
					st.setString(1,"%"+searchname+"%");
				}
				//ケース4 検索名ありカテゴリ検索ありの場合
				else
				{
					sql = "SELECT b.bookinfo_isbn,c.category_name,b.bookinfo_name,b.bookinfo_author,p.publisher_name FROM bookinfo b, publisher p,category c WHERE category_code = ? AND b.publisher_code = p.publisher_code AND b.category_code = c.category_code AND b.bookinfo_name LIKE ?";
					st = con.prepareStatement(sql);
					st.setString(1,category);
					st.setString(2,"%"+searchname+"%");
				}
			}
			rs = st.executeQuery();
			List<bookBean>list = new ArrayList<bookBean>();
			while(rs.next())
			{
				String isbn = rs.getString("bookinfo_isbn");
				String ccode = rs.getString("category_name");
				String pcode = rs.getString("publisher_name");
				String name = rs.getString("bookinfo_name");
				String author = rs.getString("bookinfo_author");
				bookBean bean = new bookBean(isbn,ccode,pcode,name,author);
				list.add(bean);
			}
		return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}finally{
			try
			{
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e)
			{
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	public List<bookBean>findconfim(String uname) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "SELECT b.bookinfo_isbn,c.category_name,b.bookinfo_name,b.bookinfo_author,p.publisher_name FROM bookinfo b, publisher p,category c WHERE b.publisher_code = p.publisher_code AND b.category_code = c.category_code AND b.bookinfo_name = ?";

			st = con.prepareStatement(sql);
			st.setString(1,uname);
			System.out.println("とってきた値" + uname);
			rs = st.executeQuery();
			List<bookBean>list = new ArrayList<bookBean>();
			while(rs.next())
			{
				String isbn = rs.getString("bookinfo_isbn");
				String ccode = rs.getString("category_name");
				String pcode = rs.getString("publisher_name");
				String name = rs.getString("bookinfo_name");
				String author = rs.getString("bookinfo_author");
				bookBean bean = new bookBean(isbn,ccode,pcode,name,author);
				list.add(bean);
			}
		return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}finally{
			try
			{
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e)
			{
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}
	private void getConnection() throws DAOException
	{
		try
		{
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			// URL、ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:webbook";
			String user = "mybook";
			String pass = "book1";
			con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new DAOException("接続に失敗しました");
		}
	}

	private void close()throws SQLException
	{
		if(con != null)
		{
			con.close();
			con = null;
		}

	}

}

