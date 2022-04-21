package com.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author Wangbaba
 * @Date 2022/4/12 23:12
 * @Version 1.0
 */
public class TestThread2 extends Thread{
    private String url;
    private String name;
    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        webDownloader webDownloader=new webDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://t7.baidu.com/it/u=27018761,936335273&fm=193&f=GIF","bd1.png");
        TestThread2 t2=new TestThread2("https://t7.baidu.com/it/u=816042678,3339142019&fm=193&f=GIF","bd2.png");
        TestThread2 t3=new TestThread2("https://t7.baidu.com/it/u=1650751839,693525371&fm=193&f=GIF","bd3.png");
        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class webDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }
}
