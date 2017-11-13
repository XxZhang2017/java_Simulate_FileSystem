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

    public Cart() {
    }
    
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getPro_Name() {
        return pro_Name;
    }

    public void setPro_Name(String pro_Name) {
        this.pro_Name = pro_Name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSum_price() {
        return sum_price;
    }

    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }
    
}
