package JNDI.JNDI_RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_RMI
 * @Author: Clown
 * @CreateTime: 2023-09-23  10:37
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        LocateRegistry.createRegistry(1099);
        RMIRemote rmiRemote = new RMIRemote();
        Naming.bind("test",rmiRemote);
    }
}
