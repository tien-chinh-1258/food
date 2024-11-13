package vn.herta.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.herta.models.UserModel;
import vn.herta.services.IUserService;
import vn.herta.services.impl.UserService;
import vn.herta.utils.Constant;

@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//lay toan bo ham trong service
	IUserService service = new UserService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		 req.setCharacterEncoding("UTF-8");
		 
		 //lay tham so tu view
		 String username = req.getParameter("uname");
		 String password = req.getParameter("psw");
		 String remember = req.getParameter("remember");
		 //kiem tra tham so
		 boolean isRememberMe = false;
		 if ("on".equals(remember)) {
		     isRememberMe = true;
		 }
		 String alertMsg = "";

		 // Kiểm tra null để tránh NullPointerException
		 if ( username.isEmpty() || password.isEmpty()) {
			    alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			    req.setAttribute("alert", alertMsg);
			    req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			    return;
			}


		 // Xử lý đăng nhập
		 UserModel users = service.login(username, password);
		 
			if(users!=null){
				 HttpSession session = req.getSession(true);
				 session.setAttribute("account", users);
				 
				 if(isRememberMe){
				 saveRemeberMe(resp, username);
				 }
				 
				 resp.sendRedirect(req.getContextPath()+"/waiting");
				 }else{
				 alertMsg ="Tài khoản hoặc mật khẩu không đúng";
				 req.setAttribute("alert", alertMsg);
				 req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
				 }
				 }
  
	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		 cookie.setMaxAge(30*60);
		 resp.addCookie(cookie);

	}
		 
}



