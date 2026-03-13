package dev.hazoe.dsa.collection.linked_list;

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
        if (head == null) {
            head = newNode;
            return;
        }

        CustomNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    public void printValues() {
        CustomNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data) {
        CustomNode newNode = new CustomNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
        }

        CustomNode current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }
}


