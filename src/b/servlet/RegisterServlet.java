package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.UserBean;
import b.dao.DAOException;
import b.dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        try{
             // パラメータの解析
             String action = request.getParameter("action");
             // useraddまたはパラメータなしの場合は情報入力ページを表示
             if(action == null || action.length() == 0
                    || action.equals("useradd")){
             gotoPage(request, response, "/newuser.jsp");
             //useraddは確認処理を行う
             }else if(action.equals("addconfirm")){
            	// ラジオボタンのパラメータの取得
                 String addsex = request.getParameter("sex");

                 String selectedsex;
                 if(addsex == null){
                 	  selectedsex = "選択されていません";
                 gotoPage(request, response, "/error.jsp");
                 }else{
                       switch(addsex){
                       case "0":
                           selectedsex = "男";
                           break;
                       case "1":
                           selectedsex = "女";

                       default:
                           selectedsex = "???";
                           break;
                       }
                       request.setAttribute("selectsex",selectedsex );
                  }
                  UserBean bean = new UserBean();
                  bean.setPassword(request.getParameter("password"));
                  bean.setName(request.getParameter("name"));
                  bean.setAddress(request.getParameter("address"));
                  bean.setPostal1(request.getParameter("postal1"));
                  bean.setPostal2(request.getParameter("postal2"));
                  bean.setNumber1(request.getParameter("number1"));
                  bean.setNumber2(request.getParameter("number2"));
                  bean.setNumber3(request.getParameter("number3"));
                  bean.setBirthday1(request.getParameter("birthday1"));
                  bean.setBirthday2(request.getParameter("birthday2"));
                  bean.setBirthday3(request.getParameter("birthday3"));
                  bean.setSex(addsex);
                  session.setAttribute("user", bean);
                  gotoPage(request, response, "/userconfirm.jsp");
                  // addfinishは登録確定
             }else if(action.equals("addfinish")){
                  UserBean user = (UserBean) session.getAttribute("user");
                  if(user == null){// 顧客情報がない
                         request.setAttribute("message", "正しく入力してください");
                         gotoPage(request, response, "/error.jsp");
                  }

                  UserDAO register = new UserDAO();
                  int userNumber = register.saveUser(user);
                  // 登録後はセッション情報をクリア
                  session.removeAttribute("user");
                  // ユーザーIDをクライアントへ送る
                  request.setAttribute("userNumber", new Integer(userNumber));
                  gotoPage(request, response, "/registerfinish.jsp");
             }else{ // アクションの値が不正
	                     request.setAttribute("message", "正しく操作してください");
	                     gotoPage(request, response, "/error.jsp");
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
