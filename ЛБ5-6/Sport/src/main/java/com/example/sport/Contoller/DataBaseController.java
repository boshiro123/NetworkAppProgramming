package com.example.sport.Contoller;

import com.example.sport.Model.Sport;

import java.sql.*;

public class DataBaseController extends Configs{
     Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void save(Sport sport) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO Sport (surname, first_name, second_name, age, height, weight) VALUES(?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, sport.getSurname());
        prSt.setString(2, sport.getFirst_name());
        prSt.setString(3, sport.getSecond_name());
        prSt.setInt(4, sport.getAge());
        prSt.setInt(5, sport.getHeight());
        prSt.setInt(6, sport.getWeight());
        prSt.executeUpdate();
    }
    public ResultSet findAll() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM Sport";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        resSet = prSt.executeQuery();
        return resSet;
    }

        public void delete(int id) throws SQLException, ClassNotFoundException {
        String select = " DELETE FROM Sport WHERE (id = ?);";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setInt(1, id);
        prSt.executeUpdate();
    }
        public void update(Sport sport) throws SQLException, ClassNotFoundException {
        String select = "UPDATE Sport " +
                "SET surname       = ?," +
                "    first_name = ?," +
                "    second_name = ?," +
                "    age      = ?," +
                "    height     = ?," +
                "    weight      = ? " +
                "WHERE (id = ?);";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, sport.getSurname());
            prSt.setString(2, sport.getFirst_name());
            prSt.setString(3, sport.getSecond_name());
            prSt.setInt(4, sport.getAge());
            prSt.setInt(5, sport.getHeight());
            prSt.setInt(6, sport.getWeight());
            prSt.setInt(7, sport.getId());
        prSt.executeUpdate();
    }

    }




