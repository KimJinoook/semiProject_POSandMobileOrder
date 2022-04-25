/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EZEN
 */
public class CalDAO {
    public List<CalDTO> selectCal(int stno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CalDTO> list = new ArrayList<CalDTO>();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_cal where st_no = ? order by cal_date desc ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,stno);
            rs = ps.executeQuery();
            while(rs.next()){
                CalDTO dto = new CalDTO();
                dto.setCal_scash(rs.getInt(2));
                dto.setCal_ecash(rs.getInt(3));
                dto.setCal_ecard(rs.getInt(4));
                dto.setCal_sum(rs.getInt(5));
                dto.setCal_date(rs.getTimestamp(6));
                list.add(dto);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
        
    }
    
    public int insertCal(CalDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_cal values(?, ?, ?, ?, ?, sysdate)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,dto.getSt_no());
            ps.setInt(2,dto.getCal_scash());
            ps.setInt(3,dto.getCal_ecash());
            ps.setInt(4,dto.getCal_ecard());
            ps.setInt(5,dto.getCal_sum());
            cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public String getLastday(int stno) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String lastDay = "";
        
        try{
            con = DBUtil.getConnection();
            String sql = "select cal_date from s1_cal where st_no = ? order by cal_date desc";
            ps = con.prepareStatement(sql);
            ps.setInt(1, stno);
            rs = ps.executeQuery();
            if(rs.next()){
                Timestamp ts = rs.getTimestamp(1);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
                lastDay = sdf.format(ts);
		System.out.println(lastDay);      
            }
            System.out.println("lastDay = "+lastDay+", stno="+stno);
            return lastDay;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
}
