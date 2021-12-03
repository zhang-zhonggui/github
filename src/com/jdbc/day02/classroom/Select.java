package com.jdbc.day02.classroom;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static sun.misc.MessageUtils.where;

/**
 * @Author: zzg
 * @Description: 查询数据库中的数据
 * @DateTime: 2021/11/27 9:58
 */
public class Select {
    @Test
    public void test1() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        //输入查询语句
        PreparedStatement ps = conn.prepareStatement("select * from student");
        ResultSet set = ps.executeQuery();
        //通过移动光标判断有没有下一个
        while(set.next()){
            //通过id获取set中的值
            Object id = set.getObject(1);
            //通过表名获取值
            Object name = set.getObject("sname");
            int age = set.getInt("sage");
            Object address = set.getObject(4);
            System.out.println(id+"==="+name+"==="+age+"==="+address);

        }
        //关闭资源
        set.close();
        ps.close();
        conn.close();
    }
}
