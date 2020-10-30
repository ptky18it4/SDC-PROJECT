package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server1Driver {
	
	public static void main(String[] args) {
		System.out.println("creating server 1");
		
		try {
			Server1Impl server1 = new Server1Impl();
			
			Naming.rebind("rmi://localhost:3000/Server1", server1);
			System.out.println("server 1 ready");
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
