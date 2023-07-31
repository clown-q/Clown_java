package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  17:48
 */
public class InterruptPause {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for(int i = 0 ; i < 100 ; i++){
                if(i==50){
                    System.out.println("等一会");
                    Thread.currentThread().suspend();//暂停线程
                    System.out.println("开始运行");
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                thread.resume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread1.start();
    }
}
