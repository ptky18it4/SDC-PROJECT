package demo;

import java.rmi.Naming;

public class Server{
	
	public static void main(String[] args) {
		
		try {
			
			StudentImpl student = new StudentImpl();
			
			//dang ki 1 remote
			Naming.rebind("rmi://localhost:5000/student", student);
			
			System.out.println("server da san sang");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
