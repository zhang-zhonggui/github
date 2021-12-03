package com.jdbc.day02.classroom;

import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 用map对象进行存储
 * @DateTime: 2021/11/27 9:58
 */
public class Data {
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
            ResultSetMetaData md = set.getMetaData();
            List<Map> list=new LinkedList();
            //通过移动光标判断有没有下一个

            while (set.next()) {
                Map map = new HashMap();
                map.put(md.getColumnName(1),set.getObject(1));
                map.put(md.getColumnName(2),set.getObject(2));
                map.put(md.getColumnName(3),set.getObject(3));
                map.put(md.getColumnName(4),set.getObject(4));
                list.add(map);
            }
            System.out.println(list);

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
