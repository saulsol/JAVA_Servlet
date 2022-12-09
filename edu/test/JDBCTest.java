package com.edu.test;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCTest {

	public static void main(String[] args) {
		
		
		Connection con = null;

        // 1. JDBC Driver Class
        String driver = "oracle.jdbc.driver.OracleDriver";

        // 2. 데이터베이스에 연결하기 위한 정보
        String url = "jdbc:oracle:thin:@localhost:1521:xe";     // 연결문자열, localhost - 127.0.0.1
        String user = "SYSTEM";                                   // 데이터베이스 ID
        String pw = "dlathf1002";                                 // 데이터베이스 PW


        try {
            //1. JDBC 드라이버 로딩
            Class.forName(driver);

            // 2. Connection 생성
            con = DriverManager.getConnection(url, user, pw);        //데이터베이스 연결
            
            // DriverManager.getConnection()은 실제 자바 프로그램과 데이터베이스를 네트워크 상에서 연결을 해주는 메소드
            // 연결에 성공하면 DB와 연결된 상태를 Connection 객체로 표현하여 반환한다. 
            // 즉 Connection은 네트워크상의 연결 자체를 의미한다. (자바 프로그램과 DB가 연결된 길)

            System.out.println("[Database 연결 성공]");
            
            Statement stmt = con.createStatement();
            System.out.println("Statement 객체 생성 성공");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM tStaff WHERE salary<400 AND score >= 60");
            
            while(rs.next()) {
            	
            	System.out.println(rs.getString(1)+" : " + rs.getString(2)+" : " +rs.getString(3)+" : " +rs.getDate(4)+" : " +rs.getString(5) +" : "+rs.getInt(6)+" : " +rs.getInt(7) );
            	
            }
            

        } catch (SQLException e) {

            System.out.println("[SQL Error : " + e.getMessage() +"]");

        } catch (ClassNotFoundException e1) {

            System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
        } finally {
            //Connection 사용 후 Close
            if(con != null) {
                try {
                    con.close();
                } catch (Exception e) {

                }
            }





        }

	}
}