package com.ynhuang.thinking.asm;


import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author YuHuang
 */
public class MyClassVisitor extends ClassVisitor {

    public MyClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM7, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

        MethodVisitor methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if (!"<init>".equalsIgnoreCase(name) && null != methodVisitor) {
            methodVisitor = new MyVistorMethod(methodVisitor);
        }

        return methodVisitor;
    }

    class MyVistorMethod extends MethodVisitor {

        public MyVistorMethod(MethodVisitor methodVisitor) {
            super(Opcodes.ASM7, methodVisitor);
        }

        @Override
        public void visitCode() {
            mv.visitCode();

            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
            mv.visitVarInsn(ASTORE, 1);

        }

        @Override
        public void visitInsn(int opcode) {

            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
                mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                mv.visitVarInsn(LSTORE, 2);
                Label label7 = new Label();
                mv.visitLabel(label7);
                mv.visitLineNumber(20, label7);
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitVarInsn(LLOAD, 2);
                mv.visitVarInsn(ALOAD, 1);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false);
                mv.visitInsn(LSUB);
                mv.visitLdcInsn(new Long(1000L));
                mv.visitInsn(LDIV);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
                Label label8 = new Label();
                mv.visitLabel(label8);
                mv.visitLineNumber(21, label8);
            }

        }
    }
}
