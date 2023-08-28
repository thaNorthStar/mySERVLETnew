package style.paul.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void init() throws ServletException{
		System.out.println("Config Object created & got the values from Config Object...\n\n");
		String url=getInitParameter("url");
		String username=getInitParameter("username");
		String password=getInitParameter("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		try {
			connection=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<h1>Request type is: "+request.getMethod()+"</h1>");
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select id,name,address from student");
			while(resultSet.next()) {
				//use resultSet & process it
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

