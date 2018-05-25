package b.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import b.bean.UserTopBean;
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
			String sql = "SELECT bi.bookinfo_name,bs.bookstate_id FROM bookinfo bi,bookstate bs WHERE bi.bookinfo_isbn = bs.bookinfo_isbn AND bi.bookinfo_name = ? AND NOT EXISTS (SELECT bs.bookstate_id FROM Rental WHERE bs.bookstate_id = bookstate_id AND rental_return IS NULL)";

			st = con.prepareStatement(sql);
			st.setString(1,uname);

			rs = st.executeQuery();
			List<bookBean>list = new ArrayList<bookBean>();
			while(rs.next())
			{
				String name = rs.getString("bookinfo_name");
				int id = rs.getInt("bookstate_id");
				bookBean bean = new bookBean(name,id);
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

	public List<UserTopBean>findtop() throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "SELECT u.user_id,u.user_name,r.bookstate_id,bi.bookinfo_name,r.rental_roal,r.rental_dead,r.rental_return,r.rental_id FROM users u,rental r,bookstate bs,bookinfo bi WHERE u.user_id = r.user_id AND bs.bookinfo_isbn = bi.bookinfo_isbn AND r.bookstate_id = bs.bookstate_id AND u.user_name = '水沼　次郎' AND r.rental_return IS NULL";

			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<UserTopBean>list = new ArrayList<UserTopBean>();
			while(rs.next())
			{
				String m_name = rs.getString("bookinfo_name");
				Date m_date = rs.getDate("rental_roal");
				Date m_dater = rs.getDate("rental_dead");
				int m_renid = rs.getInt("rental_id");
				UserTopBean bean = new UserTopBean(m_name,m_date,m_dater,m_renid);
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

	public int returnRentalid()
			throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			int indexnum = 0;
			String sql = "SELECT nextval('rental_rental_id_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next())
			{
				indexnum  = rs.getInt(1);
			}
			return indexnum;
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



	public void AddRental(int setnumber,int booknum)throws DAOException{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "INSERT INTO Rental VALUES(?,?,2,?,NULL,?)";
			st = con.prepareStatement(sql);
			st.setInt(1,setnumber);
			st.setInt(2,booknum);
			Date today = new Date(System.currentTimeMillis());
			st.setDate(3,today);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE,15);
			today = new Date(cal.getTimeInMillis());
			st.setDate(4,today);
			st.executeUpdate();
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
	public void returnbookupdate(int rentalid) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql ="UPDATE RENTAL SET rental_return = ? WHERE rental_id = ?";

			st = con.prepareStatement(sql);
			Date today = new Date(System.currentTimeMillis());
			st.setDate(1,today);
			st.setInt(2,rentalid);
			st.executeUpdate();
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

	public List<UserTopBean>returnconfim(int uid,int rennum) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "SELECT bi.bookinfo_name,r.rental_id,r.rental_roal,r.rental_return,r.rental_dead FROM Bookinfo bi,BookState bs,Rental r WHERE bi.bookinfo_isbn = bs.bookinfo_isbn AND bs.bookstate_id = r.bookstate_id AND r.user_id = ? AND r.rental_return IS NULL AND r.rental_id = ?";

			st = con.prepareStatement(sql);
			st.setInt(1,uid);
			st.setInt(2,rennum);
			rs = st.executeQuery();
			List<UserTopBean>list = new ArrayList<UserTopBean>();
			while(rs.next())
			{
				String m_name = rs.getString("bookinfo_name");
				Date m_date = rs.getDate("rental_roal");
				Date m_dater = rs.getDate("rental_dead");
				int m_renid = rs.getInt("rental_id");
				UserTopBean bean = new UserTopBean(m_name,m_date,m_dater,m_renid);
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

}

