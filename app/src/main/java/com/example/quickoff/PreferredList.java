package com.example.quickoff;
import java.util.*;

// a class used to implement the Preferred lis function, the data structure is linked list
public class PreferredList {
    Node head; // the head of the preferred list
    Node ptr; // a pointer suggesting where is the last node

    // a subclass
    class Node{
        // use a data class to store informations
        Product data;
        // reference of next node
        Node next;

        // constructor method
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

    // a method that add a input product into the list
    public PreferredList add(Product input){
        // create a new node using the input product as data
        Node input_node = new Node(input);
        // if there are no product store in the preferred list, add the input product as the first.
        // If there are already other products add the new product to the end of the list
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

    // a method that delete a product from given node in the preferred list
    public PreferredList remove(Node input){
        // delete the data from the existing node and change the data to the next product in the list
        input.data = input.next.data;
        input.next.data = null;
        // delete the referrence from the existing node and change the reference to that of the next node in the list
        input.next = input.next.next;
        input.next.next = null;
        return this;
    }

    //a method that tries to find a given product in the list and delete that product from the preferred list
    public void remove(Product input){
        // make cursor start from the beginning of the list
        Node index = this.head;
        // a while loop to find the input product, if found, remove it, if not, error.
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

    //a method that convert the existing preferred list to a string array
    public String[] asArray(){
        // create result array
        ArrayList<String> result = new <String>ArrayList();
        // cursor
        Node indexNode = this.head;
        while(indexNode != null){
            result.add(indexNode.data.getName());
            indexNode = indexNode.next;
        }
        // convert the arraylist to array like asked.
        return result.toArray(new String[0]);
    }

}
