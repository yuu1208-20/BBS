package servlet;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
/**
 * Servlet implementation class userServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			//パラメータ取得
			String username = request.getParameter("username");
			
			//ユーザー名が空欄だった場合
			if(username.isEmpty()) {
				username = "匿名";
			}
			
			String title = request.getParameter("title");
			String comments = request.getParameter("comments");
			
			//daoのインスタンス生成
			UserDao udao = new UserDao();
			udao.insert(username, title, comments);
		}catch(Exception e) {
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
		
		//画面遷移
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
