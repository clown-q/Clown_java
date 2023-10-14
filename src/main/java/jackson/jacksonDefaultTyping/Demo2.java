package jackson.jacksonDefaultTyping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonTest
 * @Author: Clown
 * @CreateTime: 2023-10-25  17:27
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        Person2 person = new Person2("Clown",21,new RowSex());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();//默认为ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS
        String json = objectMapper.writeValueAsString(person); //将对象转化为json
        System.out.println(json);
        Person2 person2 = objectMapper.readValue(json, Person2.class); //将json映射到对象上
        System.out.println(person2);
    }
}