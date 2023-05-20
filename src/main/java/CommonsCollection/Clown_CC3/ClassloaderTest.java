package CommonsCollection.Clown_CC3;

public class ClassloaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        new ClassLoader_Person();
        Class cl = ClassLoader_Person.class;
        Class.forName("CommonsCollection.Clown_CC3.ClassLoader_Person");
        ClassLoader classLoader =ClassLoader.getSystemClassLoader();
        Class<?> c = Class.forName("CommonsCollection.Clown_CC3.ClassLoader_Person",false,classLoader);
        c.newInstance();
    }
}
