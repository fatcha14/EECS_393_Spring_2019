package com.example.quickoff;

public class Product {
    private boolean source; // when this boolean field contains TRUE, then the product is from Amazon.If this field contains FALSE,then the product is from Tmall.
    private String name;
    private String price;
    private String description;

    public Product(){
        source = false;
        name = null;

    }

    public Product(boolean input_source, String input_name, String input_price){
        source = input_source;
        name = input_name;
        price = input_price;

    }

    public boolean getSource(){
        return this.source;
    }

    public void setSource(boolean input){
        this.source = input;
    }

    public String getName(){
     return this.name;
    }

    public void setName(String input){
        this.name = input;
    }

    public String getPrice(){
        return this.price;
    }

    public void setPrice(String input){
        this.price = input;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String input){
        this.description = input;
    }
}
