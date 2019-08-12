package com.github.DominasPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/restdb?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "coderslab";

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
