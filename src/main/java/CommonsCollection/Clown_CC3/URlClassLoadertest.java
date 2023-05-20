package CommonsCollection.Clown_CC3;


import java.net.URL;
import java.net.URLClassLoader;

public class URlClassLoadertest {
    public static void main(String[] args) throws Exception{
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("http://127.0.0.1/")});
        Class<?> c = urlClassLoader.loadClass("Test");
        c.newInstance();
    }
}
