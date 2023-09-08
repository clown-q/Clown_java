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
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;
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
    }
}
