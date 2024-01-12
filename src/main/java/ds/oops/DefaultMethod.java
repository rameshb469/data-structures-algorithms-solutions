package ds.oops;

public class DefaultMethod implements A, B{

    static void m(){
        System.out.println("print B");
    }

    public static void main(String[] args) {
        DefaultMethod d = new DefaultMethod();
        d.print();
    }

    @Override
    public void print() {
        A.super.print();
    }
}


interface A {

    static void m(){
        System.out.println("print B");
    }
    default void print(){
        System.out.println("Print A");
    }
}

interface B {

    static void m(){
        System.out.println("print B");
    }
    default void print(){
        System.out.println("Print B");
    }
}
