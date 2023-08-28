package style.paul.daofactory;

import style.paul.dao.IStudentDao;
import style.paul.dao.StudentDaoImpl;

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
