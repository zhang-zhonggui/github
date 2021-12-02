package com.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zzg
 * @Description: jddc的测试连接
 * @DateTime: 2021/11/27 9:58
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1012");
        String sql = "insert into student values(null ,'李四',18,'浙江')";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = ps.executeUpdate();
        System.out.println(i);
        conn.close();
        ps.close();
    }
}
