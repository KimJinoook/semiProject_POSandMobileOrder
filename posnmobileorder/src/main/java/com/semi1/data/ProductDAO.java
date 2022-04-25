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
public class ProductDAO {
    public ProductDTO searchByName(String pdname) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDTO dto = new ProductDTO();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_pd where pd_name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,pdname);
            rs = ps.executeQuery();
            if(rs.next()){
                dto.setCate_no(rs.getInt(1));
                dto.setPd_no(rs.getInt(2));
                dto.setPd_name(rs.getString(3));
                dto.setPd_price(rs.getInt(4));          
            }
            System.out.println("dto = "+dto);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
    }
    public List<ProductDTO> selectByCateno(int cateno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_pd where cate_no = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,cateno);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO dto = new ProductDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                list.add(dto);
            }
            System.out.println("size = "+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    public List<ProductDTO> selectByCatenoInMobile(int cateno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_pd where cate_no = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,cateno);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO dto = new ProductDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                dto.setPd_img(rs.getString(5));
                list.add(dto);
            }
            System.out.println("size = "+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    public ProductDTO searchByNameInMobile(String pdname) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDTO dto = new ProductDTO();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_pd where pd_name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,pdname);
            rs = ps.executeQuery();
            while(rs.next()){
                //ProductDTO dto = new ProductDTO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                dto.setCate_no(rs.getInt(1));
                dto.setPd_no(rs.getInt(2));
                dto.setPd_name(rs.getString(3));
                dto.setPd_price(rs.getInt(4));
                dto.setPd_img(rs.getString(5));
                
            }
            System.out.println("dto = "+dto);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
