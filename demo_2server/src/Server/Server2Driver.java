package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server2Driver {
	
	public static void main(String[] args) {
		System.out.println("creating server 2");
		
		try {
			Server2Impl server2 = new Server2Impl();
			Naming.rebind("rmi://localhost:5000/Server2", server2);
			System.out.println("server 2 ready");
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
