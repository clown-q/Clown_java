package Clown_RMI_code;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RemoteServer {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        //创建注册中心
        IRemoteHelloWorld iRemoteHelloWorld = new RemoteHelloWorld();
        //创建远程对象
        Naming.bind("rmi://127.0.0.1/Hello",iRemoteHelloWorld);
        //绑定
    }
}
