package StackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stackOfStrings =new StackOfStrings();
        stackOfStrings.push("one");
        stackOfStrings.push("two");
        stackOfStrings.push("three");

        System.out.println(stackOfStrings.isEmpty());
        System.out.println(stackOfStrings.peek());

        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.pop());
    }
}
