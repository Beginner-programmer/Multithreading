package com.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Wangbaba
 * @Date 2022/4/23 0:51
 * @Version 1.0
 */
//线程不安全的集合
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //并发解决，锁
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
