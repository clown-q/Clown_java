package JavaWeb.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaWeb.Socket
 * @Author: Clown
 * @CreateTime: 2023-08-14  10:29
 */
public class ClientDataTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",2444);
            System.out.println("Successful!");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            outputStreamWriter.write("hello\n");
            outputStreamWriter.flush();
            System.out.println("Loading...");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            socket.close();
        } catch (IOException e) {
            System.out.println("Failure!!!");
            throw new RuntimeException(e);
        }
    }
}
