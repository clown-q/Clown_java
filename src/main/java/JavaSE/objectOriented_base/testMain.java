package JavaSE.objectOriented_base;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaSE.objectOriented
 * @Author: Clown
 * @CreateTime: 2023-07-22  10:05
 */
public class testMain {
    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest("小王");
        studentTest.eatTest();
        TeacherTest teacherTest = new TeacherTest("王老师");
        teacherTest.eatTest();
    }
}
