package JNDI.JNDI_LDAP;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_LDAP
 * @Author: Clown
 * @CreateTime: 2023-09-23  17:46
 */
public class JNDILDAPClinet {
    public static void main(String[] args) throws NamingException, IOException {
        InitialContext context = new InitialContext();
        context.lookup("ldap://127.0.0.1:1234/T");
    }
}