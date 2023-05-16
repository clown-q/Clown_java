package Clown_Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PersonSerialization {
    public static void serialize(Object obj) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
    }

    public static void main(String[] args) throws Exception{
        Person person = new Person("aa",22);
        serialize(person);
    }
}
