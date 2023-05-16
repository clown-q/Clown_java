package Clown_RMI_code;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RemoteHelloWorld extends UnicastRemoteObject implements IRemoteHelloWorld {
    protected RemoteHelloWorld() throws RemoteException {
        super();
    }
    public String hello() throws RemoteException {
        System.out.println("访问成功");
        return "Hello world";
    }
    public String test() throws RemoteException{
        return "test";
    }
}
