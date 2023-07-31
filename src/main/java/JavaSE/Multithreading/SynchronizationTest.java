package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  19:17
 */
public class SynchronizationTest {
    public static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           for (int i=0;i<10000;i++){
               synchronized (SynchronizationTest.class){
               sum++;
               }
           }
            System.out.println("线程一执行完成");
        });
        Thread thread1 = new Thread(() -> {
            for (int i=0;i<10000;i++){
                synchronized (SynchronizationTest.class){
                    sum++;
                }
            }
            System.out.println("线程二执行完成");
        });
        thread.start();
        thread1.start();
        Thread.sleep(10);
        System.out.println(sum);
    }
}
