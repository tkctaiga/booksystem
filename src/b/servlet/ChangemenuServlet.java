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
 * Servlet implementation class ChangemenuServlet
 */
@WebServlet("/ChangemenuServlet")
public class ChangemenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangemenuServlet() {
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
		// 存在することが前提
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String menu = request.getParameter("menu");

		if (action == null || action.length() == 0 || action.equals("top")) {// 値、要素が何もなかったらエラー
			gotoPage(request, response, "/error.jsp");
		}

		if (session == null) {// セッションオブジェクトなし
			request.setAttribute("message", "セッションがきれました。トップページより操作してください。");
			gotoPage(request, response, "/error.jsp");
			return;
		}

		try {
			if(action.equals("changeinfo")){
				gotoPage(request, response, "/changeuserinfo.jsp");
			}// パラメータの取得
			// 情報変更処理
			else if (menu.equals("userinfo")) {
				if (action.equals("password")) {
					// 要素がないときのエラー処理
					if (request.getParameter("chname") == "" && request.getParameter("chaddress") == ""
							&& request.getParameter("chnumber1") == "" && request.getParameter("chnumber2") == ""
							&& request.getParameter("chnumber3") == "") {
						gotoPage(request, response, "/error.jsp");
					}
					UserBean chUserBean = new UserBean();
					chUserBean.setName(request.getParameter("chname"));
					chUserBean.setAddress(request.getParameter("chaddress"));
					chUserBean.setNumber1(request.getParameter("chnumber1"));
					chUserBean.setNumber2(request.getParameter("chnumber2"));
					chUserBean.setNumber3(request.getParameter("chnumber3"));
					// セッション情報を格納
					session.setAttribute("changeUserInfo", chUserBean);
					// パスワード画面へ
					gotoPage(request, response, "/userinputpw.jsp");
				} else if (action.equals("pwconfirm")) {
					if (request.getParameter("pw") == "") {
						gotoPage(request, response, "/error.jsp");
					}
					// パスワードのブーリアンをUserDAOから取得
					UserDAO userdao = new UserDAO();
					// DAOからIDとパスワードをチェックするメソッドを呼び出す
					// isRegistedUserがブーリアンのメソッド
					boolean islogincheck = userdao.isRegistedUser((int) session.getAttribute("userid"),
							request.getParameter("pw"));
					if (islogincheck == true) {
						gotoPage(request, response, "/changeuserconfirm.jsp");
					} else {
						gotoPage(request, response, "/error.jsp");
					}
				} else if (action.equals("confirm")) {// 確認処理を行う
					UserDAO userDao = new UserDAO();
					// UserBeanの情報を取得する
					UserBean userBeanConfirm = new UserBean();
					// (UserBean)をキャスト
					userBeanConfirm = (UserBean) session.getAttribute("changeUserInfo");
					String user_name = userBeanConfirm.getName();
					String user_address = userBeanConfirm.getAddress();
					String user_tel = userBeanConfirm.getNumber1() + userBeanConfirm.getNumber2()
							+ userBeanConfirm.getNumber3();
					// DAOの中の値を更新する処理
					userDao.updateUserInfo((int) session.getAttribute("userid"), user_name, user_address, user_tel);
					session.setAttribute("username",user_name);
					gotoPage(request, response, "/changefinish.jsp");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/error.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stu
		doGet(request, response);
	}

}
