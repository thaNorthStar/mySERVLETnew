package style.paul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import style.paul.dto.Student;
import style.paul.service.IStudentService;
import style.paul.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService stdService = StudentServiceFactory.getStudentService();
		System.out.println("Request URI: " + request.getRequestURI());
		System.out.println("Path Info: " + request.getPathInfo());
		if (request.getRequestURI().endsWith("addform")) {
			String sage = request.getParameter("sage");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");
			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddr);
			String status = stdService.addStudent(student);
			PrintWriter out = response.getWriter();
			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>Registration successful/</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>Registration failed.</h1>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			Student student = stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
				out.println("<tr><th>Name</th><td>" + student.getSname() + "</td></tr>");
				out.println("<tr><th>Age</th><td>" + student.getSage() + "</td></tr>");
				out.println("<tr><th>Address</th><td>" + student.getSaddress() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<h1 style='color:red;text-align:center;'>Record not found for ID: " + sid + "</h1>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("deleteform")) {
			String sid = request.getParameter("sid");
			String status = stdService.deleteStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (status.equals("success")) {
				out.println("<body>");
				out.println("<h1 style='color:green;text-align:center;'>Record deleted successfully.</h1>");
				out.println("</body>");
			} else if (status.equals("failure")) {
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record deletion failed.</h1>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<h1 style='color:green;text-align:center;'>Record not found for ID: " + sid + "</h1>");
				out.println("</body>");
			}
			out.close();
		}
	}
}
