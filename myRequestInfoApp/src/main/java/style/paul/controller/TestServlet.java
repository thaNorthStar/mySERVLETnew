package style.paul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<h1>Request URI: " + request.getRequestURI() + "</h1>");
		out.print("<h1>Context Path: " + request.getContextPath() + "</h1>");
		out.print("<h1>Servlet Path: " + request.getServletPath() + "</h1>");
		out.print("<h1>Path Info: " + request.getPathInfo() + "</h1>");
		out.print("<h1>QueryString: " + request.getQueryString() + "</h1>");
		out.print("<h1>Remote Port: "+request.getRemotePort()+"</h1>");
		out.print("<h1>Remote Address: "+request.getRemoteAddr()+"</h1>");
		out.print("<h1>Local Addreass: "+request.getLocalAddr()+"</h1>");
		out.print("<h1>Session: "+request.getSession()+"</h1>");
		out.print("<h1>Locale: "+request.getLocale()+"</h1>");
		out.print("<h1>Cookies: "+request.getCookies()+"</h1>");
		out.print("<h1>Remote User: "+request.getRemoteUser()+"</h1>");
		out.print("<h1>Remote Host: "+request.getRemoteHost()+"</h1>");

		out.close();
	}
}
