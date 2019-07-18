package com.guozz.test.testextends;

/**
 * @author guozhizhong
 * @Title: Client
 * @ProjectName practise-java8
 * @Description: TODO
 * @date 2019/1/94:28 PM
 **/
public class Client {

    public static void main(String[] args) {
        A a = new B();
        ((B) a).setSex("a");
        a.setAge("11");
        a.setName("张三");
        System.out.println(a.getAge()+a.getName()+((B) a).getSex());
    }
}
