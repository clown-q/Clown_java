package jackson.jacksonDefaultTyping;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: jackson.jacksonTest
 * @Author: Clown
 * @CreateTime: 2023-10-25  17:28
 */
public class Person2 {
    private String name;
    private int age;
    private Sex2 sex2;


    public Person2() {
        System.out.println("调用了Person的无参构造方法");
    }

    public Person2(String name, int age, Sex2 sex2) {
        this.name = name;
        this.age = age;
        this.sex2 = sex2;
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

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex2=" + sex2 +
                '}';
    }

    public Sex2 getSex2() {
        System.out.println("调用了perso.getSex方法");
        return sex2;
    }

    public void setSex2(Sex2 sex2) {
        System.out.println("调用了person.setSex方法");
        this.sex2 = sex2;
    }
}
interface Sex2{
    public String getSex();
    public void setSex(String sex);

}

class RowSex implements Sex2{
    private String sex="男";

    @Override
    public String getSex() {
        System.out.println("调用了RowSex的getSex方法");
        return this.sex;
    }

    @Override
    public void setSex(String sex) {
        System.out.println("调用了RowSex的setSex方法");
        this.sex = sex;
    }
}
