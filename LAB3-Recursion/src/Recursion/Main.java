package Recursion;

public class Main {

    public static void methodThree() {
        System.out.println("Three");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Two");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("One");
    }

    //main method
    public static void main(String[] args) {
        methodOne();
    }



}
