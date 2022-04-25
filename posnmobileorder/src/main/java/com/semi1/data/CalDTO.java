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
public class CalDTO {
    private int st_no;
    private int cal_scash;
    private int cal_ecash;
    private int cal_ecard;
    private int cal_sum;
    private Timestamp cal_date;

    public CalDTO() {
    }

    public CalDTO(int st_no, int cal_scash, int cal_ecash, int cal_ecard, int cal_sum, Timestamp cal_date) {
        this.st_no = st_no;
        this.cal_scash = cal_scash;
        this.cal_ecash = cal_ecash;
        this.cal_ecard = cal_ecard;
        this.cal_sum = cal_sum;
        this.cal_date = cal_date;
    }

    public int getSt_no() {
        return st_no;
    }

    public void setSt_no(int st_no) {
        this.st_no = st_no;
    }

    public int getCal_scash() {
        return cal_scash;
    }

    public void setCal_scash(int cal_scash) {
        this.cal_scash = cal_scash;
    }

    public int getCal_ecash() {
        return cal_ecash;
    }

    public void setCal_ecash(int cal_ecash) {
        this.cal_ecash = cal_ecash;
    }

    public int getCal_ecard() {
        return cal_ecard;
    }

    public void setCal_ecard(int cal_ecard) {
        this.cal_ecard = cal_ecard;
    }

    public int getCal_sum() {
        return cal_sum;
    }

    public void setCal_sum(int cal_sum) {
        this.cal_sum = cal_sum;
    }

    public Timestamp getCal_date() {
        return cal_date;
    }

    public void setCal_date(Timestamp cal_date) {
        this.cal_date = cal_date;
    }
    
    
}
