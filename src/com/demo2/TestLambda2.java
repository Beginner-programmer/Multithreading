package com.demo2;

/**
 * @Author Wangbaba
 * @Date 2022/4/21 0:20
 * @Version 1.0
 */

//总结：
    //lambda表达式只能有一行的情况下才能简化成一行，如果多行，那么就用代码块包裹
    //前提是接口为函数式接口
    //多个参数也可以去掉参数类型，要去掉就都去掉
public class TestLambda2 {

    static class Love2 implements Ilove {

        @Override
        public void love(int a) {
            System.out.println("I Love You-->" + a);
        }
    }

    public static void main(String[] args) {
        Ilove ilove = new Love();
        ilove.love(2);
        ilove = new Love2();
        ilove.love(3);
        //1.lambda表示简化
        ilove = ((int a) -> {
            System.out.println("I Love You-->" + a);
        }
        );
        ilove.love(4);
        //简化1.参数类型
        ilove=((a)->{
            System.out.println("I Love You-->" + a);
        });
        ilove.love(5);
        //简化2.简化括号
        ilove=a -> {
            System.out.println("I Love You-->" + a);
        };
        ilove.love(6);
        //简化3.去掉花括号
        ilove=a -> System.out.println("I Love You-->" + a);
        ilove.love(7);
    }
}

interface Ilove {
    void love(int a);
}

class Love implements Ilove {

    @Override
    public void love(int a) {
        System.out.println("I Love You-->" + a);
    }
}
