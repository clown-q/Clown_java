package JavaSE.Multithreading;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  08:04
 */
public class MultithreadingTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0;i<10;i++){
                System.out.println("线程一");
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0;i<10;i++){
                System.out.println("线程二");
            }
        });
        thread.start();  //启动线程
        thread1.start();
    }
}
