package com.demo1;

/**
 * @Author Wangbaba
 * @Date 2022/4/11 21:37
 * @Version 1.0
 */
//创建线程方式一：继承Thread类，重写run（）方法，调用start开启线程

//总结：注意，线程开启不一定立即执行，由cpu调度执行

public class TestThread extends Thread {
    @Override
    public void run() {
        //run方法线体
        for (int i=0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        TestThread testThread1=new TestThread();
        //调用start()方法开启线程
        //调用run方法就是先执行run方法里面再执行main方法
        //testThread1.run();
        //调用start方法则是交替执行
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
