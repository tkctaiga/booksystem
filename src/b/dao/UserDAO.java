package b.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import b.bean.UserBean;

public class UserDAO {
	private Connection con;

	public UserDAO() throws DAOException {
		getConnection();
	}

	public int saveUser(UserBean user) throws DAOException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "insert into users(user_password, user_name, user_address, user_tel, user_postel, user_birthday, user_sex) VALUES(?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			// プレースホルダーの設定
			st.setString(1, user.getPassword());
			st.setString(2, user.getName());
			st.setString(3, user.getAddress());
			String Tel = user.getNumber1() + "-" + user.getNumber2() + "-" + user.getNumber3();
			st.setString(4, user.getTel());
			st.setString(5, user.getPostal1());
			st.setString(6, user.getPostal2());
			String Birthday = user.getBirthday1() + user.getBirthday2() + user.getBirthday3();
			st.setString(7, user.getBirthday());
			st.setString(8, user.getSex());
			// SQLの実行
			st.executeUpdate();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
		return 0;
	}

	// ユーザーパスワードの真偽
	public boolean isRegistedUser(int user_id, String user_password) throws DAOException {
		if (con == null) {
			// Connectionはデータベースと接続させるためのインターフェース
			getConnection();
		}
		// PreparedStatementはSQLを実行させるためのインターフェース
		// IDかつパスワードが同じならば氏名住所電話番号確認画面へ
		// ResultSetはSELECT実行後にデータを取得するためのインターフェイス
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String sql = "SELECT user_id, user_password from users where user_id = ? and user_password = ?";
			st = con.prepareStatement(sql);
			// IDとパスワードを設定する処理
			st.setInt(1, user_id);
			st.setString(2, user_password);
			// IDとパスワードを取得する処理
			rs = st.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
		// ブーリアン方でidの真偽の識別を行う処理
		if (id == user_id) {
			return true;
		} else {
			return false;
		}
	}

	public void updateUserInfo(int user_id, String user_name, String user_address, String user_tel)
			throws DAOException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "update users set user_name = ?, user_address = ?, user_tel = ? where user_id = ?";
			st = con.prepareStatement(sql);
			st.setString(1, user_name);
			st.setString(2, user_address);
			st.setString(3, user_tel);
			st.setInt(4, user_id);
			// SQLの実行
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}

	}

	public void deleteUserInfo(int user_id, String user_name, String user_password) throws DAOException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "delete from users where user_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, user_id);
			st.setString(2, user_name);
			st.setString(3, user_password);
			// SQLの実行
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}

	}

	private void getConnection() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:webbook";
			String user = "mybook";
			String pass = "book1";

			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
