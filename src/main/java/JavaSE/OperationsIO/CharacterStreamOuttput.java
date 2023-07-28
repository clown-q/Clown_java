package JavaSE.OperationsIO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  16:20
 */
public class CharacterStreamOuttput {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("杀菌灯sajhd");
        fileWriter.flush();
    }
}