package b.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordDAO{
	private Connection con;

	public ChangePasswordDAO()throws DAOException{
		getConnection();
	}

	public int ConfirmPw(int uid, String pw)throws DAOException{
		if(con == null){
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;

		try{
			int result = 0;
			String sql = "SELECT user_id from users where  user_id = ? and user_password = ?";
			st = con.prepareStatement(sql);
			// プレースホルダーの設定
			st.setInt(1, uid);
			st.setString(2, pw);

			rs = st.executeQuery();
			// 結果の取得
			if(rs.next()){
				result = rs.getInt(1);
			}
			rs.close();
			st.close();
			return result;
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

	public int ChangePass(int uid, String npw)throws DAOException{
		if(con == null){
			getConnection();
		}
		PreparedStatement st = null;

        try{
			String sql = "UPDATE users SET user_password = ? WHERE user_id = ?";
			st = con.prepareStatement(sql);

			st.setString(1, npw);
			st.setInt(2, uid);

			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally{
			try{
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
