package com.example.myapplication.GameMech;

//This is a class used to store the quantity available and cost of each item available in the stores.
//Future version will load parameters for these values to generate random quantities based on the configuration spreadsheet
public class StoreItem {
    //Number of items available in this store
    private int quantity;
    //Price of the item
    private double cost;
    private Item item;

    public StoreItem(Item item, int quantity, double cost){
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    //Lowers the amount by how many are bought when a purchase is made
    //Returns true if enough exist to make purchase, false if not trying to buy more than exist
    public boolean lowerQuantity(int quantityBought) {
        if(quantity-quantityBought>=0){
            this.quantity -= quantityBought;
            return true;
        }
        return false;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
