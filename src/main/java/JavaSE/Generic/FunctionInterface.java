package JavaSE.Generic;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Generic
 * @Author: Clown
 * @CreateTime: 2023-07-25  18:49
 */
public class FunctionInterface {

    private static final Function<test,String> INTEGER_STRING_FUNCTION = Objects::toString;
    public static void main(String[] args) {
        String str = INTEGER_STRING_FUNCTION.apply(new test());
        System.out.println(str);
    }
    public static class test{
        public void test(){
            System.out.println("hello");
        }
    }
}
