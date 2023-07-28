package JavaSE.OperationsIO;

import java.io.*;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  14:03
 */
public class FileCopyTest {
//    public static void main(String[] args) throws IOException { //字符流
//        FileInputStream fileInputStream = new FileInputStream("1.jpg");
//        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = fileInputStream.read(bytes)) != -1){
//            fileOutputStream.write(bytes,0,len);
//        }
//
//        fileOutputStream.flush();
//        fileInputStream.close();
//    }

//    //字符流
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("test.txt");
        FileWriter fileWriter = new FileWriter("test1.txt");
        char[] chars = new char[3];
        int len;
        while ((len = fileReader.read(chars)) != -1){
            fileWriter.write(chars,0,len);
        }
        fileReader.close();
        fileWriter.flush();
    }
}
