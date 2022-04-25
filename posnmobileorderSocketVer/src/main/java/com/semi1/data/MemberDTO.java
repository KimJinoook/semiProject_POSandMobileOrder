/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

/**
 *
 * @author EZEN
 */
public class MemberDTO {
    private int mem_no;
    private String mem_name;
    private String mem_id;
    private String mem_pw;
    private String mem_birth;
    private String mem_tel;
    private int mem_coupon;
    private int mem_stamp;

    public MemberDTO() {
    }

    
    public MemberDTO(int mem_no, String mem_name, String mem_id, String mem_pw, String mem_birth, String mem_tel, int mem_coupon, int mem_stamp) {
        this.mem_no = mem_no;
        this.mem_name = mem_name;
        this.mem_id = mem_id;
        this.mem_pw = mem_pw;
        this.mem_birth = mem_birth;
        this.mem_tel = mem_tel;
        this.mem_coupon = mem_coupon;
        this.mem_stamp = mem_stamp;
    }

    public int getMem_no() {
        return mem_no;
    }

    public void setMem_no(int mem_no) {
        this.mem_no = mem_no;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_birth() {
        return mem_birth;
    }

    public void setMem_birth(String mem_birth) {
        this.mem_birth = mem_birth;
    }

    public String getMem_tel() {
        return mem_tel;
    }

    public void setMem_tel(String mem_tel) {
        this.mem_tel = mem_tel;
    }

    public int getMem_coupon() {
        return mem_coupon;
    }

    public void setMem_coupon(int mem_coupon) {
        this.mem_coupon = mem_coupon;
    }

    public int getMem_stamp() {
        return mem_stamp;
    }

    public void setMem_stamp(int mem_stamp) {
        this.mem_stamp = mem_stamp;
    }
    
    
}
