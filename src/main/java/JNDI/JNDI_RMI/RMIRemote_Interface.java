package JNDI.JNDI_RMI;

import java.io.IOException;
import java.rmi.Remote;

public interface RMIRemote_Interface extends Remote {
    public String test() throws IOException;
}
