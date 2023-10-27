import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

public class TestClass {
    public static void serialization(Object object)  throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("URLDNS.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        System.out.println("serialization方法成功执行");
    }

    public static void serializeAndPrintBase64(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        byte[] serializedBytes = byteArrayOutputStream.toByteArray();

        // 使用Base64编码字节数组并打印到控制台
        String base64Encoded = Base64.getEncoder().encodeToString(serializedBytes);
//        String payload = Arrays.toString(Base64.getDecoder().decode(base64Encoded));
//        System.out.println(payload);
        System.out.println(base64Encoded);
    }


    public static void unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("URLDNS.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("unserialization执行成功");
    }

    public static void main(String[] args) throws Exception{
        String filePath = "E:\\study_java\\target\\classes\\B.class";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] data = new byte[fis.available()]; // 创建一个字节数组，大小等于文件大小
            fis.read(data); // 读取文件内容到字节数组

            // 打印字节数据
            for (byte b : data) {
                System.out.print(b + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}