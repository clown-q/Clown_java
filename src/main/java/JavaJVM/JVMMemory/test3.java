package JavaJVM.JVMMemory;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.JVMMemory
 * @Author: Clown
 * @CreateTime: 2023-09-08  12:38
 */
public class test3 {
    public static void main(String[] args) {
        String str1 = new String("aaa");
        String str2 = new String("aaa");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
