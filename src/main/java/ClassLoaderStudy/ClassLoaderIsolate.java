package ClassLoaderStudy;


/**
 * @BelongsProject: study_java
 * @BelongsPackage: ClassLoaderStudy
 * @Author: Clown
 * @CreateTime: 2023-10-31  14:33
 */

public class ClassLoaderIsolate {
    public static String ClassName = "B";
    public static byte[] bytes = new byte[]{-54,-2,-70,-66,0,0,0,52,0,40,10,0,9,0,24,10,0,25,0,26,8,0,27,10,0,25,0,28,7,0,29,
            7,0,30,10,0,6,0,31,7,0,32,7,0,33,1,0,6,60,105,110,105,116,62,1,0,3,40,41,86,1,0,4,67,111,100,101,1,0,15,
            76,105,110,101,78,117,109,98,101,114,84,97,98,108,101,1,0,18,76,111,99,97,108,86,97,114,105,97,98,108,101,
            84,97,98,108,101,1,0,4,116,104,105,115,1,0,3,76,66,59,1,0,8,60,99,108,105,110,105,116,62,1,0,1,101,1,0,21,
            76,106,97,118,97,47,105,111,47,73,79,69,120,99,101,112,116,105,111,110,59,1,0,13,83,116,97,99,107,77,97,112,
            84,97,98,108,101,7,0,29,1,0,10,83,111,117,114,99,101,70,105,108,101,1,0,6,66,46,106,97,118,97,12,0,10,0,11,7,
            0,34,12,0,35,0,36,1,0,4,99,97,108,99,12,0,37,0,38,1,0,19,106,97,118,97,47,105,111,47,73,79,69,120,99,101,
            112,116,105,111,110,1,0,26,106,97,118,97,47,108,97,110,103,47,82,117,110,116,105,109,101,69,120,99,101,112,
            116,105,111,110,12,0,10,0,39,1,0,1,66,1,0,16,106,97,118,97,47,108,97,110,103,47,79,98,106,101,99,116,1,0,17,
            106,97,118,97,47,108,97,110,103,47,82,117,110,116,105,109,101,1,0,10,103,101,116,82,117,110,116,105,109,101,
            1,0,21,40,41,76,106,97,118,97,47,108,97,110,103,47,82,117,110,116,105,109,101,59,1,0,4,101,120,101,99,1,0,39,
            40,76,106,97,118,97,47,108,97,110,103,47,83,116,114,105,110,103,59,41,76,106,97,118,97,47,108,97,110,103,47,
            80,114,111,99,101,115,115,59,1,0,24,40,76,106,97,118,97,47,108,97,110,103,47,84,104,114,111,119,97,98,108,101,
            59,41,86,0,33,0,8,0,9,0,0,0,0,0,2,0,1,0,10,0,11,0,1,0,12,0,0,0,47,0,1,0,1,0,0,0,5,42,-73,0,1,-79,0,0,0,2,0,13,
            0,0,0,6,0,1,0,0,0,9,0,14,0,0,0,12,0,1,0,0,0,5,0,15,0,16,0,0,0,8,0,17,0,11,0,1,0,12,0,0,0,102,0,3,0,1,0,0,0,23,
            -72,0,2,18,3,-74,0,4,87,-89,0,13,75,-69,0,6,89,42,-73,0,7,-65,-79,0,1,0,0,0,9,0,12,0,5,0,3,0,13,0,0,0,22,0,5,
            0,0,0,12,0,9,0,15,0,12,0,13,0,13,0,14,0,22,0,16,0,14,0,0,0,12,0,1,0,13,0,9,0,18,0,19,0,0,0,20,0,0,0,7,0,2,76,
            7,0,21,9,0,1,0,22,0,0,0,2,0,23
    };
    public static class ClassLoaderA extends ClassLoader {

        public ClassLoaderA(ClassLoader parent) {
            super(parent);
        }

        {
            // 加载类字节码
            defineClass(ClassName, bytes, 0, bytes.length);
        }

    }

    public static class ClassLoaderB extends ClassLoader {

        public ClassLoaderB(ClassLoader parent) {
            super(parent);
        }

        {
            // 加载类字节码
            defineClass(ClassName, bytes, 0, bytes.length);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        ClassLoaderA classLoaderA = new ClassLoaderA(classLoader);
        ClassLoaderB classLoaderB = new ClassLoaderB(classLoader);

        Class classa = Class.forName(ClassName,true,classLoaderA);
        Class classaa = Class.forName(ClassName,true,classLoaderA);
        Class classb = Class.forName(ClassName,true,classLoaderB);
        System.out.println("classa == classaa"+"======"+(classa == classaa));
        System.out.println("classa == classb" +"======"+(classa == classb));
//        System.out.println(classa.getName());
    }
}
