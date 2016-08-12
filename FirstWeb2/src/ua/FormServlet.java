package ua;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	
	private static final long serialVersionUID = 4656205184818860704L;

	private String name = "";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(!name.isEmpty()) req.setAttribute("message", name + " I'm your father");
		req.getRequestDispatcher("/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		name = req.getParameter("userName");
		resp.sendRedirect("/form");
	}
}
