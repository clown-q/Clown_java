package JavaJVM.JNITest;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM
 * @Author: Clown
 * @CreateTime: 2023-08-31  15:11
 */
public class JNIsum {
    static {
        System.load("E:\\C\\JNIsum.dll");
    }
    public static void main(String[] args) {
        System.out.println(sum(10,20));
    }
    public static native int sum(int a,int b);  //使用关键字native修饰，表示sum方法是一个本地方法
}
