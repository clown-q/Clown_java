package CommonsCollection.Clown_CC3;


public class ClassLoader_Person{
    public String name;
    public static int age;

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

    public static void test(){
        System.out.println("静态方法");
    }

    public ClassLoader_Person(){
        System.out.println("无参的构造函数");
    }

    public ClassLoader_Person(String name, int age){
        System.out.println("有参的构造方法");
    }
}