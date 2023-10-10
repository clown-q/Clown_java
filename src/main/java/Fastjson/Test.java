package Fastjson;

import java.util.Map;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson
 * @Author: Clown
 * @CreateTime: 2023-10-08  12:57
 */
public class Test {
    private String name;
    private int age;
    private Map map;

    public Test() {
//        必须有无参的构造方法，以便JSON库能够实例化对象
        System.out.println("构造方法");
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public int getAge() {
        System.out.println("getAge");
        return age;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setAge");
        this.age = age;
    }

    public Map getMap() {
        System.out.println("getMap");
        return map;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
