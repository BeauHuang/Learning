package com.hb.springframework.test.bean;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:05
 * @Version 1.0
 */
public class UserService {


    private String msg;

    private int code;


    public UserService() {
    }

    public UserService(String msg, int code) {
        this.msg = msg;
        this.code = code;

    }

    public void getUserService() {
        System.out.println("UserService方法执行了！！！");
        System.out.println("构造函数初始化后：" + this.msg + "" + this.code);
    }
}
