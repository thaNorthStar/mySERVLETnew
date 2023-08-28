package style.paul.servicefactory;

import style.paul.service.IStudentService;
import style.paul.service.StudentServiceImpl;
//abstraction logic of implementation
public class StudentServiceFactory {
	//make constructor private to avoid object creation
	private StudentServiceFactory() {}
	private static IStudentService studentService=null;
	public static IStudentService getStudentService() {
		// singleton pattern code
		if(studentService==null) {
			studentService=new StudentServiceImpl();
		}
		return studentService;
	}
}
