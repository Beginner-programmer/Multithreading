package com.syn;

/**
 * @Author Wangbaba
 * @Date 2022/4/23 0:28
 * @Version 1.0
 */
//不安全的取钱
//两个人去取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "私房钱");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girl = new Drawing(account, 100, "女朋友");

        you.start();
        girl.start();
    }
}

//账户
class Account {
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行,模拟取款
class Drawing extends Thread {
    Account account;//账户
    int drawingMoney;//去了多少钱
    int nowMoney;//现在还有多少钱

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {
        //当不止一个对象时，锁的对象是变化的量，需要增删改的对象
        //线程同步
        synchronized (account) {
            //判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够了，无法取出");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-取的钱
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为" + account.money);
            //Thread.currentThread().getName()=this.getName()
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
    }
}

