package com.state;

/**
 * @Author Wangbaba
 * @Date 2022/4/22 0:04
 * @Version 1.0
 */
//观察线程状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //观察状态   NEW
        Thread.State state=thread.getState();
        System.out.println(state);

        //观察启动后  RUN
        thread.start();
        state=thread.getState();
        System.out.println(state);

        //进入死亡状态就不能再启动了
        while (state!=Thread.State.TERMINATED){
            //只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state=thread.getState();//更新状态
            System.out.println(state);//输出
        }
    }
}
