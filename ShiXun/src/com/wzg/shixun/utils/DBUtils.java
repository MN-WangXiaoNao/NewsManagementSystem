package com.wzg.shixun.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    public static String url = null;
    public static String user = null;
    public static String password = null;
    public static String driverClass = null;

    /**
     * 得到 Connection 对象
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            InputStream in = DBUtils.class.getResourceAsStream("/db.properties");
            properties.load(in);
            // 读取信息
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driverClass = properties.getProperty("driverClass");

            // 注册驱动信息
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("加载 properties 文件失败！" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("注册驱动信息失败！" + e.getMessage());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取 Connection 对象失败！" + e.getMessage());
        }

        return connection;

    }


    /**
     * 关闭数据库连接
     *
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void dbClose(Connection conn, Statement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("ResultSet 对象关闭失败！" + e.getMessage());
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Statement 对象关闭失败！" + e.getMessage());

                    } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException("Connection 对象关闭失败！" + e.getMessage());

                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     * @param stmt
     */
    public static void dbClose(Connection conn, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Statement 对象关闭失败！" + e.getMessage());

            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Connection 对象关闭失败！" + e.getMessage());

                    }
                }
            }
        }

    }


}
