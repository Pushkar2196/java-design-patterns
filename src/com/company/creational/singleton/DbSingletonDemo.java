package com.company.creational.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
    public static void main(String[] args){
        DbSingleton instance = DbSingleton.getInstance();
        Connection connection = instance.getConnection();
        Statement statement;

        try {
            statement = connection.createStatement();
            int count = statement.executeUpdate("CREATE TABLE Address (ID INT, ADDRESS1 VARCHAR(20), CITY VARCHAR(20))");
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
