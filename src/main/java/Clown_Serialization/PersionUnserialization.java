package Clown_Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersionUnserialization {
    public static Object Unserialization() throws Exception{
        ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream("person.txt"));
        Object obj = objectInputStream.readObject();
        return obj;
    }

    public static void main(String[] args)throws Exception{
        Person person = (Person) Unserialization();
        System.out.println(person);

    }
}
