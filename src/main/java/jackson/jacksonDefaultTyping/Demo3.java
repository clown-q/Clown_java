package jackson.jacksonDefaultTyping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonTest
 * @Author: Clown
 * @CreateTime: 2023-10-25  19:09
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        Person3 person = new Person3("男");
        Student3[] student3s =new Student3[3];
        student3s[0] = new Student3("test1");
        student3s[1] = new Student3("test2");
        student3s[2] = new Student3("test3");
        person.object = student3s;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
        String json = objectMapper.writeValueAsString(person); //将对象转化为json
        System.out.println(json);
        Person3 person3 = objectMapper.readValue(json, Person3.class); //将json映射到对象上
        System.out.println(person3);
    }
}