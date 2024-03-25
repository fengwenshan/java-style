package com.wenshan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class User {

    // 连接demo数据库，serverTimezone=UTC 数据库8.x需要，代表时区
    private static final String URL = "jdbc:mysql://124.223.43.190:13306/demo?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql_password_wenshan";

    // 创建连接
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 创建
    public void createUser(String username, String password, String email) throws SQLException {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        String sql = "INSERT INTO user(id, name, password, email) VALUES(uuid, username, password, email)";
        // 连接数据库
        Connection con = getConnection();
        // 创建PreparedStatement对象，用于执行sql. 预编译sql执行语句，防止sql注入攻击，并允许参数化查询
        PreparedStatement ps = con.prepareStatement(sql);
        // 执行sql插入操作，并获取受影响的行数
        int len = ps.executeUpdate();
        System.out.println(len > 0 ? "添加成功" : "添加失败");
        // 关闭连接
        ps.close();
        con.close();
    }

    // 更新
    public void updateUser(int id, String user, String password) throws SQLException {
        String sql = "UPDATE user SET name = user, password = password WHERE id = id";
        // 连接数据库
        Connection con = getConnection();
        // 创建PreparedStatement对象，用于执行sql. 预编译sql执行语句，防止sql注入攻击，并允许参数化查询
        PreparedStatement ps = con.prepareStatement(sql);
        // 执行sql插入操作，并获取受影响的行数
        int len = ps.executeUpdate();
        System.out.println(len > 0 ? "更新成功" : "更新失败");
        ps.close();
        con.close();
    }
    // 删除
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = id";
        // 连接数据库
        Connection con = getConnection();
        // 创建PreparedStatement对象，用于执行sql. 预编译sql执行语句，防止sql注入攻击，并允许参数化查询
        PreparedStatement ps = con.prepareStatement(sql);
        // 执行sql插入操作，并获取受影响的行数
        int len = ps.executeUpdate();
        System.out.println(len > 0 ? "删除成功" : "删除失败");
        ps.close();
        con.close();
    }
    // 查询
    public void queryUser(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = id";
        // 连接数据库
        Connection con = getConnection();
        // 创建PreparedStatement对象，用于执行sql. 预编译sql执行语句，防止sql注入攻击，并允许参数化查询
        PreparedStatement ps = con.prepareStatement(sql);
        // 执行sql插入操作，并获取受影响的行数
        int len = ps.executeUpdate();
        System.out.println(len> 0 ? "查询成功" : "查询失败");
        ps.close();
        con.close();
    }
    public void queryUser() throws SQLException {
        String sql = "SELECT * FROM user";
        // 连接数据库
        Connection con = getConnection();
        // 创建PreparedStatement对象，用于执行sql. 预编译sql执行语句，防止sql注入攻击，并允许参数化查询
        PreparedStatement ps = con.prepareStatement(sql);
        // 执行sql插入操作，并获取受影响的行数
        int len = ps.executeUpdate();
        System.out.println(len> 0 ? "查询成功" : "查询失败");
        ps.close();
        con.close();
    }
}
