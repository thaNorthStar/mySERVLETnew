package style.paul.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import style.paul.dto.Student;
import style.paul.service.IStudentService;
import style.paul.servicefactory.StudentServiceFactory;
// controller logic
public class TestApp {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1: Create");
			System.out.println("2: Read");
			System.out.println("3: Update");
			System.out.println("4: Delete");
			System.out.println("5: Exit");
			System.out.println("Enter your choice: ");
			String option=br.readLine();
			switch(option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateRecord();
				break;
			case "4":
				deleteRecord();
				break;
			case "5":
				System.out.println("Thanks for using the application!");
				System.exit(0);
			default:
				System.out.println("Invalid operation, please try again...");
			}
		}
	}
	private static void updateRecord() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the student ID to be updated: ");
		String sid=br.readLine();
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Student student=studentService.searchStudent(Integer.parseInt(sid));
		if(student!=null) {
			Student newStudent=new Student();
			System.out.println("Student ID is: "+student.getSid());
			newStudent.setSid(student.getSid());
			System.out.println("Student's old name is: "+student.getSname()+" Enter new name: ");
			String newName=br.readLine();
			if(newName.equals("")||newName=="") {
				newStudent.setSname(student.getSname());
			}else {
				newStudent.setSname(newName);;
			}
			System.out.println("Student's old age is: "+student.getSage()+" Enter new age: ");
			String newAge=br.readLine();
			if(newAge.equals("")||newAge=="") {
				newStudent.setSage(student.getSage());
			}else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student's old address is: "+student.getSaddress()+" Enter new address: ");
			String newAddress = br.readLine();
			if (newAddress.equals("")||newAddress == "") {
				newStudent.setSaddress(student.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}
			System.out.println("new object data is: "+newStudent);
			System.out.println();
			String status=studentService.updateStudent(newStudent);
			if(status.equalsIgnoreCase("success")) {
				System.out.println("record updated successfully");
			}else {
				System.out.println("record updation failed");
			}
		}else {
			System.out.println("Student record not available for the given ID: "+sid);
		}
	}
	private static void deleteRecord() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the student ID to be deleted: ");
		int sid=scanner.nextInt();
		IStudentService studentService=StudentServiceFactory.getStudentService();
		String msg=studentService.deleteStudent(sid);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("record deleted successfully");
		}else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("record not available for the given ID: "+sid);
		}else {
			System.out.println("record deletion failed");
		}
	}
	private static void selectOperation() {
		//insertOperation{};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the student's ID: ");
		int sid=scanner.nextInt();
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Student std=studentService.searchStudent(sid);
		if(std!=null) {
			System.out.println(sid);
			System.out.println("SID\tSNAME\tSAGE\tSADDR");
			System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
		}else {
			System.out.println("record not available for the given ID :: "+sid);
		}
	}
	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the student's name: ");
		String sname=scanner.next();
		System.out.print("Enter the student's age: ");
		int sage=scanner.nextInt();
		System.out.print("Enter the student's address: ");
		String saddress=scanner.next();
		String msg=studentService.addStudent(sname,sage,saddress);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed");
		}
	}
}