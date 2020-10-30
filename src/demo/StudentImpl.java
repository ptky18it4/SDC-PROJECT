package demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentImpl extends UnicastRemoteObject implements IStudent {

	/**
	 * De chay tren runtime can add thu vien mysql vao jre ...\Java\jre1.8.0_261\lib\ext
	 */
	private static final long serialVersionUID = 1L;

	protected StudentImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		
		ResourceBundle bundle = ResourceBundle.getBundle("resources.db");
		String DB_URL = bundle.getString("url");

		// Database credentials
		String USER = bundle.getString("username");
		String PASS = bundle.getString("password");

		Connection conn = null;
		Statement stmt = null;

		// Register JDBC driver
		Class.forName(bundle.getString("driveName"));

		// Open a connection
		System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connected database successfully...");

		stmt = conn.createStatement();
		String sql = "SELECT * FROM student";
		ResultSet rs = stmt.executeQuery(sql);

		// Extract data from result set
		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("id");

			String name = rs.getString("name");
			String branch = rs.getString("branch");

			int percent = rs.getInt("percent");
			String email = rs.getString("email");

			// Setting the values
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setBranch(branch);
			student.setPercent(percent);
			student.setEmail(email);
			students.add(student);
		}
		
		return students;
	}

	@Override
	public int save(Student student) throws Exception {
		// TODO Auto-generated method stub
		String DB_URL = "jdbc:mysql://localhost:3306/demo_rmi";

		String USER = "root";
		String PASS = "123456";

		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Connecting to a selected database...");
		if(conn == null) {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		System.out.println("Connected database successfully...");

		String sql = "INSERT INTO student(percent, name, branch, email) VALUES(?,?,?,?)";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, student.getPercent());
		ptmt.setString(2, student.getName());
		ptmt.setString(3, student.getBranch());
		ptmt.setString(4, student.getEmail());
		
		return ptmt.executeUpdate();
	}
}
