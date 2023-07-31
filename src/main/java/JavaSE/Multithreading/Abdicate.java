package JavaSE.Multithreading;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Multithreading
 * @Author: Clown
 * @CreateTime: 2023-07-31  18:22
 */
public class Abdicate {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for(int i = 0 ; i < 100 ; i++){
                System.out.println("线程一");
                if(i%2 == 0 ){
                    System.out.println("线程一满足条件，让位");
                    Thread.yield(); //暂时让出cpu
                }
            }
        });
        Thread thread1 = new Thread(() -> {
           for(int i = 0 ;i < 100 ;i++){
               System.out.println("线程二");
               if(i%10 == 0 ){
                   System.out.println("线程二满足条件，让位");
                   Thread.yield();
               }
           }
        });
        thread.start();
        thread1.start();
    }
}
