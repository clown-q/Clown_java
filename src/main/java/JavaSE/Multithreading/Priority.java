package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  18:09
 */
public class Priority {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        });
        Thread thread1 = new Thread(() -> {

        });
        Thread thread2 = new Thread(() -> {

        });
        thread.setPriority(Thread.MAX_PRIORITY); //使用setPRiority方法设置优先级
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        System.out.println(thread.getPriority());
        System.out.println(thread1.getPriority());
        System.out.println(thread2.getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }
}
