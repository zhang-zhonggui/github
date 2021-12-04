package com.jdbc.day02.test;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 上午的测试
 * @DateTime: 2021/11/27 9:58
 */
public class ClassTest {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1012");
        PreparedStatement ps = conn.prepareStatement("Select * From student");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData md = rs.getMetaData();
        List<Map> list = new LinkedList<>();
        while(rs.next()){
            Map map = new HashMap();
            for (int i = 0; i <md.getColumnCount(); i++){
                map.put(md.getColumnName(i + 1),rs.getObject(i+1));
            }
            list.add(map);
        }
        System.out.println(list);
        conn.close();
    }

}
