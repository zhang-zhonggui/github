package com.jdbc.day01.test2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class Test2 {
    Student stu=new Student(7,"现在是",18,"北京");
    @Test
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?","root","1012");
        String sql ="insert  into  student values (null,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,stu.getName());
        ps.setObject(2,stu.getAge());
        ps.setObject(3,stu.getAddress());

        int i = ps.executeUpdate();
        System.out.println(i);
        conn.close();
        ps.close();
    }
    @Test
    public void test2() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?","root","1012");
        String sql = "update student set sname=?,sage=?,saddress=? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,stu.getName());
        ps.setObject(2, stu.getAge());
        ps.setObject(3, stu.getAddress());
        ps.setObject(4, stu.getId());
        int i = ps.executeUpdate();
        System.out.println(i);
        conn.close();
        ps.close();
    }
    @Test
    public void test3() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("delete from  student where id=?");
        ps.setObject(1,stu.getId());
        int i = ps.executeUpdate();
        System.out.println(i);
        conn.close();
        ps.close();
    }
}
