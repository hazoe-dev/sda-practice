package dev.hazoe.dsa.collection.stack;

import java.util.Stack;

public class StackUsage {
    public static void main(String[] args) {

        //useAvailableLib();
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println(stack.peek());
        stack.print();


        MyStack stack2 = new MyStack();
        System.out.println(stack2.pop());


    }
    public static boolean isValid(String str){
        return str!=null && str.matches("^[A-Za-z0-9_]+$");
    }

    private static void useAvailableLib() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
    }
}
