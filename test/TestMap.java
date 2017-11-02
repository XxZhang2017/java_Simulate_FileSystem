
import java.util.ArrayList;
import java.util.HashMap;
import storeInfo.ShopInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d
 */
public class TestMap {
    public static void main(String[] args) {
        String one="apple";
        int quantity=1;
        boolean addFlag=false;
        double pri=0.88;
        HashMap<String,ShopInfo> shopping=new HashMap<String,ShopInfo>();
        
            for(String name:shopping.keySet()){
                if(name.equals(one)){
                    shopping.get(one).increQuantity(quantity);
                    addFlag=true;
                }
            }
            if(!addFlag){
             shopping.put(one, new ShopInfo(one,quantity,pri));
             addFlag=false;
            }
              
     one="baba";
     
             for(String name:shopping.keySet()){
                if(name.equals(one)){
 //                   System.out.println(name+"  is in it");
                    shopping.get(one).increQuantity(quantity);
 //                   System.out.println(shopping.get(one).getProduct()+"  "+shopping.get(one).getQuantity());
                    addFlag=true;
                }
            }
            if(!addFlag){
             shopping.put(one, new ShopInfo(one,quantity,pri));
             addFlag=false;
            }
          for(ShopInfo shop:shopping.values()){
              System.out.println(shop.getProduct()+" "+shop.gettotal()+" "+shop.getQuantity());
          }
    }
}
