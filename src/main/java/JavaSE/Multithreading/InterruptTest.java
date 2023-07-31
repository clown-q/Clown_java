package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  17:37
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("循环中断");
                    break;
                }
            }
            System.out.println("中断成功");
        });
        Thread thread1 = new Thread(() ->{
            thread.interrupt();
        });

        thread.start();
        thread1.start();
    }
}
