package JavaJVM.JVMMemory;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.JVMMemory
 * @Author: Clown
 * @CreateTime: 2023-09-07  19:23
 */
public class test1 {
    public static void main(String[] args) {
        int sum = a();
        System.out.println(sum);
    }
    public static int a(){
        return b();
    }
    public static int b(){
        return c();
    }
    public static int c()
    {
        int a = 10;
        int b = 20;
        return a+b;
    }
}
