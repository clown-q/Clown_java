package Clown_Serialization;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class userSerialization {
    public static void main(String[] args) throws Exception{

        User user = new User("test",21);

        //输出
        ByteArrayOutputStream Output = new ByteArrayOutputStream();
        ObjectOutputStream Outputs = new ObjectOutputStream(Output);

        //将对象user序列化为字节数组
        Outputs.writeObject(user);
        Outputs.writeObject("this is a test");
        byte[] userobj = Output.toByteArray();
        System.out.println(DatatypeConverter.printHexBinary(userobj));
        for (byte b:userobj){
            System.out.print((b&0xff));
        }

        //输入流
        ByteArrayInputStream Input = new ByteArrayInputStream(userobj);
        ObjectInputStream Inputs = new ObjectInputStream(Input);

        //将保存在内存内的字节输出反序列化
        User user1 = (User) Inputs.readObject();
        String message = (String) Inputs.readObject();
        System.out.println("\n"+message);
        System.out.println(user1.getName());
    }
}
