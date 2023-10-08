import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Clown
 * @CreateTime: 2023-09-23  18:39
 */
public class T {
    static  {
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
