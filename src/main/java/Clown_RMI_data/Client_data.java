package Clown_RMI_data;

import java.rmi.Naming;

public class Client_data {

    public static void main(String[] args) throws Exception{
        RMIServer_data.IRemoteHelloWorld helloWorld = (RMIServer_data.IRemoteHelloWorld)
                Naming.lookup("rmi://127.0.0.1:1099/Hello");
        String ret = helloWorld.hello();
        System.out.println(ret);

    }
}
