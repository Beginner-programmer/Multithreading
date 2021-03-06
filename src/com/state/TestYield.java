package com.state;

/**
 * @Author Wangbaba
 * @Date 2022/4/21 23:43
 * @Version 1.0
 */

//测试礼让线程
//礼让不一定成功，看cpu心情
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield=new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程结束了");
    }
}