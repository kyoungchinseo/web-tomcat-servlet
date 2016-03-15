import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DataBase;
import model.User;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password= req.getParameter("password");
		
		User user = DataBase.findUserById(userId);

		HttpSession session = req.getSession();
		
		if (user == null) {
			resp.sendRedirect("/user/login_failed.jsp");
			return;
		}
		
		if (user.getPassword().equals(password)) { //  db has user data
			
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("password", user.getPassword());
			
			resp.sendRedirect("/index.jsp");
			return;
		} else {
			resp.sendRedirect("/user/login_failed.jsp");
			return;
		}
		
	}
}
