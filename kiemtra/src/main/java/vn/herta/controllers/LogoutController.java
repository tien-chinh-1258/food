package vn.herta.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(urlPatterns= {"/logout"})
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  //xoa acc khoi Session khi logout
	HttpSession session = req.getSession();
	session.removeAttribute("account");
	  //Redirect ve home
	resp.sendRedirect("home");
	
}
}

	
	