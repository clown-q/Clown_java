package jackson.jacksonDefaultTyping;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonTest
 * @Author: Clown
 * @CreateTime: 2023-10-25  19:17
 */
public class Person3 {
    private String sex;
    public Object object;

    public Person3() {
        System.out.println("Person3的无参构造函数");
    }

    public Person3(String sex) {
        System.out.println("调用了构造方法");
        this.sex = sex;
    }

    public String getSex() {
        System.out.println("调用了getSex");
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("调用了setSex");
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "sex='" + sex + '\'' +
                ", object=" + object +
                '}';
    }
}

class Student3 {
    private String name;

    public Student3() {
        System.out.println("Student3构造函数");
    }

    public Student3(String name) {
        System.out.println("调用了Student3的构造函数");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}