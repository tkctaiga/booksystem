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

				String ntitle = request.getParameter("ntitle");
				String nbassort = request.getParameter("nbassort");
				String npublishernum = request.getParameter("npublishernum");
				String nauthor = request.getParameter("nauthor");
				String npublisher = request.getParameter("npublisher");
				String npubyear = request.getParameter("npubyear");
				String arrivalyear = request.getParameter("arrivalyear");
				if(ntitle.equals("") || nbassort.equals("") || npublishernum.equals("")
						|| nauthor.equals("") || npublisher.equals("") || npubyear.equals("") || arrivalyear.equals("")){
					request.setAttribute("message","項目を全て入力してください。");
					gotoPage(request, response, "/error.jsp");
				}

				NewBookBean bean = new NewBookBean();
				bean.setNisbn(ntitle);
				bean.setNbassort(nbassort);
				bean.setNpublishernum(npublishernum);
				bean.setNtitle(ntitle);
				bean.setNauthor(nauthor);
				bean.setNpublisher(npublisher);
				bean.setNpubyear(npubyear);
				bean.setArrivalyear(arrivalyear);
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
