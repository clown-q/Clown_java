package JNDI.JNDI_RMI;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_RMI
 * @Author: Clown
 * @CreateTime: 2023-09-23  11:44
 */
public class JNDIRMIClinet {
    public static void main(String[] args) throws NamingException, IOException {
        InitialContext context = new InitialContext();
        context.lookup("rmi://10.196.195.121:1099/test");
    }
}
