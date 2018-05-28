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

import b.bean.RentalBean;

public class RentalUserDao
{
	private Connection con;
	public RentalUserDao() throws DAOException
	{
		getConnection();
	}
	public List<RentalBean>RenSearch(String username) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "";
			//検索ボックスにIDあり
			if(username.equals(""))
			{
				sql = "SELECT user_id,user_name FROM users";
				st = con.prepareStatement(sql);
			}//IDなし
			else
			{
				sql = "SELECT user_id,user_name FROM users WHERE user_id = ?";
				st = con.prepareStatement(sql);
				st.setInt(1,Integer.parseInt(username));
			}
			rs = st.executeQuery();
			List<RentalBean>list = new ArrayList<RentalBean>();
			while(rs.next())
			{
				String name = rs.getString("user_name");
				int id = rs.getInt("user_id");
				RentalBean bean = new RentalBean(id,name);
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

	public List<RentalBean>RenDetail(int uid) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql = "SELECT u.user_id,u.user_name,bi.bookinfo_name,r.rental_roal FROM users u,rental r,bookstate bs,bookinfo bi WHERE u.user_id = r.user_id AND r.bookstate_id = bs.bookstate_id AND bs.bookinfo_isbn = bi.bookinfo_isbn AND r.rental_return IS NULL AND u.user_id = ?";

			st = con.prepareStatement(sql);
			st.setInt(1,uid);
			rs = st.executeQuery();
			List<RentalBean>list = new ArrayList<RentalBean>();
			while(rs.next())
			{
				String name = rs.getString("user_name");
				int id = rs.getInt("user_id");
				String bname = rs.getString("bookinfo_name");
				Date renday = rs.getDate("rental_roal");
				Calendar cal = Calendar.getInstance();
				cal.setTime(renday);
				cal.add(Calendar.DATE,15);
				Date rendayrem = new Date(cal.getTimeInMillis());
				RentalBean bean = new RentalBean(id,name,bname,renday,rendayrem);
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

	public void userchangepass(String id,String cpass) throws DAOException
	{
		if(con == null)
			getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String sql ="UPDATE USERS SET user_password = ? WHERE user_id = ?";
			st = con.prepareStatement(sql);
			st.setString(1,cpass);
			st.setInt(2,Integer.parseInt(id));
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
}
