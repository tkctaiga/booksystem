package b.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.UserTopBean;
import b.dao.DAOException;
import b.dao.LoginDAO;
import b.dao.bookDao;



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
					 String sid = request.getParameter("id");
					 String password = request.getParameter("password");

					 if(sid.equals("") || password.equals("")){
						 request.setAttribute("message", "入力してください");
						 gotoPage(request, response, "error.jsp");
					 }
			         int id = Integer.parseInt(sid);

		             LoginDAO login = new LoginDAO();
		             int usercheck = login.CantEnter(id);
		             if(usercheck == 0){
		            	 request.setAttribute("message", "会員登録してください");
		            	 gotoPage(request, response, "error.jsp");
		             }
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
            				String uname = login.getUserName(id);
		                        if(role == 0){
		                        	//管理者
		                        	//ユーザーIDとユーザー名前をセッションで保存
		                        	session.setAttribute("username",uname);
		            				session.setAttribute("userid",id);
		                            gotoPage(request, response,"/managermenu.jsp");
		                        }else{
		                        	//ユーザー
		                        	//ユーザーIDとユーザー名前をセッションで保存
		                        	//トップに表示するリストの作成
		            				bookDao dao = new bookDao();
		            				List<UserTopBean>list = dao.findtop(uname);
		            				session.setAttribute("username",uname);
		            				session.setAttribute("userid",id);

		            				session.setAttribute("userbookscount",list.size());
		            				session.setAttribute("userbooks",list);
		                            gotoPage(request, response, "/usermenu.jsp");
		                        }
			         }
		        }catch(DAOException e){
		        	 e.printStackTrace();
		        	 request.setAttribute("message", "内部エラーが発生しました");
		        	 gotoPage(request, response, "error.jsp");
		        }catch(NumberFormatException n){
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

