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
import b.bean.bookBean;
import b.dao.DAOException;
import b.dao.bookDao;


/**
 * Servlet implementation class ShoeItemServlet
 */
@WebServlet("/mainmenuservlet")
public class mainmenuservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("top"))
			{
				gotoPage(request,response,"/.jsp");
			}
			//トップページ
			else if (action.equals("usermenu"))
			{
				bookDao dao = new bookDao();
				List<UserTopBean>list = dao.findtop();
				request.setAttribute("username",list);
				request.setAttribute("userbookscount",list.size());
				request.setAttribute("userbooks",list);

				gotoPage(request,response,"/usermenu.jsp");
			}
			//検索
			else if(action.equals("usersearch"))
			{
				gotoPage(request,response,"/searchbook.jsp");
			}
			//返却
			else if(action.equals("userreturn"))
			{
				bookDao dao = new bookDao();
				List<bookBean>list = dao.findAll();
				request.setAttribute("bookscount",list.size());
				request.setAttribute("books",list);
				gotoPage(request,response,"/return.jsp");
			}
			//会員情報
			else if(action.equals("userinformation"))
			{
				gotoPage(request,response,"/changeuserinfo.jsp");
			}
			//ログアウト
			else if(action.equals("userout"))
			{
				HttpSession session = request.getSession(false);
		    	if(session != null){

		    		session.invalidate();
		    		gotoPage(request, response,"/librarylogout.jsp");
		    	}
			}else{
				gotoPage(request,response,"/error.jsp");
			}
		}catch (DAOException e)
		{
			e.printStackTrace();
			request.setAttribute("message","内部エラーが発生しました");
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

