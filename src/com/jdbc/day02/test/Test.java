package com.jdbc.day02.test;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: 课外的测试
 * @DateTime: 2021/11/27 9:58
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "root";
        String password = "1012";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, name, password);
        PreparedStatement ps = conn.prepareStatement("select  * from student");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData md = rs.getMetaData();
        List<Map> list = new LinkedList();
        while (rs.next()) {
            Map map = new HashMap();
            for (int i = 0; i < md.getColumnCount(); i++) {
                map.put(md.getColumnName(i + 1), rs.getObject(i + 1));
            }
            list.add(map);
        }
        //取list集合里的那一条Map集合
        for(Map<String,Object> m:list){
            //取map集合里的String类型的key，
            for(String s:m.keySet()){
                //根据key迭代输出value
                System.out.print(m.get(s) +"\t");
            }
            System.out.println();
        }
    }

}
