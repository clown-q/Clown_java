package JNDI.JNDI_RMI;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_RMI
 * @Author: Clown
 * @CreateTime: 2023-09-23  10:45
 */
public class RMiClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);//获取注册表
        RMIRemote_Interface test = (RMIRemote_Interface) registry.lookup("test");//通过test在注册表中寻找远程对象
        System.out.println(Arrays.toString(registry.list()));
        System.out.println(test.test());//调用test方法
    }
}
