package JavaSE.objectOriented;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE
 * @Author: Clown
 * @CreateTime: 2023-07-24  09:58
 */
public class InnerClass1 {
    public class Test1{
        public void test1() {
            System.out.println("内部类的test方法被调用了");
        }
    }
}
class InnerClass2{
    public static class Test2{
        public void test2(){
            System.out.println("静态内部类的test方法被调用了");
        }
    }
}
class main {
    public static void main(String[] args) {
        InnerClass1 innerClass = new InnerClass1();
        InnerClass1.Test1  test1 = innerClass.new Test1();
        test1.test1();
        InnerClass2.Test2 test2 = new InnerClass2.Test2();
        test2.test2();
    }

}
