package JavaSE.Generic;

import java.util.Optional;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Generic
 * @Author: Clown
 * @CreateTime: 2023-07-25  13:10
 */
public class EmptyTest {
    public static void main(String[] args) {
        test("mmm" );
        test(null);
    }

    public static void test(String str){
        Optional
                .ofNullable(str)
                .ifPresent(a ->{
                    if (!a.isEmpty()){
                        System.out.println(a.length());
                    }
                });
    }
}
