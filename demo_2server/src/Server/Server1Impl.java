package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server1Impl extends UnicastRemoteObject implements IServer1{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Server1Impl() throws RemoteException {
		
	}

	@Override
	public int sum(int a, int b) throws RemoteException {
		System.out.println("tinh tong");
		int s = 0;
		try {
			IServer2 server2 = (IServer2) Naming.lookup("rmi://localhost:5000/Server2");
			
			int c = a + b;
			s = server2.square(c);
			
			System.out.println("tinh xong");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	
}
