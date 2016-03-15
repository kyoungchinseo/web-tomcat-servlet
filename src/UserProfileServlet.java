import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DataBase;
import model.User;

@WebServlet("/user/profile")
public class UserProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		
		if (userId == null) {
			resp.sendRedirect("/index.jsp");
			return;
		}
		
		req.setAttribute("user", DataBase.findUserById(userId));
		RequestDispatcher rd = req.getRequestDispatcher("/user/profile.jsp");
		rd.forward(req, resp);
		
		return;
	}
	
}
