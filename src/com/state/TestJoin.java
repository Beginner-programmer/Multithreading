package com.state;

/**
 * @Author Wangbaba
 * @Date 2022/4/21 23:51
 * @Version 1.0
 */
//测试join方法
    //想象为插队
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程SVip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 200; i++) {
            if (i==150){
                thread.join();//插队
            }
            System.out.println("main"+i);
        }

    }
}
