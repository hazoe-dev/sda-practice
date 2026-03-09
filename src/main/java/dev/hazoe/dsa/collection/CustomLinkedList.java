package dev.hazoe.dsa.collection;

class CustomNode {
    int data;
    CustomNode next;

    public CustomNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomLinkedList {
    CustomNode head;

    public void add(int data) {
        CustomNode newNode = new CustomNode(data);
        CustomNode current = head;
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printValues() {
        CustomNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }
}


