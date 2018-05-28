package b.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.bean.RentalBean;
import b.dao.DAOException;
import b.dao.RentalUserDao;

/**
 * Servlet implementation class SearchRentalServlet
 */
@WebServlet("/SearchRentalServlet")
public class SearchRentalServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("managertop"))
			{
				gotoPage(request,response,"/.jsp");
			}
			//検索結果
			else if(action.equals("result"))
			{
				//int userid = Integer.parseInt(request.getParameter("userid"));
				String userid = request.getParameter("userid");
				RentalUserDao dao = new RentalUserDao();
				List<RentalBean>list = dao.RenSearch(userid);
				request.setAttribute("rens",list);
				gotoPage(request,response,"/renresult.jsp");
			}
			//検索詳細
			else if(action.equals("detail"))
			{
				int userid = Integer.parseInt(request.getParameter("renid"));
				RentalUserDao dao = new RentalUserDao();
				List<RentalBean>list = dao.RenDetail(userid);
				request.setAttribute("rens",list);
				gotoPage(request,response,"/rendetail.jsp");
			}
			//ログアウト
			else if(action.equals("mlogout"))
			{
				gotoPage(request,response,"/mlogout.jsp");
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
