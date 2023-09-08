package JavaJVM.JVMMemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.JVMMemory
 * @Author: Clown
 * @CreateTime: 2023-09-08  16:40
 */
public class UnsafeTest {
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        long addr = unsafe.allocateMemory(4);
        unsafe.putInt(addr,123456);//向地址中设置值
        System.out.println(unsafe.getInt(addr));//获取对应地址上的内容

        unsafe.freeMemory(addr);//释放内存
    }
}
