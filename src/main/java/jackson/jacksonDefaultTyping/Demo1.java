package jackson.jacksonDefaultTyping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonTest
 * @Author: Clown
 * @CreateTime: 2023-10-24  22:43
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        Person1 person = new Person1("Clown",21,new Sex1("男"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
        String json = objectMapper.writeValueAsString(person); //将对象转化为json
        System.out.println(json);
        Person1 person1 = objectMapper.readValue(json, Person1.class); //将json映射到对象上
        System.out.println(person1);
    }
}
