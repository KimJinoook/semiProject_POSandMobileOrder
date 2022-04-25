/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

import java.sql.Timestamp;

/**
 *
 * @author EZEN
 */
public class ToDTO {
    private int st_no;
    private int od_no;
    private int op_price;
    private Timestamp od_date;
    private String od_pay;

    public ToDTO() {
    }

    public ToDTO(int st_no, int od_no, int op_price, Timestamp od_date, String od_pay) {
        this.st_no = st_no;
        this.od_no = od_no;
        this.op_price = op_price;
        this.od_date = od_date;
        this.od_pay = od_pay;
    }

    public int getSt_no() {
        return st_no;
    }

    public void setSt_no(int st_no) {
        this.st_no = st_no;
    }

    public int getOd_no() {
        return od_no;
    }

    public void setOd_no(int od_no) {
        this.od_no = od_no;
    }

    public int getOp_price() {
        return op_price;
    }

    public void setOp_price(int op_price) {
        this.op_price = op_price;
    }

    public Timestamp getOd_date() {
        return od_date;
    }

    public void setOd_date(Timestamp od_date) {
        this.od_date = od_date;
    }

    public String getOd_pay() {
        return od_pay;
    }

    public void setOd_pay(String od_pay) {
        this.od_pay = od_pay;
    }
    
    
    
}
