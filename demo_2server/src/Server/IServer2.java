package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer2 extends Remote{
	
	int square(int a) throws RemoteException;
}
