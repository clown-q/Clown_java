package Clown_RMI_code;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class RMIClient {
    public static void main(String[] args) throws Exception, RemoteException, NotBoundException {
        // 获取 RMI 注册表，参数为 RMI 服务器的 IP 和端口号
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
        // 打印出 RMI 注册表中所有已注册的服务名
//        System.out.println(Arrays.toString(registry.list()));
        // 根据服务名在 RMI 注册表中查找远程对象的 stub
        IRemoteHelloWorld stub = (IRemoteHelloWorld) registry.lookup("Hello");
        // 调用远程对象的方法并打印结果
        System.out.println(stub.test());
    }
}
