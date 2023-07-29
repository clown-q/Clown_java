package JavaSE.OperationsIO;

import java.io.File;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  16:55
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        System.out.println(file.createNewFile()); //创建一个文件，名字是test.txt
    }
}