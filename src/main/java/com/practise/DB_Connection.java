package com.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB_Connection {
    private static Connection connection;

    public Connection getConnection(){
            Connection connection=null;
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root", "test");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }

