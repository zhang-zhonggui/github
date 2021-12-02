package com.wd.test;

import java.util.Arrays;

/**
 * @Author: zzg
 * @Description: 冒泡排序的使用及自我优化
 * @DateTime: 2021/11/27 9:58
 */
public class Test1 {
    public static void main(String[] args) {
        int [] are={5,8,2,1,5,3,45,5,2,4,556,57,2,48,99};
        for (int i=0; i<are.length -1 ; i++) {
            for(int j=0; j<are.length-i-1; j++) {
                if(are[j]>are[j+1]){
                    int temp=are[j];
                    are[j]=are[j+1];
                    are[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(are));
    }
}
