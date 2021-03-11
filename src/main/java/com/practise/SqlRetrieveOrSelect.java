package com.practise;

import java.sql.*;

public class SqlRetrieveOrSelect {
    public static void main(String args[]){
        try{
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myURL = "jdbc:mysql://localhost/college_students";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myURL,"root","test");
            String sql = "SELECT * FROM college_students";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                String student_name = result.getString(1);//can give index value or coloumn name aswell
                String student_rollno = result.getString(2);
                String student_address = result.getString(3);
                String student_stream = result.getString(4);

                System.out.println(student_name + ",  " + student_rollno + ",  " + student_address + ",  " + student_stream);
            }
            connection.close();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
