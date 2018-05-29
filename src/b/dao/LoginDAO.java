package b.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO{
	private Connection con;

	public LoginDAO() throws DAOException{
		getConnection();
	}

	public int welcomeLibrary(int id, String password)throws DAOException{
		getConnection();

		if(con == null){
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;


		try{
			// とってくるための変数を宣言
			int result = 0;

			String sql = "select user_id, user_password from users "
					+ "where user_id = ? and user_password = ?" ;
			st = con.prepareStatement(sql);

			st.setInt(1, id);
			st.setString(2, password);

			rs = st.executeQuery();


            // 値が返ってこなっかた場合、0が返ってくる
			if(rs.next()){
				result = rs.getInt(1);
			}
			st.close();
			rs.close();
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

	public int CantEnter(int id) throws DAOException{
   	    if(con == null){
   		    getConnection();
   	    }
   	    PreparedStatement st = null;
        ResultSet rs = null;
        try{
       	 int usercheck = 0;
       	 // SQL文の作成
       	 String sql = "SELECT * from users WHERE user_id = ? and user_dis isNULL";
       	 // PrepareStatementオブジェクトの取得
       	 st = con.prepareStatement(sql);
       	 // 指定したユーザーが退会しているか確認
       	 st.setInt(1, id);
       	 // SQLの実行
       	 rs = st.executeQuery();

       	 // 退会していれば0が返ってくる
       	 if(rs.next()){
       		 usercheck = rs.getInt(1);
       	 }
       	 st.close();
       	 rs.close();
       	 return usercheck;
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

	public int divideUser(int id)
	               throws DAOException{
		getConnection();

		if(con == null){
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
	    try{
		        int rresult = 0;

		        String sql = "select  user_id, user_role from users "
				      + "where user_id = ? and user_role = '0'" ;
		        st = con.prepareStatement(sql);

		        st.setInt(1, id);

		        rs = st.executeQuery();

                // 値が返ってこなっかた場合、0が返ってくる
		        if(rs.next()){
			        rresult = rs.getInt(1);
		        }
		        st.close();
		        rs.close();
                return rresult;
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


	public String getUserName(int id)throws DAOException
	{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			String m_name = "";
			String sql = " SELECT user_id,user_name FROM Users WHERE user_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1,id);
			rs = st.executeQuery();
			if(rs.next())
			{
				m_name  = rs.getString(2);
			}
			return m_name;
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
