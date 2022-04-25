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
public class OddtDAO {
    public int deleteOd (int stno, int odno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "delete from s1_od where st_no = ? and od_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,stno);
            ps.setInt(2,odno);
            cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public List<OddtDTO> selectDetail(int stno, int odno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<OddtDTO> list = new ArrayList<OddtDTO>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select od_number, (select pd_name from s1_pd b where a.pd_no = b.pd_no), oddt_cnt, oddt_cnt*(select pd_price from s1_pd b where a.pd_no = b.pd_no) from s1_oddt a where st_no = ? and od_number = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stno);
            ps.setInt(2, odno);
            
            rs = ps.executeQuery();
            while(rs.next()){
                OddtDTO dto = new OddtDTO();
                dto.setOd_number(rs.getInt(1));
                dto.setOddt_name(rs.getString(2));
                dto.setOddt_cnt(rs.getInt(3));
                dto.setOddt_price(rs.getInt(4));
                list.add(dto);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public int deleteOding(int odno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "delete s1_oding where od_number = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, odno);
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int lastOd() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "select od_number from s1_od order by od_number desc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                num = rs.getInt(1);
            }
            return num;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    public int insertOddt(OddtDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_oddt"
                            + " values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getSt_no());
            ps.setInt(2, dto.getOd_number());
            ps.setInt(3, dto.getPd_no());
            ps.setInt(4, dto.getOddt_cnt());
            ps.setString(5,dto.getOddt_io());
            ps.setString(6,dto.getOddt_ice());
            ps.setString(7,dto.getOddt_shot());
            cnt = ps.executeUpdate();
            System.out.println(cnt + ", dto = "+dto);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int insertOdding(int no) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_oding"
                            + " values(?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, no);
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int insertTo(int stno, int price, String cc, int no) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_to"
                            + " values(?,?,?,sysdate,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stno);
            ps.setInt(2,no);
            ps.setInt(3,price);
            ps.setString(4,cc);
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int insertOd(int stno, int price) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_od"
                            + " values(s1_od_seq.nextval,?,?,sysdate)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stno);
            ps.setInt(2,price);
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public List<OddtDTO> showByStno(int stno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<OddtDTO> list = new ArrayList<OddtDTO>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select a.od_number, (select pd_name from s1_pd b where a.pd_no = b.pd_no), a.oddt_cnt, a.oddt_ice, a.oddt_shot, a.oddt_io\n" +
                            "from s1_oddt a\n" +
                            "where a.od_number in (select od_number from s1_oding)\n" +
                            "and a.st_no = ? order by od_number";
            ps = con.prepareStatement(sql);
            ps.setInt(1,stno);
            rs = ps.executeQuery();
            
            while(rs.next()){
                OddtDTO dto = new OddtDTO();
                dto.setOd_number(rs.getInt(1));
                dto.setOddt_name(rs.getString(2));
                dto.setOddt_cnt(rs.getInt(3));
                dto.setOddt_ice(rs.getString(4));
                dto.setOddt_shot(rs.getString(5));
                dto.setOddt_io(rs.getString(6));
                list.add(dto);
            }
            System.out.println("size = "+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
}
