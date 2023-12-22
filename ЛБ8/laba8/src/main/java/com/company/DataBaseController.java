package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseController {
    static Connection c;
    static Statement statement;

    public static void getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDatabase","root","Q1E3F6H99BOGDAN");
        statement = c.createStatement();

    }
    static {
        try {
            getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(String userName, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO users (Login, Password) VALUES ('"+userName+"', '"+password+"')";
        /*PreparedStatement statement = getConnection().prepareStatement(insert);
        statement.setString(1, userName);
        statement.setString(2, password);*/
        int rowsInserted = statement.executeUpdate(insert);
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }
    public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            String login = rs.getString("Login");
            String password = rs.getString("Password");
            User user = new User(login, password);
            users.add(user);
        }
        return users;
    }
}


