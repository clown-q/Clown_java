package JavaJVM.JVMMemory;

import java.util.ArrayList;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.JVMMemory
 * @Author: Clown
 * @CreateTime: 2023-09-08  15:24
 */
public class test5 {
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        while (true){
            list.add(new Object());
        }
    }
}
