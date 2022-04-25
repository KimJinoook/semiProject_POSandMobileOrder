/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

/**
 *
 * @author EZEN
 */
public class StoreDTO {
    private int st_no;
    private String st_name;
    private String st_id;
    private String st_pw;
    private String st_tel;
    private int zip_seq;

    public StoreDTO() {
    }

    public StoreDTO(int st_no, String st_name, String st_id, String st_pw, String st_tel, int zip_seq) {
        this.st_no = st_no;
        this.st_name = st_name;
        this.st_id = st_id;
        this.st_pw = st_pw;
        this.st_tel = st_tel;
        this.zip_seq = zip_seq;
    }

    public int getSt_no() {
        return st_no;
    }

    public void setSt_no(int st_no) {
        this.st_no = st_no;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getSt_pw() {
        return st_pw;
    }

    public void setSt_pw(String st_pw) {
        this.st_pw = st_pw;
    }

    public String getSt_tel() {
        return st_tel;
    }

    public void setSt_tel(String st_tel) {
        this.st_tel = st_tel;
    }

    public int getZip_seq() {
        return zip_seq;
    }

    public void setZip_seq(int zip_seq) {
        this.zip_seq = zip_seq;
    }
    
}
