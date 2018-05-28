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
			HttpSession session = request.getSession(true);
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
			//会員のパスワード変更①
			//パスワード入力機能
			else if(action.equals("passchange"))
			{
				//管理人パスワード①
				String pass = request.getParameter("pass");
				//変更したいID②
				String id = request.getParameter("id");
				//変更したいパスワード③
				String cpass = request.getParameter("cpass");
				if(pass.equals("book13"))
				{
					session.setAttribute("id",id);
					session.setAttribute("cpass",cpass);
					gotoPage(request,response,"/manegerchangeconfim.jsp");

				}
				else
				{
					gotoPage(request,response,"/manegermenu.jsp");
				}
			}
			//会員のパスワード変更確認②
			//確認機能
			else if(action.equals("passchangeconf"))
			{
				String id = "";
				String cpass = "";
				id = session.getAttribute("id").toString();
				cpass = session.getAttribute("cpass").toString();
				RentalUserDao dao = new RentalUserDao();
				dao.userchangepass(id, cpass);
				gotoPage(request,response,"/manegerpassend.jsp");
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
