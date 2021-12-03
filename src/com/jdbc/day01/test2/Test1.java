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
public class Test1 {
    Student student = new Student(67,"张三",44,"119");

    @Test
    //修改
    public void test() throws  Exception {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","1012");
        //书写sql语句
        String sql = "update student set sname='李四' where id=2";
        //执行sql语句
        PreparedStatement ps = conn.prepareStatement(sql);
        //影响的条数
        int i = ps.executeUpdate();
        System.out.println(i);
        //关闭连接
        conn.close();
        ps.close();
    }

    @Test
    //删除
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("delete from student where id = 3");
        int i = ps.executeUpdate();
        System.out.println(i);
        conn.close();
        ps.close();
    }
    @Test
    //增加
    public void test2() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("insert  into student values ("+student.getId()+",'"+student.getName()+"',"+student.getAge()+",'"+student.address+"')");
        int i = ps.executeUpdate();
        System.out.println(i);
        conn.close();
        ps.close();
    }

}
