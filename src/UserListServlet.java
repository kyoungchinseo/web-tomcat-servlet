import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DataBase;


@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String userId = (String)session.getAttribute("userId");
		String password = (String)session.getAttribute("password");
		System.out.println("received session: " + userId);
		
		if (userId == null) {
			resp.sendRedirect("/index.jsp");
			return;
		}
		
		if (DataBase.findUserById(userId).getPassword().equals(password)) { // check login
			req.setAttribute("users", DataBase.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
			rd.forward(req, resp);
			return;
		} else {
			resp.sendRedirect("/index.jsp");
			return;
		}
		
	}

}
