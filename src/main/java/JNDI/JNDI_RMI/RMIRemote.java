package JNDI.JNDI_RMI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_RMI
 * @Author: Clown
 * @CreateTime: 2023-09-23  10:33
 */
public class RMIRemote extends UnicastRemoteObject implements RMIRemote_Interface {

    protected RMIRemote() throws RemoteException {
        super();
    }
    @Override
    public String test() throws IOException {
//        Runtime.getRuntime().exec("calc");
        return "连接成功";
    }
}
