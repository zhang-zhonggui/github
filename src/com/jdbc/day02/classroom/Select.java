package com.jdbc.day02.classroom;

import org.junit.Test;

import java.sql.*;

/**
 * @Author: zzg
 * @Description: 查询数据库中的数据
 * @DateTime: 2021/11/27 9:58
 */
public class Select {
    @Test
    public void test1() {
        Connection conn = null;
        //异常处理
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
            //输入查询语句
            PreparedStatement ps = conn.prepareStatement("select * from student");
            ResultSet set = ps.executeQuery();
            //通过移动光标判断有没有下一个
            while (set.next()) {
                //通过id获取set中的值
                Object id = set.getObject(1);
                //通过表名获取值
                Object name = set.getObject("sname");
                int age = set.getInt("sage");
                Object address = set.getObject(4);
                System.out.println(id + "===" + name + "===" + age + "===" + address);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    //关闭资源
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}