package b.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ShoeItemServlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	        private final String USER = "";
            private final String PASS = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		    response.setContentType("text/html;charset=UTF-8");

			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("top"))
			{
				gotoPage(request,response,"/top.jsp");
			}
			//ログインページ処理
			else if (action.equals("loginpage"))
			{
				gotoPage(request, response,"/librarylogin.jsp");

			}
			//新規会員登録の処理
			else if(action.equals("newuser"))
			{
				gotoPage(request,response,"/newuser.jsp");
			}
			//新規会員登録の処理
			else if(action.equals("login"))
			{
	        // ログイン時はユーザ名とパスワードを取得する
				        String name = request.getParameter("id");
				    	String passWord = request.getParameter("password");
	                    // ユーザー名とパスワードが一致したら
				    	if(name.equals(USER) && passWord.equals(PASS)){
	                        // セッション管理を行う
				    		HttpSession session = request.getSession();
				    		// ログイン済みの属性を設定する
				    		session.setAttribute("isLogin", "true");
				    		gotoPage(request, response,"/usermenu.jsp");
				    	}else{
				    		request.setAttribute("message", "IDまたはパスワードが違います");
				    		gotoPage(request, response,"/error.jsp");
				    	}
			}
			//新規会員登録確認の処理
			else if(action.equals("addconfirm"))
			{
				gotoPage(request,response,"/userconfirm.jsp");
			}else{
				gotoPage(request,response,"/error.jsp");
			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	public void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,response);
	}

	public void init() throws ServletException
	{
		//try
		//{
		//}catch(DAOException e)
		//{
		//	e.printStackTrace();
		//	throw new ServletException();
		//}
	}

}

