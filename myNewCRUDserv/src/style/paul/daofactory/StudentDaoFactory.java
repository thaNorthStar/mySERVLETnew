package style.paul.daofactory;

import style.paul.persistence.IStudentDao;
import style.paul.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao=null;
	
	public static IStudentDao getStudentDao() {
		if(studentDao==null) {
			studentDao=new StudentDaoImpl();
		}
		return studentDao;
	}
}
