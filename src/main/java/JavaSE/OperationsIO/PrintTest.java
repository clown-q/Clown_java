package JavaSE.OperationsIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  18:18
 */
public class PrintTest {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream("test.txt");
        printStream.println("asdasd");
    }
}