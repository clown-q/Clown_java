package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  10:33
 */
public class SleepTest {
    public static void main(String[] args) throws RuntimeException{
        Thread thread = new Thread(() -> {
            try {
                System.out.println("线程二");
                Thread.sleep(1000);
                System.out.println("线程二");
                Thread.sleep(1000);
                System.out.println("线程二");
                Thread.sleep(1000);
                System.out.println("线程二");
                Thread.sleep(1000);
                System.out.println("线程二");
                Thread.sleep(1000);
                System.out.println("线程二");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("线程一");
                Thread.sleep(1000);
                System.out.println("线程一");
                Thread.sleep(1000);
                System.out.println("线程一");
                Thread.sleep(1000);
                System.out.println("线程一");
                Thread.sleep(1000);
                System.out.println("线程一");
                Thread.sleep(1000);
                System.out.println("线程一");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread1.start();
    }
}