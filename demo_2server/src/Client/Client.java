package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Server.IServer1;

public class Client {
	public static void main(String[] args) {
		
		try {
			IServer1 server1 = (IServer1) Naming.lookup("rmi://localhost:3000/Server1");
			
			System.out.println("ket qua la: "+server1.sum(3, 4));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
