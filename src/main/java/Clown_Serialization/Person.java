package Clown_Serialization;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    private int age;
    public Person(){
        System.out.println("无参的构造函数");
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name="+name+"\'"+
                ", age=" + age +'}';
    }


    private void readObject(ObjectInputStream ois) throws Exception{
        ois.defaultReadObject();
        Runtime.getRuntime().exec("calc");
    }

}
