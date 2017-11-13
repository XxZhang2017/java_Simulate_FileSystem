/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeInfo;

import java.io.Serializable;
import static java.lang.Math.*;

/**
 *
 * @author d
 */
public class ShopInfo implements Serializable {
    private String product;
    private int quantity;
    private double price;
    private double total;
    
    public ShopInfo() {
         this.product = "";
        this.quantity = -1;
        this.price=0.0;
    }

    public ShopInfo(String product, int quantity,double perPrice) {
        this.product = product;
        this.quantity = quantity;
        this.price=perPrice;
        this.total=round(price*quantity,2);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void increQuantity(int newQuanti){
        quantity=newQuanti+quantity;
          total=round(price*quantity,2);
 //       System.out.println(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
}
