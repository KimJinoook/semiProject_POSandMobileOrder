/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

import com.semi1.pos.MainHome;
import java.util.HashMap;

/**
 *
 * @author EZEN
 */
public class StoreService {
    public static HashMap<Integer, String> loginList = new HashMap<Integer, String>();
    public static HashMap<Integer, MainHome> openList = new HashMap<Integer, MainHome>(); 
    public static HashMap<Integer, Integer> portList = new HashMap<Integer, Integer>();
    public static HashMap<Integer, String> ipList = new HashMap<Integer, String>();
    
    public static final int LOGIN_OK = 1;
    public static final int PWD_DISAGREE = 2;
    public static final int NONE_USERID = 3;




    public static void loginStore(int st_no, String st_name) {
        loginList.put(st_no, st_name);
    }
    public static void logoutStore(int st_no){
        loginList.remove(st_no);
    }
    public static void openStore(int st_no, MainHome mainHome) {
        openList.put(st_no, mainHome);
        MainHome mh = mainHome;
        portList.put(st_no, 7000+mh.getStno());
        ipList.put(st_no, mh.getIp().getHostAddress());
    }
    public static void closeStore(int st_no){
        openList.remove(st_no);
        portList.remove(st_no);
    }

}
