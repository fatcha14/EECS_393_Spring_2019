package com.example.quickoff;
import java.util.*;

public class PreferredList {
    Node head; // the head of the preferred list
    Node ptr; // a pointer suggesting where is the last node

    // a subclass
    class Node{
        Product data;
        Node next;

        Node(Product input){
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
        if(this.head == null) {
            this.head = input_node;
            ptr = this.head;
        }
            else{
            ptr.next = input_node;
            ptr = input_node;
        }
        return this;
    }

    public PreferredList remove(Node input){
        input.data = input.next.data;
        input.next.data = null;
        input.next = input.next.next;
        input.next.next = null;
        return this;
    }

    public void remove(Product input){
        Node index = this.head;
        while(index != null || index.data != input){
            index = index.next;
        }
        if(index != null) {
            index.data = index.next.data;
            index.next.data = null;
            index.next = index.next.next;
            index.next.next = null;
        }
        else{
            System.out.print("No such item");
        }
    }

    public String[] asArray(){
        ArrayList<String> result = new <String>ArrayList();
        Node indexNode = this.head;
        while(indexNode != null){
            result.add(indexNode.data.getName());
            indexNode = indexNode.next;
        }
        return result.toArray(new String[0]);
    }

}
