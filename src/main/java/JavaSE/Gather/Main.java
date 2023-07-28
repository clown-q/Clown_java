package JavaSE.Gather;

import java.util.*;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.Gather
 * @Author: Clown
 * @CreateTime: 2023-07-26  18:42
 */
public class Main {
//    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(10);
//        System.out.println(arrayList.contains(10));
//        arrayList.add(10);
//        System.out.println(arrayList);
//    }
//    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add("a");
//        set.add("b");
//        set.add("c");
//        set.add("d");
//        set.add("e");
//        System.out.println(set);
//    }
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"test1");
        map.put(2,"test2");
        System.out.println(map.get(2));
    }
}
