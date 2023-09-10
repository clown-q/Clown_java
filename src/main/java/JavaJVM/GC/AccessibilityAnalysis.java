package JavaJVM.GC;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.GC
 * @Author: Clown
 * @CreateTime: 2023-09-09  13:44
 */
public class AccessibilityAnalysis {
    public static void main(String[] args) {
        A root = new A();
        root.B = new B();
        root.C = new C();
        root=null;
    }
    public static class A{
        public B B;
        public C C;
    }
    public static class B{}
    public static class C{}
}
