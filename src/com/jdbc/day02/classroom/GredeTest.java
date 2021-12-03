package com.jdbc.day02.classroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class GredeTest {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hehe", "root", "1012");
        //输入查询语句
        PreparedStatement ps = conn.prepareStatement("select * from class");
        ResultSet set = ps.executeQuery();
        //list在外面，在里面会被覆盖
        List<Grede> list = new LinkedList<>();
        while (set.next()) {
            //在里面创建对象，每进行一次，就会重新创建对象然后进行存储
            Grede grede = new Grede();
            grede.setId(set.getInt(1));
            grede.setGrede(set.getString(2));
            list.add(grede);
        }
        conn.close();
        //循环遍历输出
        for (Grede a:list) {
            System.out.println(a.getId()+"======="+a.getGrede());

        }
    }
}
