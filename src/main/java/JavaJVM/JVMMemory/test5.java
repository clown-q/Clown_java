package JavaJVM.JVMMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.JVMMemory
 * @Author: Clown
 * @CreateTime: 2023-09-08  15:24
 */
public class test5 {
    static class test{
    }
    public static void main(String[] args){
        List<test> list = new ArrayList();
        while (true){
            list.add(new test());
        }
    }
}
