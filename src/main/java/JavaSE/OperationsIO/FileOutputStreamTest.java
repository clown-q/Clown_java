package JavaSE.OperationsIO;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  12:26
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt",true);
        fileOutputStream.write("test".getBytes());
        fileOutputStream.flush();
    }
}
