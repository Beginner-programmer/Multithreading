package com.demo1;

/**
 * @Author Wangbaba
 * @Date 2022/4/19 23:30
 * @Version 1.0
 */
//多个线程操作同一个对象
//买火车票的例子

//多个线程操作统一资源的情况下，线程不安全，数据混乱
public class TestThread4 implements Runnable{

    //票数
    private int ticketNums=10;


    @Override
    public void run() {
      while (true){
          if (ticketNums<=0){
              break;
          }
          //模拟延时
          try {
              Thread.sleep(200);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
      }
    }

    public static void main(String[] args) {

        TestThread4 testThread4=new TestThread4();

        new Thread(testThread4,"张诗禹").start();
        new Thread(testThread4,"蒲俊辰").start();
        new Thread(testThread4,"杨望").start();
    }
}
