package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  20:19
 */
public class DeadLock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        new Thread(() -> {
            synchronized (object1){
                System.out.println("线程一，获取资源1");
                try {
                    Thread.sleep(1000);
                    System.out.println("开始等待,释放现有资源");
                    object1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object2){
                    System.out.println("线程一，获取资源2");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object2){
                System.out.println("线程二，获取资源1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1){
                    System.out.println("线程二，获取资源2");
                    object1.notifyAll();
                    System.out.println("唤醒使用wait等待的线程");
                }
            }
        }).start();
    }
}
