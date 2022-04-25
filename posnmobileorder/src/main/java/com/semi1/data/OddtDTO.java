/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

/**
 *
 * @author EZEN
 */
public class OddtDTO {
    private int st_no;
    private int od_number;
    private int pd_no;
    private int oddt_cnt;
    private String oddt_io;
    private String oddt_ice;
    private String oddt_shot;
    private String oddt_name;
    private int oddt_price;

    public OddtDTO() {
    }

    public OddtDTO(int st_no, int od_number, int pd_no, String oddt_io, String oddt_ice, String oddt_shot) {
        this.st_no = st_no;
        this.od_number = od_number;
        this.pd_no = pd_no;
        this.oddt_io = oddt_io;
        this.oddt_ice = oddt_ice;
        this.oddt_shot = oddt_shot;
    }

    public int getOddt_price() {
        return oddt_price;
    }

    public void setOddt_price(int oddt_price) {
        this.oddt_price = oddt_price;
    }
    

    public int getOddt_cnt() {
        return oddt_cnt;
    }

    public void setOddt_cnt(int oddt_cnt) {
        this.oddt_cnt = oddt_cnt;
    }
    
    public int getSt_no() {
        return st_no;
    }

    public void setSt_no(int st_no) {
        this.st_no = st_no;
    }

    public int getOd_number() {
        return od_number;
    }

    public void setOd_number(int od_number) {
        this.od_number = od_number;
    }

    public int getPd_no() {
        return pd_no;
    }

    public void setPd_no(int pd_no) {
        this.pd_no = pd_no;
    }

    public String getOddt_io() {
        return oddt_io;
    }

    public void setOddt_io(String oddt_io) {
        this.oddt_io = oddt_io;
    }

    public String getOddt_ice() {
        return oddt_ice;
    }

    public void setOddt_ice(String oddt_ice) {
        this.oddt_ice = oddt_ice;
    }

    public String getOddt_shot() {
        return oddt_shot;
    }

    public void setOddt_shot(String oddt_shot) {
        this.oddt_shot = oddt_shot;
    }

    public String getOddt_name() {
        return oddt_name;
    }

    public void setOddt_name(String oddt_name) {
        this.oddt_name = oddt_name;
    }
    
    
}
