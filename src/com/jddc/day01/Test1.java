package com.jddc.day01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class Test1 {
    Student student = new Student(44,"张三",44,"119");

    @Test
    //修改
    public void test() throws  Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","1012");
        String sql = "update student set sname='李四' where id=2";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = ps.executeUpdate();
        System.out.println(i);
    }

    @Test
    //删除
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("delete from student where id = 3");
        int i = ps.executeUpdate();
        System.out.println(i);
    }
    @Test
    //增加
    public void test2() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("insert  into student values ("+student.getId()+",'"+student.getName()+"',"+student.getAge()+",'"+student.address+"')");
        int i = ps.executeUpdate();
        System.out.println(i);


    }

}
