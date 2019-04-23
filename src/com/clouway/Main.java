package com.clouway;

import com.clouway.Warehouse.BaseProduct;
import com.clouway.Warehouse.PrintProducts;


public class Main {
public static PrintProducts printer = new PrintProducts();

    public static void main(String[] args) {
        BaseProduct cows = new BaseProduct("cow",50,60,30,100);
        BaseProduct sheep = new BaseProduct("sheep",10,20,30,40);
        cows.add(5);
        cows.sell(3);
        sheep.add(3);
        printer.printAllProducts();
        printer.printSorted();
    }
}
