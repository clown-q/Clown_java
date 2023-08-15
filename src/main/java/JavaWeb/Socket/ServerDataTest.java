package JavaWeb.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaWeb.Socket
 * @Author: Clown
 * @CreateTime: 2023-08-14  10:28
 */
public class ServerDataTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2444);
        System.out.println("Loading·····");
        Socket socket = serverSocket.accept(); //等待连接
        System.out.println("Connection succeeded！,ip："+socket.getInetAddress().getHostAddress());
        System.out.println("ClientData: ");
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        System.out.println(new BufferedReader(inputStreamReader).readLine());

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        outputStreamWriter.write("hello!\n");
        outputStreamWriter.flush();

        socket.close();
    }
}
