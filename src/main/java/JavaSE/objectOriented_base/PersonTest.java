package JavaSE.objectOriented_base;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.objectOriented
 * @Author: Clown
 * @CreateTime: 2023-07-22  09:33
 */
public abstract class PersonTest {

    public String name;
    public int age;
    public String nickname;

    public PersonTest(String name)
    {
        this.name=name;
    }
    public abstract void eatTest();


//    String name;
//    int age;
//    String nickname;
//    static String test;
//
//    static {
//        System.out.println("我是静态代码块");
//    }
//    {
//        System.out.println("我是代码块");
//    }
//
//    PersonTest(){
//        System.out.println("构造函数执行");
//    }
//    public void eatTest(){
//        System.out.println("干饭人努力干饭");
//    }
//    public void eatTest(String name){
//        System.out.println("我"+name+"干饭人努力干饭");
//    }
//    public void changeName(String name){
//        this.name=name;
//    }
}