package com.wenshan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc {

    // 连接demo数据库，serverTimezone=UTC 数据库8.x需要，代表时区
    private static final String URL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    // 创建连接
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 创建：String sql = "INSERT INTO sys_user VALUES('admin', 'Aa123456')"
    // 删除：String sql = "DELETE FROM sys_user WHERE username = 'admin'"
    // 查：String sql = "SELECT FROM sys_user *"
    // 改: String sql = "UPDATE sys_user SET username = 'admin' WHERE username = 'admin'"
    public void create(String sql) throws SQLException {
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
}
