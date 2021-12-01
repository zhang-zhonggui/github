package com.jdbc;

import java.sql.*;

/**
 * @Author: zzg
 * @Description: 连接数据库的第一次联系
 * @DateTime: 2021/11/27 9:58
 */
public class JDBCTest {
    static  final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    static  final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static  final String NAME = "root";
    static  final String PASSWORD= "1012";

    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(JDBC_DRIVER_NAME);
            conn=DriverManager.getConnection(JDBC_URL, NAME, PASSWORD);
            stmt=conn.createStatement();
            String sql ="select * from student";
            ResultSet rs=stmt.executeQuery(sql);
            ResultSetMetaData md= rs.getMetaData();
            int i=1;
            while(rs.next()) {
                System.out.println(rs.getString(i));
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
