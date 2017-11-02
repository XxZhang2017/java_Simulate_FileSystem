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
public class OrderInfo {
    private int orId;
    private int carNum;
    private int cusId;
    private String totalPri;

    public OrderInfo(int orId, int carNum, int cusId, String totalPri) {
        this.orId = orId;
        this.carNum = carNum;
        this.cusId = cusId;
        this.totalPri = totalPri;
    }

    public int getOrId() {
        return orId;
    }

    public void setOrId(int orId) {
        this.orId = orId;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getTotalPri() {
        return totalPri;
    }

    public void setTotalPri(String totalPri) {
        this.totalPri = totalPri;
    }
    
}
