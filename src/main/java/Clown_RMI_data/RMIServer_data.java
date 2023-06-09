package Clown_RMI_data;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer_data {
    public interface IRemoteHelloWorld extends Remote {
        public String hello() throws RemoteException;
    }

    public class RemoteHelloWorld extends UnicastRemoteObject implements IRemoteHelloWorld{
        protected RemoteHelloWorld() throws RemoteException{
            super();
        }
    public String hello() throws RemoteException{
        System.out.println("访问成功");
        return "Hello World";
    }
    }

    private void start() throws Exception{
        RemoteHelloWorld h = new RemoteHelloWorld();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://127.0.0.1:1099/Hello",h);
    }
    public static void main(String[] args) throws Exception{
        new RMIServer_data().start();
    }
}
