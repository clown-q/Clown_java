package CommonsCollection.Clown_CC3;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ConstantTransformer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class POC1 {
    public static void Serliazation(Object object) throws Exception{
        FileOutputStream fileInputStream = new FileOutputStream("poc1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        objectOutputStream.writeObject(object);
        System.out.println("Output");
    }

    public static void Unserlization() throws Exception{
        FileInputStream fileInputStream =new FileInputStream("poc1.txt");
        ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("Input");
    }

    public static void main(String[] args) throws Exception{

    }
}
