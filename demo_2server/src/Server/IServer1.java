package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer1 extends Remote{
	
	int sum(int a, int b) throws RemoteException;
}
