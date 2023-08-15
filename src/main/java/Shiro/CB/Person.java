package Shiro.CB;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Shiro.CB
 * @Author: Clown
 * @CreateTime: 2023-08-09  08:29
 */
public class Person {
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
