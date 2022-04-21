package com.state;

import com.demo1.TestThread4;

/**
 * @Author Wangbaba
 * @Date 2022/4/21 23:23
 * @Version 1.0
 */

//模拟网络延时：放大问题的发生性
public class TestSleep implements Runnable {

    //票数
    private int ticketNums = 10;


    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {

        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4, "张诗禹").start();
        new Thread(testThread4, "蒲俊辰").start();
        new Thread(testThread4, "杨望").start();
    }
}
