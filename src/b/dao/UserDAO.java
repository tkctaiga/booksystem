package b.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import b.bean.UserBean;

public class UserDAO{
	private Connection con;

	public UserDAO()throws DAOException{
		getConnection();
	}

	public int saveUser(UserBean user)throws DAOException{
		if(con == null){
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
			String phone = user.getNumber1() + user.getNumber2() + user.getNumber3();
			String zip = user.getPostal1() + user.getPostal2();
			String birth = user.getBirthday1() + "-" + user.getBirthday2() + "-" + user.getBirthday3();
			Date formatdate = Date.valueOf(birth);
			int userNumber = 0;
			String sql = "select nextval('users_user_id_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				userNumber = rs.getInt(1);
			}
			rs.close();
			st.close();
			sql = "insert into users(user_id, user_name, user_sex, user_postal, user_address, "
					+ "user_tel, user_birthday, user_password) VALUES(?,?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			//プレースホルダーの設定;
			st.setInt(1, userNumber);
			st.setString(2, user.getName());
			st.setInt(3, Integer.parseInt(user.getSex()));
			st.setString(4, zip);
			st.setString(5, user.getAddress());
			st.setString(6, phone);
			st.setDate(7, formatdate);
			st.setString(8, user.getPassword());
			//SQLの実行
			st.executeUpdate();
			st.close();
			return userNumber;


		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
				close();
			}catch(Exception e){
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	private void getConnection()throws DAOException{
		try{
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:webbook";
			String user = "mybook";
			String pass = "book1";

			con = DriverManager.getConnection(url, user, pass);
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close()throws SQLException{
		if(con != null){
			con.close();
			con = null;
		}
	}
}
