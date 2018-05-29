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

/**
 * Servlet implementation class ChangePwServlet
 */
@WebServlet("/ChangePwServlet")
public class ChangePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession();

	   try{
    	   String action = request.getParameter("action");
    	   ChangePasswordDAO change = new ChangePasswordDAO();
           // またはパラメータなしの場合は情報入力ページを表示
           if(action == null || action.length() == 0
                  || action.equals("inputpw")){
           gotoPage(request, response, "/changepw.jsp");
           // 入力された情報の取得
           }else if(action.equals("pwconfirm")){
        	   String pw = request.getParameter("password");
        	   String npw = request.getParameter("npassword");
               int uid = 0;
    		   // セッション内のIDをint型にキャストして取ってくる
        	   uid = (int)session.getAttribute("userid");
      		   // System.out.println(uid + pw);
        	   // パスワードを照合
        	   int result = change.ConfirmPw(uid, pw);
      		   // System.out.println(result);
        	   if(result == 0){
        		   request.setAttribute("message", "パスワードが違います");
        		   gotoPage(request, response, "/error.jsp");
        	   }else{
        		   // 新しいパスワードをセッションに格納
            	   session.setAttribute("pass",npw);
        		   gotoPage(request, response, "/pwconfirm.jsp");
        		   result = 0;
        	   }
           }else if(action.equals("chpwfinish")){
        	   String cpw = "";
        	   cpw = session.getAttribute("pass").toString();
        	   int uid = 0;
           	   uid = (int)session.getAttribute("userid");
        	   change.ChangePass(uid,cpw);
        	   // パスワード変更後、ログアウト
        	   session.invalidate();
        	   gotoPage(request, response, "/changepwfinish.jsp");
           }else{
        	   request.setAttribute("message", "変更作業に誤りがあります");
           }
	    }catch(DAOException e){
   	     e.printStackTrace();
   	     request.setAttribute("message", "内部エラーが発生しました");
   	     gotoPage(request, response, "/error.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request,
			   HttpServletResponse response, String page)throws ServletException,
	         IOException{
		      RequestDispatcher rd = request.getRequestDispatcher(page);
		      rd.forward(request, response);
	}

}
