package JavaSE.Generic;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Generic
 * @Author: Clown
 * @CreateTime: 2023-07-25  08:32
 */
public class GenericTest<T extends Number> {
    String name;
    T age;

    public GenericTest(String name, T age) {
        this.name = name;
        this.age = age;
    }
    public void echo(){
        System.out.println(this.name+":"+this.age);
    }
}
