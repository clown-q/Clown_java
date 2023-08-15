package JavaWeb.Socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaWeb
 * @Author: Clown
 * @CreateTime: 2023-08-10  09:55
 */
public class ClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",2444);
            System.out.println("Successful!");
        } catch (IOException e) {
            System.out.println("Failure!!!");
            throw new RuntimeException(e);
        }
    }
}
