package com.wzg.shixun.domin;

public class User {

    private int id;
    private String name;
    private String loginName;
    private String password;


    public User() {

    }

    public User(int id, String name, String loginName, String password) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
