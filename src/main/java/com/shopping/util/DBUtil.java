package com.shopping.util;




import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;

import com.shopping.exception.ShoppingException;

public class DBUtil {

    private static Connection connection;

    public static Connection getConnection() throws ShoppingException{

        try {

            if (connection == null || connection.isClosed()) {

                Properties prop = new Properties();

                InputStream is = DBUtil.class
                        .getClassLoader()
                        .getResourceAsStream("application.properties");

                if (is == null) {
                    throw new ShoppingException(
                            "application.properties file not found");
                }

                prop.load(is);

                String url = prop.getProperty("db.url");
                String username = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        url,
                        username,
                        password);

                System.out.println("Database Connected Successfully");
            }

        } catch (Exception e) {
            throw new ShoppingException("Unable to establish database connection",e);
        }

        return connection;
    }
}
