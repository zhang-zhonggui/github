package com.jdbc.day01.text1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zzg
 * @Description: jdbc的一次联系对MySQL的曾删改
 * @DateTime: 2021/11/27 9:58
 */
public class JDBCTest1 {
    @Test
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("insert into student values(null,'张三',45,'北京')");
        int i = ps.executeUpdate();
        System.out.println(1);
    }
    @Test
    public void test2() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("delete from student where id = 6");
        int i = ps.executeUpdate();
        System.out.println(i);
    }
    @Test
    public void test3() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("update student set sname='张三' where id=1 ");
        int i = ps.executeUpdate();
        System.out.println(i);
    }
}
