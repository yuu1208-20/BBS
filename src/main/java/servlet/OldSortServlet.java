package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/oldsort")
/**
 * Servlet implementation class OldSortServlet
 */
public class OldSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			//古い順に並び変えるメソッド呼び出し
			UserDao udao = new UserDao();
			ArrayList<User> sortedList = new ArrayList<User>();
			sortedList = udao.selectSortByOld();
			request.setAttribute("sortedList", sortedList);
			request.getRequestDispatcher("/views/home.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
