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
public class CusInfo {
    private String email;
    private int cusID;
        public static int cusIdGen(){
        double random=Math.random()*10000;
        int or_num=(int)random;
        return or_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public CusInfo(String email) {
        this.email = email;
        this.cusID = CusInfo.cusIdGen();
    }
        
}
