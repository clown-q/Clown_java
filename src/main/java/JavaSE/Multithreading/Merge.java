package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  18:46
 */
public class Merge {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for(int i = 0 ; i < 10 ; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程一");
            }
        });
        Thread thread1 = new Thread(() -> {
            for(int i = 0 ;i < 100 ;i++){
                System.out.println("线程二");
                if(i == 50 ){
                    try {
                        System.out.println("线程一合并");
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
