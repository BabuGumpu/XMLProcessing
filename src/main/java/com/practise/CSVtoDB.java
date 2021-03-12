package com.practise;

import java.io.*;
import java.sql.*;

public class CSVtoDB {

    private static Connection connection;

    public static void main(String[] args) {
            //String myDriver = "org.gjt.mm.mysql.Driver";
            String myURL = "jdbc:mysql://localhost/college_students";

            //String jdbcURL = "jdbc:mysql://localhost:3306/sales";
            //String username = "user";
            //String password = "password";

            String csvFilePath = "D:\\Sample_CSVfile.csv";

            int batchSize = 20;

           // Connection connection = null;

            try {
                Connection connection = DriverManager.getConnection(myURL,"root","test");

                //connection = DriverManager.getConnection(myURL, username, password);
                connection.setAutoCommit(false);

                String sql = "INSERT INTO college_students (student_name,student_rollno, student_address, student_stream) VALUES (?, ?, ?, ?)";
               
                PreparedStatement statement = connection.prepareStatement(sql);

                BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
                String lineText = null;

                int count = 0;

                lineReader.readLine(); // skip header line

                while ((lineText = lineReader.readLine()) != null) {
                    String[] data = lineText.split(",");
                    String student_name = data[0];
                    String student_rollno = data[1];
                    String student_address = data[2];
                    String student_stream = data[3];

                    statement.setString(0, student_name);
                    statement.setInt(1, Integer.parseInt(student_rollno));
                    statement.setString(2,student_address);
                    statement.setString(3,student_stream);

                    statement.addBatch();

                    if (count % batchSize == 0) {
                        statement.executeBatch();
                    }
                }
                lineReader.close();
                // execute the remaining queries
                statement.executeBatch();
                connection.commit();
                connection.close();
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (SQLException ex) {
                ex.printStackTrace();

                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
}
