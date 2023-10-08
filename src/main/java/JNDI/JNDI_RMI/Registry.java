package JNDI.JNDI_RMI;

import java.rmi.registry.LocateRegistry;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JNDI.JNDI_RMI
 * @Author: Clown
 * @CreateTime: 2023-09-23  15:09
 */
public class Registry {

    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            Thread.sleep(1000000);
            System.out.println("Server Start");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}