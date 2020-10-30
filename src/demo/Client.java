package demo;

import java.rmi.Naming;
import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		try {
			//tra ve 1 tham chieu
			IStudent student = (IStudent) Naming.lookup("rmi://localhost:5000/student");
			
			List<Student> students = student.getStudents();
			for(Student s : students) {
				System.out.println(s.getName());
				System.out.println(s.getEmail());
			}
			
			//save
			
			/*Student s = new Student();
			s.setPercent(2);
			s.setName("nhat");
			s.setBranch("hello");
			s.setEmail("email4");
			
			student.save(s);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
