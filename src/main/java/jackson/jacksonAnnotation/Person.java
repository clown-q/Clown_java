package jackson.jacksonAnnotation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonAnnotation
 * @Author: Clown
 * @CreateTime: 2023-10-25  20:17
 */
public class Person {
    public String name;
    public int age;
//    @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
//    @JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS)
//    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
//    @JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM)
    public Object obj;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", obj=" + obj +
                '}';
    }
}

class Student{
    public int point = 100;
}