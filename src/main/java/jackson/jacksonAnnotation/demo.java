package jackson.jacksonAnnotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonAnnotation
 * @Author: Clown
 * @CreateTime: 2023-10-25  20:18
 */
public class demo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.name = "Clown";
        person.age = 21;
        person.obj = new Student();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
        Person person1 = objectMapper.readValue(json,Person.class);
        System.out.println(person1);
    }
}