package com.example.quickoff;

public class PreferredList {
    Node head; // the head of the preferred list
    Node ptr; // a pointer suggesting where is the last node

    // a subclass
    class Node{
        Product data;
        Node next;
        Node before;

        Node(Product input){
            before = null;
            data = input;
            next = null;
        }
    }

    // constructor method with no input
    public PreferredList(){
        head = null;
        ptr = null;
    }

    // constructor method with a Product class input
    public PreferredList(Product input){
        head = new Node(input);
        ptr = head;
    }

    public PreferredList add(Product input){
        Node input_node = new Node(input);
        if(this.head == null)
            this.head = input_node;
        else{
            ptr.next = input_node;
            input_node.before = ptr;
            ptr = input_node;
        }
        return this;
    }

    public void printList(){
        Node indexNode = this.head;
        while(indexNode != null){
            System.out.print(indexNode.data.getName() + "  ");
            System.out.println(indexNode.data.getPrice());
            indexNode = indexNode.next;
        }
    }
}
