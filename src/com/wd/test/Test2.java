package com.wd.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zzg
 * @Description: 通过列表写一个LENGTH*LENGTH的金字塔
 * @DateTime: 2021/11/27 9:58
 */
public class Test2 {
    public static void main(String[] args) {
        //定义一个常量用于做乘法表
        final int LENGTH = 10;
        //将做99乘法表的数据存入list1中
        ArrayList list1 = new ArrayList();
        for(int i = 1; i < LENGTH+1; i++) {
            List list2=new ArrayList<>();
            for (int j = 1; j < i; j++) {
                list2.add(j);
            }
            list1.add(list2);
        }
        for(int i = 1; i < list1.size(); i++){
            List list2= (List) list1.get(i);
            for(int j = 0;j< list2.size();j++){
                System.out.print(list2.get(j)+"\t");
            }
            System.out.println();
        }
    }
}
