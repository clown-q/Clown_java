package JavaSE.OperationsIO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.OperationsIO
 * @Author: Clown
 * @CreateTime: 2023-07-28  15:59
 */
public class CharacterStreamIntput {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("test.txt");
        int i;
        while ((i = reader.read()) != -1){
            System.out.println((char) i);
        }
        reader.close();
    }
}