package com.clouway.Warehouse;

import com.clouway.Main;

import java.text.DecimalFormat;

public class BaseProduct {
    private String name;
    private double buyPrice;
    private double sellPrice;
    private double inStock;
    private double maxCapacity;

    private double moneyGained = 0;
    private double moneySpent = 0;
    private double profits = 0;
    private DecimalFormat df = new DecimalFormat("#.#######");

    /**
     * Constructor for BaseProduct
     * Sets all params, checks if inStock exceeds maxCapacity and adds this product to list of all products
     * @param name product name
     * @param buyPrice price for which this product is bought
     * @param sellPrice sell price
     * @param inStock in stock
     * @param maxCapacity maximum capacity
     */
    public BaseProduct(String name, double buyPrice, double sellPrice, double inStock, double maxCapacity) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        if(inStock<=maxCapacity) {
            this.inStock = inStock;
            this.moneySpent = inStock*buyPrice;
        }else {
            System.out.printf("temp Cant add %s %ss, maximum capacity is %s. In stock is set to 0\n"
                    , df.format(inStock), name, df.format(maxCapacity));
            this.inStock = 0;
        }
        this.maxCapacity = maxCapacity;
        Main.printer.addProduct(this);
    }

    /**
     * Getters
     */
    public String getName() {return name;}
    public double getBuyPrice() {return buyPrice;}
    public double getSellPrice() {return sellPrice;}
    public double getInStock() {return inStock;}
    public double getMaxCapacity() {return maxCapacity;}
    public double getMoneyGained() {return Double.parseDouble(df.format(moneyGained));}
    public double getMoneySpent() {return Double.parseDouble(df.format(moneySpent));}
    public double getProfits(){return Double.parseDouble(df.format(moneyGained-moneySpent));}

    /**
     * Setters
     */
    public void setName(String name) {this.name = name;}
    public void setBuyPrice(double buyPrice) {this.buyPrice = buyPrice;}
    public void setSellPrice(double sellPrice) {this.sellPrice = sellPrice;}
    public void setInStock(double inStock) {this.inStock = inStock;}
    public void setMaxCapacity(double maxCapacity) {this.maxCapacity = maxCapacity;}

    /**
     * Adds amountAdded amount of product type elements in the warehouse if there is space.
     * Calculates how much money is spent buying products
     * Updates this class in printer class
     * @param amountAdded how much product is being added
     */
    public void add(double amountAdded) {
        if(inStock +amountAdded <= maxCapacity) {
            this.inStock += amountAdded;
            this.moneySpent += amountAdded * buyPrice;
            Main.printer.addProduct(this);
        } else {
            System.out.printf("temp Cant add %s %ss! Currently %s is at %s/%s!\n",
                    df.format(amountAdded), name, name, df.format(inStock),df.format(maxCapacity));
        }
    }

    /**
     * Sells amountSould amount of product if there is enough in stock
     * Calculates how much money is gained in the process
     * Updates this class in printer class
     * @param amountSold amount of product sold
     */
    public void sell(double amountSold){
        if(amountSold>inStock){
            System.out.printf("temp Cant sell %s %ss! Only %s/%s left in stock!\n",
                    df.format(amountSold),name,df.format(inStock),df.format(maxCapacity));
        } else {
            this.inStock -= amountSold;
            this.moneyGained += amountSold*sellPrice;
            Main.printer.addProduct(this);
        }
    }

    /**
     * toString override for better representation of sorted List of classes
     * @return BaseProduct class in order
     */
    @Override
    public String toString(){
        return "Name: "+name+" Price: "+ sellPrice +" In stock: "+inStock+" Max Capacity: "+maxCapacity+"\n";
    }
}
