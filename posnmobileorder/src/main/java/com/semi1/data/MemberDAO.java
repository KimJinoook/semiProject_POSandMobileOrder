/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi1.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author EZEN
 */
public class MemberDAO {
    public int updateMember(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rst = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "update s1_mem set mem_id = ?, mem_name = ?, mem_pw = ?, mem_birth = ?, mem_tel = ? where mem_tel = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getMem_id());
            ps.setString(2, dto.getMem_name());
            ps.setString(3, dto.getMem_pw());
            ps.setString(4,dto.getMem_birth());
            ps.setString(5,dto.getMem_tel());
            ps.setString(6,dto.getMem_tel());
            
            rst = ps.executeUpdate();
            return rst;
            
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public String memberTelTempCheck(String tel) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String rst = "";
        try{
            con = DBUtil.getConnection();
            String sql = "select mem_id from s1_mem where mem_tel = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            
            rs = ps.executeQuery();
            if(rs.next()){
                rst = rs.getString(1);
            }
            System.out.println("rst = "+rst+", 매개변수 userid = "+tel);
            return rst;
        }finally{
            DBUtil.dbClose(rs,ps, con);
        }
    }
    
    public int memberTelCheck(String tel) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rst = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "select count(*) from s1_mem where mem_tel = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tel);
            
            rs = ps.executeQuery();
            if(rs.next()){
                int cnt = rs.getInt(1);
                if(cnt>0){
                    rst = -1;
                }else{
                    rst = 1;
                }
            }
            System.out.println("rst = "+rst+", 매개변수 userid = "+tel);
            return rst;
        }finally{
            DBUtil.dbClose(rs,ps, con);
        }
    }
    
    public int memberIdCheck(String userid) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rst = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "select count(*) from s1_mem where mem_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userid);
            
            rs = ps.executeQuery();
            if(rs.next()){
                int cnt = rs.getInt(1);
                if(cnt>0){
                    rst = -1;
                }else{
                    rst = 1;
                }
            }
            System.out.println("rst = "+rst+", 매개변수 userid = "+userid);
            return rst;
        }finally{
            DBUtil.dbClose(rs,ps, con);
        }
    }
    public int insertMember(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_mem values(s1_mem_seq.nextval,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,dto.getMem_name());
            ps.setString(2,dto.getMem_id());
            ps.setString(3,dto.getMem_pw());
            ps.setString(4,dto.getMem_birth());
            ps.setString(5,dto.getMem_tel());
            ps.setInt(6,dto.getMem_coupon());
            ps.setInt(7,dto.getMem_stamp());
            
            cnt = ps.executeUpdate();
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public int tempStamp(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "insert into s1_mem(mem_no,mem_name,mem_id,mem_pw,mem_tel,mem_stamp)\n" +
                           "values(s1_mem_seq.nextval,'임시','임시','임시',?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,dto.getMem_tel());
            ps.setInt(2,dto.getMem_stamp());
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
                    
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public int updateStamp(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "update s1_mem\n" +
                            "set mem_stamp = ? \n" +
                            "where mem_no = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,dto.getMem_stamp());
            ps.setInt(2,dto.getMem_no());
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
                    
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public int updateCoupon(MemberDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        int cnt = 0;
        try{
            con = DBUtil.getConnection();
            String sql = "update s1_mem\n" +
                            "set mem_coupon = ? \n" +
                            "where mem_no = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,dto.getMem_coupon());
            ps.setInt(2,dto.getMem_no());
            cnt = ps.executeUpdate();
            System.out.println(cnt);
            return cnt;
                    
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    public MemberDTO searchById(String userid) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDTO dto = new MemberDTO();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_mem where mem_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,userid);
            rs = ps.executeQuery();
            if(rs.next()){
                dto.setMem_no(rs.getInt(1));
                dto.setMem_name(rs.getString(2));
                dto.setMem_id(rs.getString(3));
                dto.setMem_pw(rs.getString(4));
                dto.setMem_birth(rs.getString(5));
                dto.setMem_tel(rs.getString(6));
                dto.setMem_coupon(rs.getInt(7));
                dto.setMem_stamp(rs.getInt(8));
             
            }
            System.out.println("dto = "+dto);
            return dto;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public MemberDTO searchByTel(String tel) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDTO dto = new MemberDTO();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_mem where mem_tel = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,tel);
            rs = ps.executeQuery();
            if(rs.next()){
                dto.setMem_no(rs.getInt(1));
                dto.setMem_name(rs.getString(2));
                dto.setMem_id(rs.getString(3));
                dto.setMem_birth(rs.getString(5));
                dto.setMem_tel(rs.getString(6));
                dto.setMem_coupon(rs.getInt(7));
                dto.setMem_stamp(rs.getInt(8));
             
            }
            System.out.println("dto = "+dto);
            return dto;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public MemberDTO searchByTelPw(String tel, String pw) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDTO dto = new MemberDTO();
        
        try{
            con = DBUtil.getConnection();
            String sql = "select * from s1_mem where mem_tel = ? and mem_pw = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,tel);
            ps.setString(2,pw);
            rs = ps.executeQuery();
            if(rs.next()){
                dto.setMem_no(rs.getInt(1));
                dto.setMem_name(rs.getString(2));
                dto.setMem_id(rs.getString(3));
                dto.setMem_pw(rs.getString(4));
                dto.setMem_birth(rs.getString(5));
                dto.setMem_tel(rs.getString(6));
                dto.setMem_coupon(rs.getInt(7));
                dto.setMem_stamp(rs.getInt(8));
             
            }
            System.out.println("dto = "+dto);
            return dto;
            
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    public int loginCheck(String userid, String pwd) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        
        try{
            con = DBUtil.getConnection();
            String sql = "select mem_pw from s1_mem where mem_id = ?";
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
