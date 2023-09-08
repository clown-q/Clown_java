package JavaJVM.JVMMemory;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.JVMMemory
 * @Author: Clown
 * @CreateTime: 2023-09-08  12:35
 */
public class test2 {
    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "aaa";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
