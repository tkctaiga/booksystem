package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.UserBean;
import b.dao.DAOException;
import b.dao.UserDAO;

/**
 * Servlet implementation class Userdelete
 */
@WebServlet("/Userdelete")
public class Userdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Userdelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			String action = request.getParameter("action");
			if (action == null || action.length() == 0 || action.equals("top")) {// 値、要素が何もなかったらエラー
				gotoPage(request, response, "/error.jsp");
			}

			if (session == null) {// セッションオブジェクトなし
				request.setAttribute("message", "セッションがきれました。トップページより操作してください。");
				gotoPage(request, response, "/error.jsp");
				return;
			}
			if (action.equals("password")) {
				// 要素がないときのエラー処理
				if (request.getParameter("idtype") == "" && request.getParameter("passwordtype") == "") {
					gotoPage(request, response, "/error.jsp");
				}
				UserBean chUserBean = new UserBean();
				chUserBean.setId(request.getParameter("idtype"));
				chUserBean.setName(request.getParameter("userName"));
				// セッション情報を格納
				// session.setAttribute("userUnsuInfo", chUserBean);
				// 退会確認画面へ
				gotoPage(request, response, "/userunsuinfo.jsp");
			} else if (action.equals("pwconfirm")) {
				if (request.getParameter("pw") == "") {
					gotoPage(request, response, "/error.jsp");
				}
			} else if (action.equals("confirm")) {// 確認処理を行う
				UserDAO userDao = new UserDAO();
				// UserBeanの情報を取得する
				UserBean userBeanConfirm = new UserBean();
				// (UserBean)をキャスト
				userBeanConfirm = (UserBean) session.getAttribute("changeUserInfo");
				String user_id = userBeanConfirm.getId();
				String user_name = userBeanConfirm.getName();
				String user_password = userBeanConfirm.getPassword();
				// DAOの中の値を更新する処理
				userDao.deleteUserInfo((int) session.getAttribute("userid"), user_name, user_password);
				gotoPage(request, response, "/userunsufinish.jsp");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
