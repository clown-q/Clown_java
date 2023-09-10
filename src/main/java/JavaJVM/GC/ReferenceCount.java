package JavaJVM.GC;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.GCTest
 * @Author: Clown
 * @CreateTime: 2023-09-09  12:14
 */
public class ReferenceCount {
    public static void main(String[] args) {
//        String str = new String("aaa");//引用计数器加一，当然为1
//        str=null;//引用计数器减一，当前为0//认为这个对象不会被再次使用

        Test test1 = new Test(); //对象一的计数器值加一，当前值为1
        Test test2 = new Test(); //对象二的计数器值加一，当前值为1

        test1.test = test2; //对象一的成员属性引用对象二，计数器值加一，当前值为2
        test2.test = test1; //对象二的成员属性引用对象一，计数器值加一，当前值为2
        test1 = test2 = null; //两个对象的原始引用都置空，计数器都减一，当前的值都为1
    }
    public static class Test{
        Test test;
    }
}
