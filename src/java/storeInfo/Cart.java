/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeInfo;

/**
 *
 * @author d
 */
public class Cart {
    private int orderNum;
    private String pro_Name;
    private int number;
    private double sum_price;
    
    public static int orderGen(){
        double random=Math.random()*1000000;
        int or_num=(int)random;
        return or_num;
    }
    
    /*debug
    public static void main(String[] args) {
        System.out.println(Cart.orderGen());
    }*/

    public Cart(String pro_Name, int number, double sum_price) {
        this.orderNum=orderGen();
        this.pro_Name = pro_Name;
        this.number = number;
        this.sum_price = sum_price;
    }
}
