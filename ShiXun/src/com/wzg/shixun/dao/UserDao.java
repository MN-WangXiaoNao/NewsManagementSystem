package com.wzg.shixun.dao;

public interface UserDao {


    /**
     *
     * 通过用户名获取密码
     *
     * @param username
     * @return
     */
    public String getPasswordToUsername(String username);

}
