package com.jdbc.day01.test3;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zzg
 * @Description: 使用占位符对mysql进行增删改
 * @DateTime: 2021/11/27 9:58
 */
public class JDBCTest1 {
    Student student = new Student(69,"张三",36,"郑州");
    @Test
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("insert into student values(null,?,?,?)");
        ps.setObject(1,student.getName());
        ps.setObject(2,student.getAge());
        ps.setObject(3,student.getAddress());
        int i = ps.executeUpdate();
        System.out.println(i);
    }
}
