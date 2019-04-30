package com.example.quickoff;

// a class that represent a product on the market
public class Product {
    private boolean source; // when this boolean field contains TRUE, then the product is from Amazon.If this field contains FALSE,then the product is from Tmall.
    private String name;    // name of the product
    private String price;   // price of the product
    private String description;     // storage of the product

    // constructor method with no inputs
    public Product(){
        source = false;
        name = null;

    }

    // constructor method with all the inputs
    public Product(boolean input_source, String input_name, String input_price){
        source = input_source;
        name = input_name;
        price = input_price;

    }

    // getter method of source
    public boolean getSource(){
        return this.source;
    }
    // setter method of source
    public void setSource(boolean input){
        this.source = input;
    }
    // getter method of name
    public String getName(){
     return this.name;
    }
    // setter method of name
    public void setName(String input){
        this.name = input;
    }
    // getter method of price
    public String getPrice(){
        return this.price;
    }
    // setter method of price
    public void setPrice(String input){
        this.price = input;
    }
    // getter method of storage
    public String getDescription(){
        return this.description;
    }
    // setter method of storage
    public void setDescription(String input){
        this.description = input;
    }
}
