package servlet;

import java.io.IOException;

import dao.impl.UserDAOImpl;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAOImpl dao = new UserDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if ("logout".equals(action)) {
			req.getSession().removeAttribute("currentUser");
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		User user = dao.findById(id);

		if (user != null || user.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("currentUser", user);
			resp.sendRedirect(req.getContextPath() + "/user/index");
		} else {
			req.setAttribute("message", "Sai thông tin đăng nhập!");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
