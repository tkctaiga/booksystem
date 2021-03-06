
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
@WebServlet("/bookdispservlet")
public class bookdispservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession(true);
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("top"))
			{
				gotoPage(request,response,"/error.jsp");
			}
			//検索結果
			else if (action.equals("searchresult"))
			{
				String categoryN = request.getParameter("category");
				String numS = request.getParameter("searchnum");
				bookDao dao = new bookDao();
				List<bookBean>list = dao.findsearch(numS,categoryN);
				request.setAttribute("bookscount",list.size());
				request.setAttribute("books",list);
				gotoPage(request,response,"/booklist.jsp");
			}
			//借りる確認
			else if(action.equals("searchborrow"))
			{
				String book_name = request.getParameter("book_name");
				bookDao dao = new bookDao();
				List<bookBean>list = dao.findconfim(book_name);
				request.setAttribute("bookscount",list.size());
				request.setAttribute("books",list);
				gotoPage(request,response,"/borrowconfirm.jsp");
			}
			//借りる確定
			else if(action.equals("searchborroworder"))
			{
				String uname = "";
				int uid = 0;
				int stateid = Integer.parseInt(request.getParameter("book_stateid"));
				bookDao dao = new bookDao();
				uname = session.getAttribute("username").toString();
				uid = (int)session.getAttribute("userid");
				dao.AddRental(dao.returnRentalid(),stateid,uid);
				List<UserTopBean>list = dao.findtop(uname);
				session.setAttribute("userbookscount",list.size());
				session.setAttribute("userbooks",list);
				gotoPage(request,response,"/borroworder.jsp");
			}
			//ログアウト
			else if(action.equals("userout"))
			{
				gotoPage(request,response,"/userconfirm.jsp");
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

