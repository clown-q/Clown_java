package CommonsCollection.Clown_CC1;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.Arrays;
import java.util.List;

public class TransformerTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world");
        Transformer transformer = new Transformer() {
            public Object transform(Object input) {
                return ((String) input).toUpperCase();
            }
        };
        CollectionUtils.transform(strings, transformer);
        System.out.println(strings);  // 输出 [HELLO, WORLD]
    }
}
