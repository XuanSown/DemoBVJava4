package servlet;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import dao.impl.UserDAOImpl;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/user/index", "/user/create", "/user/update", "/user/delete", "/user/edit", "/user/search" })
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAOImpl dao = new UserDAOImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		if (path.contains("edit")) {
			String id = req.getParameter("id");
			User user = dao.findById(id);
			req.setAttribute("user", user);
		} else if (path.contains("create")) {
			try {
				User user = new User();
				BeanUtils.populate(user, req.getParameterMap());
				dao.create(user);
				if (user.getId() == null || user.getId().trim().isEmpty() || user.getPassword() == null
						|| user.getPassword().trim().isEmpty() || user.getFullname() == null
						|| user.getFullname().trim().isEmpty() || user.getEmail() == null
						|| user.getEmail().trim().isEmpty()) {
					req.setAttribute("message", "Vui lòng nhập đầy đủ thông tin!");
				} else {
					req.setAttribute("message", "Thêm thành công!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Lỗi thêm mới: " + e.getMessage());
			}
		} else if (path.contains("update")) {
			try {
				User user = new User();
				BeanUtils.populate(user, req.getParameterMap());
				dao.update(user);
				if (user.getId() == null || user.getId().trim().isEmpty() || user.getPassword() == null
						|| user.getPassword().trim().isEmpty() || user.getFullname() == null
						|| user.getFullname().trim().isEmpty() || user.getEmail() == null
						|| user.getEmail().trim().isEmpty()) {
					req.setAttribute("message", "Vui lòng nhập đầy đủ thông tin!");
				} else {
					req.setAttribute("message", "Cập nhật thành công!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Cập nhật thất bại!: " + e.getMessage());
			}
		} else if (path.contains("delete")) {
			try {
				String id = req.getParameter("id");
				dao.delete(id);
				req.setAttribute("message", "Xóa thành công!");
			} catch (Exception e) {
				// TODO: handle exception
				req.setAttribute("message", "Xóa thất bại: " + e.getMessage());
			}
		}

		// Tìm kiếm
		String searchKeyword = req.getParameter("search");
		List<User> list;
		if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
			list = dao.findByFullname(searchKeyword);
		} else {
			list = dao.findAll();
		}

		req.setAttribute("items", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
