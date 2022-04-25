package com.PC;

/**
 * @Author Wangbaba
 * @Date 2022/4/25 0:00
 * @Version 1.0
 */

//测试生产者消费者问题2：信号灯法，标志位解决

public class TestPC2 {
    public static void main(String[] args) {
        TV tv=new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}

//生产者-->演员
class Player extends Thread {
    TV tv;
    public Player(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
               this.tv.play("天天向上");
            }else {
                this.tv.play("看抖音");
            }
        }
    }
}

//消费者-->群众
class Watcher extends Thread {
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-->节目
class TV {
    //演员表演的时候，观众等待  T
    //观众观看的时候，演员等待  F
    String voice;//表演的节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        //通知观众观看
        this.notify();
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了" + voice);
        //通知演员表演
        this.notify();
        this.flag = !this.flag;
    }
}