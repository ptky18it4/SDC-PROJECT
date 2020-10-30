package demo;

import java.rmi.Remote;
import java.util.List;

public interface IStudent extends Remote{
	
	List<Student> getStudents() throws Exception;
	int save(Student student) throws Exception;
}
