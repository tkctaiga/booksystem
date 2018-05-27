package b.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ShoeItemServlet
 */
@WebServlet("/ManagerMenuServlet")
public class ManagerMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("managertop"))
			{
				gotoPage(request,response,"/.jsp");
			}
			//メイン
			else if (action.equals("mmain"))
			{
				gotoPage(request,response,"/managertop.jsp");
			}
			//本の登録
			else if(action.equals("mregister"))
			{
				gotoPage(request,response,"/newbook.jsp");
			}
			//本の削除
			else if(action.equals("mdelete"))
			{
				gotoPage(request,response,"/deletebook.jsp");
			}
			//会員照会
			else if(action.equals("mchuser"))
			{
				gotoPage(request,response,"/searchuser.jsp");
			}
			//貸返照会
			else if(action.equals("mbruser"))
			{
				gotoPage(request,response,"/searchborrowuser.jsp");
			}
			//ログアウト
			else if(action.equals("mlogout"))
			{
				gotoPage(request,response,"/mlogout.jsp");
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