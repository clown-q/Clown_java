package jackson.jacksonDefaultTyping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonDefaultTyping
 * @Author: Clown
 * @CreateTime: 2023-10-26  11:43
 */
public class test {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();//默认为ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS
        String json = "{\"name\":\"Clown\",\"age\":21,\"sex2\":[\"jackson.jacksonDefaultTyping.RowSex\",{\"sex\":\"男\"}]}";
//        System.out.println(json);
        Person2 person2 = objectMapper.readValue(json, Person2.class); //将json映射到对象上
        System.out.println(person2);
    }
}