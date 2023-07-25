package JavaSE.Generic;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Generic
 * @Author: Clown
 * @CreateTime: 2023-07-25  08:35
 */
public class Test {
    public static void main(String[] args) {
        GenericTest<? super Integer> genericTest2 = new GenericTest<>("小明",30);
        genericTest2.echo();
    }
}
