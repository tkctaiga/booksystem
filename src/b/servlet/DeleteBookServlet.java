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

import b.bean.bookBean;
import b.dao.DAOException;
import b.dao.bookDao;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
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
				gotoPage(request,response,"/error.jsp");
			}
			//検索結果
			else if (action.equals("dblist"))
			{
				String categoryN = request.getParameter("category");
				String numS = request.getParameter("searchnum");
				bookDao dao = new bookDao();
				List<bookBean>list = dao.findsearch(numS,categoryN);
				request.setAttribute("bookscount",list.size());
				request.setAttribute("books",list);
				gotoPage(request,response,"/deletebooklist.jsp");
			}
			//削除選択
			else if(action.equals("dbconfirm"))
			{
				String book_name = request.getParameter("book_name");
				bookDao dao = new bookDao();
				List<bookBean>list = dao.findconfim(book_name);
				request.setAttribute("bookscount",list.size());
				request.setAttribute("books",list);
				gotoPage(request,response,"/deletebookconfirm.jsp");
			}
			//削除備考入力
			else if(action.equals("dbconfim2"))
			{
				int bookstate = Integer.parseInt(request.getParameter("book_stateid"));
				bookDao dao = new bookDao();
				List<bookBean>list = dao.deleteconfim(bookstate);
				request.setAttribute("books",list);
				request.setAttribute("bookstateid",bookstate);
				gotoPage(request,response,"/deletebookconfirm2.jsp");
			}

			//削除確定
			else if(action.equals("dbresult"))
			{
				int stateid = Integer.parseInt(request.getParameter("book_stateid"));
				String com = request.getParameter("bikou");
				bookDao dao = new bookDao();
				System.out.println(com);
				dao.deletebook(stateid,com);
				gotoPage(request,response,"/deletebookresult.jsp");
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
