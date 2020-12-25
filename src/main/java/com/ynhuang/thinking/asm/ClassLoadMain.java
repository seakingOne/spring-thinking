package com.ynhuang.thinking.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassLoadMain {

    public static void main(String[] args) throws IOException, InterruptedException {

        ClassReader classReader = new ClassReader("com/ynhuang/thinking/asm/TestCC");

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor classVisitor = new MyClassVisitor(classWriter);

        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);

        byte[] bytes = classWriter.toByteArray();

        File file = new File("target/classes/com/ynhuang/thinking/asm/TestCC.class");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);

        System.out.println("success");

    }
}
