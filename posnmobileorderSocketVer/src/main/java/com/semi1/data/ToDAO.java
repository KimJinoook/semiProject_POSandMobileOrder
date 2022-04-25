/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EZEN
 */
public class ToDAO {
    public List<ToDTO> selectCardTo(int stno) throws ParseException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ToDTO> list = new ArrayList<ToDTO>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_to where to_pay != 'Cash'  and st_no = ? order by od_number desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stno);

            rs = ps.executeQuery();
            while(rs.next()){
                ToDTO dto = new ToDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.toString());
            return list;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public List<ToDTO> selectCardTo(int stno, String date) throws ParseException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ToDTO> list = new ArrayList<ToDTO>();
        String sdate1 = date;
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date1 = sdf.parse(sdate1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE,1);
        Date date2 = cal.getTime();
        String sdate2 = sdf.format(date2);
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_to where to_pay != 'Cash' and to_date between ? and ?  and st_no = ?  order by od_number desc";
            ps = con.prepareStatement(sql);
            ps.setString(1,sdate1);
            ps.setString(2, sdate2);
            ps.setInt(3,stno);
            rs = ps.executeQuery();
            while(rs.next()){
                ToDTO dto = new ToDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.toString());
            return list;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public List<ToDTO> selectCashTo(int stno) throws ParseException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ToDTO> list = new ArrayList<ToDTO>();
       
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_to where to_pay = 'Cash'  and st_no = ?  order by od_number desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1,stno);

            rs = ps.executeQuery();
            while(rs.next()){
                ToDTO dto = new ToDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.toString());
            return list;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public List<ToDTO> selectCashTo(int stno, String date) throws ParseException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ToDTO> list = new ArrayList<ToDTO>();
        String sdate1 = date;
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date1 = sdf.parse(sdate1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE,1);
        Date date2 = cal.getTime();
        String sdate2 = sdf.format(date2);
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_to where to_pay = 'Cash' and to_date between ? and ?  and st_no = ? order by od_number desc";
            ps = con.prepareStatement(sql);
            ps.setString(1,sdate1);
            ps.setString(2, sdate2);
            ps.setInt(3, stno);
            rs = ps.executeQuery();
            while(rs.next()){
                ToDTO dto = new ToDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.toString());
            return list;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public List<ToDTO> selectAllTo(int stno) throws ParseException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ToDTO> list = new ArrayList<ToDTO>();
        
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_to where st_no = ?  order by od_number desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1,stno);

            rs = ps.executeQuery();
            while(rs.next()){
                ToDTO dto = new ToDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.toString());
            return list;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public List<ToDTO> selectAllTo(int stno, String date) throws ParseException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ToDTO> list = new ArrayList<ToDTO>();
        String sdate1 = date;
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date1 = sdf.parse(sdate1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE,1);
        Date date2 = cal.getTime();
        String sdate2 = sdf.format(date2);
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_to where to_date between ? and ? and st_no = ? order by od_number desc";
            ps = con.prepareStatement(sql);
            ps.setString(1,sdate1);
            ps.setString(2, sdate2);
            ps.setInt(3,stno);
            rs = ps.executeQuery();
            while(rs.next()){
                ToDTO dto = new ToDTO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.toString());
            return list;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
