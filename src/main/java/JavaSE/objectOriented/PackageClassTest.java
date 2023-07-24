package JavaSE.objectOriented;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.objectOriented
 * @Author: Clown
 * @CreateTime: 2023-07-24  07:58
 */
public class PackageClassTest {
    public static void main(String[] args) {
        test("a","b","c");
    }
    public static  void test(String... str){
        for (String s : str) {
            System.out.println(s);
        }
    }
}
