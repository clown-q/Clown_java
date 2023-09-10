package JavaJVM.GC;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.GC
 * @Author: Clown
 * @CreateTime: 2023-09-09  15:13
 */
public class LastRadianceOfTheSettingSun {
    public static A root;
    public static void main(String[] args) throws InterruptedException {
        root = new A();
        root = null;

        System.gc();  //申请GC

        Thread.sleep(1000); //等待GC执行完成
        System.out.println(root.str);
    }
    public static class A{
        String str = "回光返照";

        @Override
        protected void finalize() throws Throwable{
            System.out.println("GC前的垂死挣扎");
            root = this;
        }
    }
}
