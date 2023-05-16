package Clown_Serialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class test {
    public test() throws Exception {
    }

    public static void main(String[] args) throws Exception {
//        Class cls1 = Class.forName("Clown_serialization.User");
////        System.out.println(cls1);
//        Constructor constructor = cls1.getConstructor(String.class, int.class);//getConstructor方法用于检索表示类的公共构造函数的Constructor对象
////        System.out.println(constructor);
//        User user = (User) constructor.newInstance("admin", 19);//实例化类对象的方法
////        System.out.println(user);
////        System.out.println(user.getName());
//        Method method1 = cls1.getMethod("getName");
//        System.out.println(method1.invoke(user));//这里调用了getName方法
//        Method method2 = cls1.getMethod("setAge", int.class);
//        method2.invoke(user, 21);//这里调用了setAge方法
//        System.out.println(user.getAge());
//
//        //获取成员变量
//        Field field = cls1.getDeclaredField("name");
////        System.out.println(field);
//        field.setAccessible(true);
//        field.set(user,"root");
//        System.out.println(user.getName());
//
//        //获取全部的成员变量
//        Field[] fields = cls1.getDeclaredFields();
//        for (Field i:fields)
//        {
//            i.setAccessible(true);
//            System.out.println(i.getName()+":"+i.get(user));
//        }
//
        Class clazz = Class.forName("Clown_Serialization.Person");
//        System.out.println(clazz);
        //实例化对象
//        clazz.newInstance();
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        Person person = (Person) constructor.newInstance("asgdhj",22);
        System.out.println(person);
        //获取属性
        Field field = clazz.getField("name");
        field.set(person,"aaaaa");
        System.out.println(person);
        Field field1 = clazz.getDeclaredField("age");
        field1.setAccessible(true);
        field1.set(person,111);
        System.out.println(person);

    }
}
