package com.clouway.Warehouse;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PrintProducts {
    private List<BaseProduct> listOfProducts = new LinkedList<>();
    public PrintProducts() {
    }

    /**
     * Getter for listOfProducts
     * @return list of all products
     */
    public List<BaseProduct> getAllProducts(){ return listOfProducts;}

    /**
     * Adds or updates product in listOfAllProducts
     * @param product product being added or updated
     */
    public void addProduct(BaseProduct product){
        if(listOfProducts.contains(product)){
            listOfProducts.remove(product);
            listOfProducts.add(product);
        } else {
            listOfProducts.add(product);
        }
    }

    /**
     * Prints every product
     */
    public void printAllProducts(){
        for (BaseProduct bp: listOfProducts) {
            System.out.print(bp);
        }
    }

    /**
     * Prints every product sorted by price
     */
    public void printSorted(){
        List<BaseProduct> sorted = new LinkedList<>(listOfProducts);
        sorted.sort(new Comparator<BaseProduct>() {
            @Override
            public int compare(BaseProduct o1, BaseProduct o2) {
                return Double.compare(o1.getSellPrice(), o2.getSellPrice());
            }
        });

        for (BaseProduct bp: sorted) {
            System.out.print(bp);
        }
    }
}
