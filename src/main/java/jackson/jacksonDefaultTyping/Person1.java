package jackson.jacksonDefaultTyping;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonTest
 * @Author: Clown
 * @CreateTime: 2023-10-24  22:42
 */
public class Person1 {
    private String name;
    private int age;
    private Sex1 sex;

    public Person1() {
        System.out.println("调用了Person的无参构造方法");
    }

    public Person1(String name, int age, Sex1 sex) {
        System.out.println("调用了Person的有参构造方法");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        System.out.println("调用Person.getName方法");
        return name;
    }

    public void setName(String name) {
        System.out.println("调用了Person.setName");
        this.name = name;
    }

    public int getAge() {
        System.out.println("调用了Person.getAge方法");
        return age;
    }

    public void setAge(int age) {
        System.out.println("调用了Person.setAge方法");
        this.age = age;
    }

    public Sex1 getsex() {
        System.out.println("调用了Person.getsex方法");
        return sex;
    }

    public void setSex(Sex1 sex) {
        System.out.println("调用了Person.setsex方法");
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

class Sex1{
    private String sex;

    public Sex1() {
        System.out.println("调用了sex的无参构造方法");
    }

    public Sex1(String sex) {
        System.out.println("调用了sex的有参构造方法");
        this.sex = sex;
    }

    public String getSex() {
        System.out.println("调用了sex.getSex方法");
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("调用了sex.setSex方法");
        this.sex = sex;
    }

}