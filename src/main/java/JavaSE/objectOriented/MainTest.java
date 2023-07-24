package JavaSE.objectOriented;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.objectOriented
 * @Author: Clown
 * @CreateTime: 2023-07-24  12:47
 */
public class MainTest extends Exception{
    public static void main(String[] args) {
        PersonTest personTest = () -> System.out.println("aaaa");
        personTest.test();

//        PersonTest personTest = new PersonTest() {
//            @Override
//            public void test() {
//                System.out.println("匿名");
//            }
//        };
//        personTest.test();
    }
}
