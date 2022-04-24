package com.lock;

/**
 * @Author Wangbaba
 * @Date 2022/4/24 0:11
 * @Version 1.0
 */
//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "张诗禹");
        Makeup g2 = new Makeup(1, "蒲俊辰");

        g1.start();
        g2.start();
    }
}

//口红
class LipsLick {
}

//镜子
class Mirror {
}

//化妆
class Makeup extends Thread {
    //需要的资源只有一份，用static来保证只有一份
    static LipsLick lipsLick = new LipsLick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String name;//使用化妆的人

    public Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆,互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipsLick) {
                //获得口红的锁
                System.out.println(this.name + "获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                //获得镜子的锁，1s后
                System.out.println(this.name + "获得镜子的锁");
            }
        } else {
            synchronized (mirror) {
                //获得镜子的锁
                System.out.println(this.name + "获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipsLick) {
                //获得口红的锁,2s后
                System.out.println(this.name + "获得口红的锁");
            }
        }
    }

}