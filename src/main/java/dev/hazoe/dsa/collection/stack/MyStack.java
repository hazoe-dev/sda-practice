package dev.hazoe.dsa.collection.stack;

public class MyStack {

    int []  array = new int[5];
    int size;
    int top;

    public MyStack(){
        this.size = array.length;
        this.top = -1;
    }

    public void push(int data){
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        array[++top] = data;
    }

    public void print(){
        for (int i = top; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
