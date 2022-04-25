/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EZEN
 */
public class StoreDAO {
    public List<String> getStoreDong(String si, String gu) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select st_name from s1_store where zip_seq in (select zip_seq from s1_zipcode where zip_si = ? and zip_gugun = ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,si);
            ps.setString(2,gu);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String store = rs.getString(1);
                list.add(store);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    public List<String> getStoreGu(String si) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select distinct zip_Gugun from s1_zipcode where zip_si = ? and zip_seq in (select zip_seq from s1_store)";
            ps = con.prepareStatement(sql);
            ps.setString(1,si);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String store = rs.getString(1);
                list.add(store);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    public List<String> getStoreSi () throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select distinct zip_si from s1_zipcode where zip_seq in (select zip_seq from s1_store)";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String store = rs.getString(1);
                list.add(store);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    
    public String getStname (String userid) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String stname="";
        
        try{
            con = DBUtil.getConnection();
            String sql = "select st_name from s1_store where st_id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,userid);
            
            rs = ps.executeQuery();
            if(rs.next()){
                stname = rs.getString(1);
            }
            System.out.println("id = "+userid+"stname = "+stname);
            return stname;
        }finally{
            DBUtil.dbClose(rs,ps, con);
        }
    }
    public int getStno (String userid) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int stno = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "select st_no from s1_store where st_id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,userid);
            
            rs = ps.executeQuery();
            if(rs.next()){
                stno = rs.getInt(1);
            }
            System.out.println("id = "+userid+"stno = "+stno);
            return stno;
        }finally{
            DBUtil.dbClose(rs,ps, con);
        }
    }
    public int getStnoByName (String name) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int stno = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "select st_no from s1_store where st_name=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            
            rs = ps.executeQuery();
            if(rs.next()){
                stno = rs.getInt(1);
            }
            System.out.println("id = "+name+"stno = "+stno);
            return stno;
        }finally{
            DBUtil.dbClose(rs,ps, con);
        }
    }
    public int loginCheck(String userid, String pwd) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "select st_pw from s1_store where st_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,userid);
            
            rs = ps.executeQuery();
            if(rs.next()){
                String dbPwd = rs.getString(1);
                if(dbPwd.equals(pwd)){
                    result=StoreService.LOGIN_OK;
                }else{
                    result=StoreService.PWD_DISAGREE;
                }
            }else{
                result=StoreService.NONE_USERID;
            }
            System.out.println("로그인 처리 결과 result = "+result+", 매개변수 userid = "+userid+", pwd = "+pwd);
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
}
