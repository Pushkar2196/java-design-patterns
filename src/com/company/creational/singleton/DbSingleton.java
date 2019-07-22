package com.company.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingleton {
    private static volatile DbSingleton instance = null;
    public static final String JDBC_DERBY_URL = "jdbc:derby:memory:codejava/webdb;create=true";
    private Connection connection = null;
    private DbSingleton(){
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DbSingleton getInstance(){
        if(instance == null){
            synchronized(DbSingleton.class){
                if(instance == null) {
                    instance = new DbSingleton();
                }

            }
        }
        return instance;
    }
    public Connection getConnection(){
        if(connection == null){
            synchronized (DbSingleton.class){
                if(connection == null){
                    try{
                        String dbURL = JDBC_DERBY_URL;
                        connection = DriverManager.getConnection(dbURL);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
