package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.dao.ChangePasswordDAO;
import b.dao.DAOException;

@WebServlet("/ChangeUserServlet")
public class ChangeUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession(true);
			String action = request.getParameter("action");

			if(action == null || action.length() == 0 || action.equals("top"))
			{
				gotoPage(request,response,"/.jsp");
			}
			//ユーザーIDとパスワード入力
			else if(action.equals("dinput"))
			{
				gotoPage(request,response,"/userunsucheck.jsp");
			}
			//削除確認ページ
			else if(action.equals("dconfim"))
			{
				//フォームからとってきた値
				String id = request.getParameter("uid");
				String pw = request.getParameter("upas");
				//比較する値
				String eid = session.getAttribute("userid").toString();
				String epw = "";
				ChangePasswordDAO dao = new ChangePasswordDAO();
				epw = dao.getPw(eid);
				System.out.println(id + pw + eid + epw);
				if(id.equals(eid) && pw.equals(epw))
				{
					gotoPage(request,response,"/userunsuinfo.jsp");
				}
				else
				{
					//違う場合のJSP
					gotoPage(request,response,"/top.jsp");
				}

			}
			//削除確定ページ
			else if(action.equals("dend"))
			{
				ChangePasswordDAO dao = new ChangePasswordDAO();
				String eid = session.getAttribute("userid").toString();
				dao.userDelete(Integer.parseInt(eid));
				gotoPage(request,response,"/userunsufinish.jsp");
			}
			//ログアウト
			else if(action.equals("userout"))
			{
				session = request.getSession(false);
		    	if(session != null)
		    	{
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request,
			   HttpServletResponse response, String page)throws ServletException,
	         IOException
	{
		      RequestDispatcher rd = request.getRequestDispatcher(page);
		      rd.forward(request, response);
	}

}
