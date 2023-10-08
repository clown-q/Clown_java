package JNDI.JNDI_RMI;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_RMI
 * @Author: Clown
 * @CreateTime: 2023-09-23  11:44
 */
public class JNDIRMIServer {
    public static void main(String[] args) throws NamingException, RemoteException, AlreadyBoundException, MalformedURLException {
//        Registry registry = LocateRegistry.createRegistry(1099);//创建注册中心
        Reference reference = new Reference("T", "T", "http://127.0.0.1:8080/");//引用，三个参数分别是类名，Factory和factory的位置
        //factory中的代码逻辑会在调用Reference的时候调用
        Naming.bind("test",new ReferenceWrapper (reference));
//        InitialContext context = new InitialContext();
//        context.rebind("rmi://localhost:1099/test",reference);
    }
}
