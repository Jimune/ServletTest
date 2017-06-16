package com.jimune.demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Servlet/*"})
public class WelkomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int visited = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("/resetCounter".equals(request.getPathInfo())) {
			visited = 0;
			
			response.sendRedirect("/WelkomDemo/Servlet");
		} else {
			visited++;
			
			response.getWriter().println(build("Hello World!", "<br>"));
			response.getWriter().println(build(request.getContextPath(), request.getServletPath(), 
					request.getPathInfo(), request.getPathTranslated(), "<br>"));
			response.getWriter().println(build(LocalDateTime.now(), "<br>", "Visits:", visited, "<br>"));
			
			Enumeration<String> list = request.getHeaderNames();
			
			while (list.hasMoreElements()) {
				String name = list.nextElement();
				response.getWriter().println(build(name, "=", request.getHeader(name), "<br>"));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String build(Object... objs) {
		StringBuilder sb = new StringBuilder();
		
		for (Object obj : objs) {
			sb.append(obj).append(" ");
		}
		
		return sb.toString();
	}
}
