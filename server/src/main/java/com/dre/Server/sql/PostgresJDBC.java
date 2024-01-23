package com.dre.Server.sql;

import java.sql.*;


public class PostgresJDBC {
    // JDBC URL, username, and password of PostgreSQL server
    public static void startConnection() {
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "postgres";
        String password = "dre123";
        try {
            // Register the PostgreSQL JDBC driver - deprecated but still good to know/do
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            Connection connection = DriverManager.getConnection(url, user, password);
            // Establish a connection

            PreparedStatement insertps = connection.prepareStatement("insert into test (name, age) values(?, ?)");
            insertps.setString(1, "diddy");
            insertps.setInt(2, 4);
            int inserCount = insertps.executeUpdate();
            int inserCountTwo = insertps.executeUpdate();
            int inserCountThree = insertps.executeUpdate();
            System.out.println("insertCount = " + inserCount);

            PreparedStatement ps = connection.prepareStatement("select * from test");
//            ps.setString(1, "Hayward");
//            ps.setInt(1, 1);

            // Execute a SELECT query
            ResultSet rs = ps.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Retrieve data from the result set
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");

                // Do something with the data
                System.out.println("Id: " + id + ", Age: " + age + ", Name: " + name);
            }

            // Close resources
            rs.close();
            ps.close();
            connection.close();
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
