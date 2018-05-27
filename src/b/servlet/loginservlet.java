package b.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.dao.DAOException;
import b.dao.LoginDAO;



/**
 * Servlet implementation class ShoeItemServlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		    request.setCharacterEncoding("UTF-8");
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
			//ログインの処理
			else if(action.equals("login")){
				 try{
			         int id = Integer.parseInt(request.getParameter("id"));
			         String password = request.getParameter("password");

		             LoginDAO login = new LoginDAO();
		             int result = login.welcomeLibrary(id, password);
		             // ユーザー名とパスワードが一致したら
			         if(result == 0){
			    	         request.setAttribute("message", "IDまたはパスワードが違います");
			    	         gotoPage(request, response, "error.jsp");
			         }else {
			                 // セッション管理を行う
			                 HttpSession session = request.getSession();
				             // ログイン済みの属性を設定する
					         session.setAttribute("isLogin", "true");
					        // データベースから取ってきたroleでフォワードするJSPを分ける
		                    int role = login.divideUser(id);
		                        if(role == 0){
		                            gotoPage(request, response,"/managermenu.jsp");
		                        }else{
		                            gotoPage(request, response, "/usermenu.jsp");
		                        }
			         }
		        }catch(DAOException e){
		        	 e.printStackTrace();
		        	 request.setAttribute("message", "内部エラーが発生しました");
		        	 gotoPage(request, response, "error.jsp");
		        }

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

