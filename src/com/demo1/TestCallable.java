package com.demo1;

import java.util.concurrent.*;

/**
 * @Author Wangbaba
 * @Date 2022/4/20 23:04
 * @Version 1.0
 */
//线程创建三:实现callable接口
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        com.demo1.webDownloader webDownloader = new webDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://t7.baidu.com/it/u=27018761,936335273&fm=193&f=GIF", "bd1.png");
        TestCallable t2 = new TestCallable("https://t7.baidu.com/it/u=816042678,3339142019&fm=193&f=GIF", "bd2.png");
        TestCallable t3 = new TestCallable("https://t7.baidu.com/it/u=1650751839,693525371&fm=193&f=GIF", "bd3.png");

        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1=ser.submit(t1);
        Future<Boolean> r2=ser.submit(t2);
        Future<Boolean> r3=ser.submit(t3);

        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();
    }

}
