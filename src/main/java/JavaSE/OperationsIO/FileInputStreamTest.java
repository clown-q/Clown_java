package JavaSE.OperationsIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  11:06
 */
public class FileInputStreamTest {
//    //错误示范
//    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("test.txt");//创建一个文件输入流，用来读取文件
//        while (fileInputStream.read() != -1){
//            System.out.print((char) fileInputStream.read());
//        }
//        fileInputStream.close();
//    }
//
//    //使用循环读取
//    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("test.txt");//创建一个文件输入流，用来读取文件
//        int i;
//        while ((i = fileInputStream.read())!= -1){
//            System.out.print((char) i);
//        }
//        fileInputStream.close();
//    }

    //一次读取
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");//创建一个文件输入流，用来读取文件
        byte[] bytes = new byte[fileInputStream.available()]; //使用available方法来获取剩余字节流的数量
        fileInputStream.read(bytes);
        System.out.println(new String(bytes));
        fileInputStream.close();
    }

}
