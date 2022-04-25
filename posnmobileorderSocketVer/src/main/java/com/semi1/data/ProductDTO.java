/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

/**
 *
 * @author EZEN
 */
public class ProductDTO {
    private int cate_no;
    private int pd_no;
    private String pd_name;
    private int pd_price;
    private String pd_img;

    public ProductDTO() {
    }

    public ProductDTO(int cate_no, int pd_no, String pd_name, int pd_price) {
        this.cate_no = cate_no;
        this.pd_no = pd_no;
        this.pd_name = pd_name;
        this.pd_price = pd_price;
    }

    public String getPd_img() {
        return pd_img;
    }

    public void setPd_img(String pd_img) {
        this.pd_img = pd_img;
    }
    

    public int getCate_no() {
        return cate_no;
    }

    public void setCate_no(int cate_no) {
        this.cate_no = cate_no;
    }

    public int getPd_no() {
        return pd_no;
    }

    public void setPd_no(int pd_no) {
        this.pd_no = pd_no;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public int getPd_price() {
        return pd_price;
    }

    public void setPd_price(int pd_price) {
        this.pd_price = pd_price;
    }
    
    
    
}
