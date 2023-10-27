package ClassLoaderStudy;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: ClassLoaderStudy
 * @Author: Clown
 * @CreateTime: 2023-10-31  13:56
 */
public class URLClassLoaderTest {
    public static void main(String[] args) throws Exception{
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("Http://127.0.0.1:8000/")});
//        System.out.println(urlClassLoader);
        Class<?> c = urlClassLoader.loadClass("B");
        c.newInstance();
    }
}
