package JavaJVM.ClassLoaderTest;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

/**
 * @BelongsProject: study_java
 * @BelongsPackage: JavaJVM.ClassLoaderTest
 * @Author: Clown
 * @CreateTime: 2023-09-12  09:20
 */
public class ASMTest {
    public static void main(String[] args) {
        //ClassWriter.COMPUTE_MAXS自动计算操作数栈和局部变量表大小，需要手动触发
        //如果是参数是0，不会自动计算需要自己手动指定
        //如果是ClassWriter.COMPUTE_FRAMES，会自动计算操作数栈和局部临时变量表大小，并且会自动计算StackMapFrames
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //指定类的一些基本信息
        writer.visit(V1_8,ACC_PUBLIC,"JavaJVM/ClassLoaderTest/ASMTest",null,"java/lang/Object",null);
        MethodVisitor methodVisitor = writer.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

        methodVisitor.visitCode();

        Label label = new Label();
        methodVisitor.visitLabel(label);
        methodVisitor.visitLineNumber(11,label);

        methodVisitor.visitVarInsn(ALOAD,0);
        methodVisitor.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>","()V",false);
        methodVisitor.visitInsn(RETURN);

        Label label1 = new Label();
        methodVisitor.visitLabel(label1);
        methodVisitor.visitLocalVariable("this","LJavaJVM/ClassLoaderTest/ASMTest",null,label,label1,0);
        methodVisitor.visitMaxs(1,1);
        methodVisitor.visitEnd();
        //调用visitEnd结束写入
        writer.visitEnd();

        try(FileOutputStream stream = new FileOutputStream("./ASMtest.class")){
            stream.write(writer.toByteArray());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}