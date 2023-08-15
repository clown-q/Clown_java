package JavaWeb.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaWeb
 * @Author: Clown
 * @CreateTime: 2023-08-10  09:54
 */
public class ServerTest {
    public static void main(String[] args) {
        try {
            while (true){
                ServerSocket serverSocket = new ServerSocket(2444);
                System.out.println("Loading·····");
                Socket socket = serverSocket.accept(); //等待连接
                System.out.println("Connection succeeded！,ip："+socket.getInetAddress().getHostAddress());
                serverSocket.close(); //关闭连接，防止端口占用
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
