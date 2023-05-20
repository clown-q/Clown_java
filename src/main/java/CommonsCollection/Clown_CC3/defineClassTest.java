package CommonsCollection.Clown_CC3;


import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class defineClassTest {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader =ClassLoader.getSystemClassLoader();
        Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
        defineClass.setAccessible(true);
        byte[] code = Files.readAllBytes(Paths.get("D:\\tmp\\Test.class"));
        Class test = (Class) defineClass.invoke(classLoader, "Test", code, 0, code.length);
        test.newInstance();
    }
}
