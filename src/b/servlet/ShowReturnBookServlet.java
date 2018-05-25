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
import b.dao.bookDao;

/**
 * Servlet implementation class ShowReturnBookServlet
 */
@WebServlet("/ShowReturnBookServlet")
public class ShowReturnBookServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(true);
			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("top"))
			{
				gotoPage(request,response,"/error.jsp");
			}
			//返却確認
			else if (action.equals("returncon"))
			{
				int rentalid = 0;
				int uid = 2;
				rentalid = Integer.parseInt(request.getParameter("rental_id"));
				bookDao dao = new bookDao();
				List<UserTopBean>list = dao.returnconfim(uid,rentalid);
				session.setAttribute("rental_id",rentalid);
				request.setAttribute("renusers",list);
				gotoPage(request,response,"/returnconfirm.jsp");
			}
			//返却確定
			else if(action.equals("returnend"))
			{
				int rentalid = 0;
				rentalid = (int)session.getAttribute("rental_id");
				bookDao dao = new bookDao();
				dao.returnbookupdate(rentalid);
				gotoPage(request,response,"/returnorder.jsp");
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
}
