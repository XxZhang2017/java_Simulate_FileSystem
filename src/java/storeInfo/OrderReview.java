/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author d
 */
public class OrderReview {
 /*   private int card;
    private String product;
    private int count;
    private double sumLitte;*/
    List<Cart> cartItem=new ArrayList<Cart>();
    private double sumUp=0.0;

    public OrderReview() {
        
    }

    public List<Cart> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<Cart> cartItem) {
        this.cartItem = cartItem;
    }

    public double getSumUp() {
        return sumUp;
    }

    public void setSumUp(double sumUp) {
        this.sumUp = sumUp;
    }
    
    
}
