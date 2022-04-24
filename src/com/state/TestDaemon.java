package com.state;

/**
 * @Author Wangbaba
 * @Date 2022/4/22 23:55
 * @Version 1.0
 */
//测试守护线程
//上帝守护你
public class TestDaemon {

    public static void main(String[] args) {
        God god=new God();
        You you=new You();

        Thread thread=new Thread(god);
        thread.setDaemon(true);//默认为false表示是用户线程，正常的线程都是用户线程

        thread.start();//上帝守护线程启动

        new Thread(you).start();//你，用户线程启动
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝守护着你");
        }
    }
}
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着");
        }
        System.out.println("====goodbye!world!====");
    }
}
