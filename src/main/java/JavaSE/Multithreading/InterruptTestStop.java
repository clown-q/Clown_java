package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  17:37
 */
public class InterruptTestStop {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                if (Thread.currentThread().isInterrupted()){//判断有无中断信号
                    System.out.println("循环中断");
                    break;
                }
            }
            System.out.println("中断成功");
        });
        Thread thread1 = new Thread(() ->{
            thread.interrupt(); //请求tread指向的线程中断
        });

        thread.start();
        thread1.start();
    }
}
