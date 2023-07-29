package JavaSE.OperationsIO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-29  07:38
 */
public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"AAA");
        map.put(2,"BBB");
        map.put(3,"CCC");
        objectOutputStream.writeObject(map);
        objectOutputStream.flush();

        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(objectInputStream.readObject());
    }
}
