import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class BytecodeToBase64 {
    public static void main(String[] args) {
        try {
            String classFilePath = "E:\\Python\\T.class"; // 替换为你的类文件路径

            // 1. 读取类文件的字节码
            FileInputStream fis = new FileInputStream(classFilePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bis.close();

            // 2. 获取字节码的字节数组
            byte[] bytecode = bos.toByteArray();

            // 3. 使用Base64编码字节码
            String base64Encoded = Base64.getEncoder().encodeToString(bytecode);

            // 4. 输出Base64编码的字节码
            System.out.println(base64Encoded);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
