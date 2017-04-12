package com.ydx.search.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    private static String userName;
    private static String password;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static boolean validate()
    {
        String url = "jdbc:mysql://localhost:3306/address";
        String user= "dlwy";
        String password = "dlwy";
        boolean result = false;
        
        try {
             String driver ="com.mysql.jdbc.Driver";
             Class.forName(driver);
             Connection   con = DriverManager.getConnection(url,user, password);
             
            if(con==null){
                System.out.println("can't open DBConnection");
            }
            
            String sql = "select * from base_user where username=? and password=password(?)";
            
            PreparedStatement pstmt=con.prepareStatement(sql); 
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            System.out.println(sql);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("PASS");
                result=true;
                
            }
            else
            {
                System.out.println("FAIl");
                result=false;
            }
            pstmt.close();
            rs.close();
            con.close();
    
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
        
    }
}
    
