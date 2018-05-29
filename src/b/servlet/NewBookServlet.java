package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.NewBookBean;
import b.dao.DAOException;
import b.dao.NewBookDao;

/**
 * Servlet implementation class NewBookServlet
 */
@WebServlet("/NewBookServlet")
public class NewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		if (session == null) {
			request.setAttribute("message", "間違いです。");
			gotoPage(request, response, "/error.jsp");
			return;
		}

		try {
			String action = request.getParameter("action");
			if (action == null || action.length() == 0 || action.equals("mregister")) {
				gotoPage(request, response, "/newbook.jsp");

			} else if (action.equals("confirm")) {

				NewBookBean bean = new NewBookBean();
				bean.setNisbn(request.getParameter("nisbn"));
				bean.setNbassort(request.getParameter("nbassort"));
				bean.setNpublishernum(request.getParameter("npublishernum"));
				bean.setNtitle(request.getParameter("ntitle"));
				bean.setNauthor(request.getParameter("nauthor"));
				bean.setNpublisher(request.getParameter("npublisher"));
				bean.setNpubyear(request.getParameter("npubyear"));
				bean.setArrivalyear(request.getParameter("arrivalyear"));
				session.setAttribute("nnbook", bean);

				gotoPage(request, response, "/newbookconfirm.jsp");

			} else if (action.equals("result")) {
				NewBookBean nbean = (NewBookBean) session.getAttribute("nnbook");

				if (nbean == null) {
					request.setAttribute("message", "正しく入力してください。");
					gotoPage(request, response, "/error.jsp");

				} else {
					NewBookBean nbbean = (NewBookBean) session.getAttribute("nnbook");
					NewBookDao newbook = new NewBookDao();
					newbook.saveOrder(nbbean);



					gotoPage(request, response, "/newbookresult.jsp");

				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
