package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server2Impl extends UnicastRemoteObject implements IServer2{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Server2Impl() throws RemoteException {
		
	}

	@Override
	public int square(int a) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("tinh tich");
		return a * a;
	}
	
}
