package com.syn;

/**
 * @Author Wangbaba
 * @Date 2022/4/23 0:16
 * @Version 1.0
 */
//不安全的买票
//线程不安全
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket=new BuyTicket();

        new Thread(buyTicket,"你").start();
        new Thread(buyTicket,"我").start();
        new Thread(buyTicket,"黄牛党").start();
    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNum=10;
    boolean flag=true;
    @Override
    public void run() {
//买票
        while (flag){
            buy();
        }
    }
    //线程同步，锁
    private synchronized void buy() {
        //判断是否有票
        if (ticketNum<=0){
            flag=false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"买到了"+ticketNum--);
    }
}