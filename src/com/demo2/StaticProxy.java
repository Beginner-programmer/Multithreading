package com.demo2;

/**
 * @Author Wangbaba
 * @Date 2022/4/20 23:21
 * @Version 1.0
 */
//多线程静态代理模式
//真实对象和代理对象，都要实现同一个接口
//代理对象要代理真实对象

//好处：
//代理对象可以做好多真实对象做不了的事情
//真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();//你要结婚

        new Thread(() -> System.out.println("我爱你")).start();

        new weddingCompany(you).HappyMarry();
    }
}

interface Marry {
    //人间四大喜事
    //久旱逢甘霖
    //他乡遇故知
    //洞房花烛夜
    //金榜题名时
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("张诗禹要结婚了！");
    }
}

//代理角色，帮助你结婚
class weddingCompany implements Marry {

    //代理谁-->真实目标对象
    private Marry target;

    public weddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这是真实对象
        after();
    }

    public void before() {
        System.out.println("结婚前布置现场");
    }

    public void after() {
        System.out.println("结婚之后收尾款");
    }
}