package b.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import b.bean.NewBookBean;

public class NewBookDao {
	private Connection con;

	public NewBookDao() throws DAOException {
		// getConnection();
	}

	public void saveOrder(NewBookBean nbook) throws DAOException {
		if (con == null)
			getConnection();


		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Date formatdate = Date.valueOf(nbook.getNpubyear());
			String 	sql = "INSERT INTO  Bookinfo VALUES(?, ?, ?, ?, ?, ?, ?) ";
			st = con.prepareStatement(sql);


			st.setString(1, nbook.getNisbn());
			st.setString(2, nbook.getNbassort());
			st.setString(3, nbook.getNpublishernum());
			st.setString(4, nbook.getNtitle());
			st.setString(5, nbook.getNauthor());
			st.setString(6, nbook.getNpublisher());
			st.setDate(7, formatdate);

			st.executeUpdate();
			st.close();


			int bookstateNumber = 0;
			sql = "SELECT nextval('bookstate_bookstate_id_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				bookstateNumber = rs.getInt(1);
			}
			rs.close();
			st.close();



			Date formatdate1 = Date.valueOf(nbook.getArrivalyear());
		    sql = "INSERT INTO BookState(bookstate_id, bookinfo_isbn, bookstate_enter) VALUES(?, ?, ?)";
			st = con.prepareStatement(sql);

			st.setInt(1, bookstateNumber);
			st.setString(2, nbook.getNisbn());
			st.setDate(3, formatdate1);

			st.executeUpdate();
			st.close();


		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {

			// ドライバのところ
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
