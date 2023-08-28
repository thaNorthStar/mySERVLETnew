package style.paul.service;

import style.paul.dao.IStudentDao;
import style.paul.daofactory.StudentDaoFactory;
import style.paul.dto.Student;

public class StudentServiceImpl implements IStudentService{
	
	private IStudentDao stdDao;
	
	@Override
	public String addStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao=StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}


}
