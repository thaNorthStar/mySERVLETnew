package style.paul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(response);
		String studentName = "paul";
		String studentAge = "69";
		String studentAddress = "MN";
		System.out.println(studentName + "" + studentAge + "" + studentAddress);
		PrintWriter out = response.getWriter();
		out.close();
	}

	private void doProcess(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>DISP</title></head>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
