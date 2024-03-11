
/*
* Problem Statement: Write a program to initialize an empty stack. Ensure that your stack can hold up to 10 integers.

Objective: Familiarize yourself with the basic structure of a stack.
* */
import java.util.Stack;

public class StackInitialization {


    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>();


        System.out.println("Empty stack initialized with a capacity of 10 integers.");
        //myStack.setSize(10);
        for (int i = 0; i < 10; i++) {

            myStack.push(i);
        }
        System.out.println(myStack);
    }
}
