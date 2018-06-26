package com.wzg.shixun.dao.jdbc;

import com.wzg.shixun.dao.UserDao;

import com.wzg.shixun.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoJDBCImpl implements UserDao {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     *
     * 通过用户名获取密码
     *
     * @param username
     * @return
     */
    @Override
    public String getPasswordToUsername(String username) {

        String password = null;
        try {
            connection = DBUtils.getConnection();

            String sql = "select password from user where username = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString(1);
            }

            return password;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("创建 PreparedStatement 对象失败" + e.getMessage());
        } finally {
            DBUtils.dbClose(connection, preparedStatement, resultSet);

        }
    }
}
