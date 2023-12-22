package javafx.realestate.Contoller;

import javafx.realestate.Model.House;

import java.sql.*;

public class DataBaseController extends Configs{
     Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void registerHouse(House house) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO RealStatets (city, streetName, homeNumber, rooms, square, price) VALUES(?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, house.getCity());
        prSt.setString(2, house.getStreetName());
        prSt.setInt(3, house.getHomeNumber());
        prSt.setInt(4, house.getRooms());
        prSt.setInt( 5, house.getSquare());
        prSt.setInt(6, house.getCost());
        prSt.executeUpdate();
    }
    public ResultSet getHouses() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM RealStatets";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        resSet = prSt.executeQuery();
        return resSet;
    }

        public void deleteHouse(int id) throws SQLException, ClassNotFoundException {
        String select = " DELETE FROM RealStatets WHERE (id = ?);";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setInt(1, id);
        prSt.executeUpdate();
    }
        public void updateHouse(House house) throws SQLException, ClassNotFoundException {
        String select = "UPDATE RealStatets " +
                "SET city       = ?," +
                "    streetName = ?," +
                "    homeNumber = ?," +
                "    rooms      = ?," +
                "    square     = ?," +
                "    price      = ? " +
                "    price      = ? " +
                "    price      = ? " +
                "WHERE (id = ?);";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, house.getCity());
            prSt.setString(2, house.getStreetName());
            prSt.setInt(3, house.getHomeNumber());
            prSt.setInt(4, house.getRooms());
            prSt.setInt(5, house.getSquare());
            prSt.setInt(6, house.getCost());
            prSt.setInt(7, house.getId());
        prSt.executeUpdate();
    }


    }
//    public ResultSet getAllFood() throws SQLException, ClassNotFoundException {
//        ResultSet resSet = null;
//        String select = "SELECT * FROM " + ConstFood.FOOD_TABLE + ";";
//        PreparedStatement prSt = getDbConnection().prepareStatement(select);
//        resSet = prSt.executeQuery();
//        return resSet;
//    }
//
//
//    public void registerDate(AteFoodDates afd) throws SQLException, ClassNotFoundException {
//        String insert = "INSERT INTO " + ConstAteFoodDates.AFD_TABLE +"("
//                + ConstAteFoodDates.AFD_USER_ID + ","+ ConstAteFoodDates.AFD_USER_NAME + "," +ConstAteFoodDates.AFD_DATE
//                + ", " + ConstAteFoodDates.AFD_DAY_KKAL + "," + ConstAteFoodDates.AFD_DAY_PROTEINS +"," + ConstAteFoodDates.AFD_DAY_FATS +
//                "," + ConstAteFoodDates.AFD_DAY_CARBO +")"
//                + "VALUES(?,?,?,?,?,?,?)";
//        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
//        prSt.setInt(1, afd.getId_user());
//        prSt.setString(2, afd.getUser_name());
//        prSt.setDate(3, afd.getAte_date());
//        prSt.setDouble(4, afd.getDay_kkal());
//        prSt.setDouble(5, afd.getDay_proteins());
//        prSt.setDouble(6, afd.getDay_fats());
//        prSt.setDouble(7, afd.getDay_carbo());
//        prSt.executeUpdate();
//    }
//    public ResultSet CheckDateSelect(AteFoodDates afd) throws SQLException, ClassNotFoundException {
//        ResultSet resSet = null;
//        String select = "SELECT * FROM " + ConstAteFoodDates.AFD_TABLE  + " WHERE "+
//                ConstAteFoodDates.AFD_DATE+ "=? AND " + ConstAteFoodDates.AFD_USER_ID+"=? AND "
//                + ConstAteFoodDates.AFD_USER_NAME +"=?;" ;
//        PreparedStatement prSt = getDbConnection().prepareStatement(select);
//        prSt.setDate(1, afd.getAte_date());
//        prSt.setInt(2, afd.getId_user());
//        prSt.setString(3, afd.getUser_name());
//        resSet = prSt.executeQuery();
//        return resSet;
//    }
//
//    public void UpdateDate(AteFoodDates afd) throws SQLException, ClassNotFoundException {
//        String select = "UPDATE " + ConstAteFoodDates.AFD_TABLE + " SET day_kkal = ?," +
//                " day_proteins = ?, day_fats = ?, day_carbo=? WHERE (id_user = ? AND user_name = ? AND ate_date=?);";
//        PreparedStatement prSt = getDbConnection().prepareStatement(select);
//        prSt.setDouble(1, afd.getDay_kkal());
//        prSt.setDouble(2, afd.getDay_proteins());
//        prSt.setDouble(3, afd.getDay_fats());
//        prSt.setDouble(4, afd.getDay_carbo());
//        prSt.setInt(5, afd.getId_user());
//        prSt.setString(6, afd.getUser_name());
//        prSt.setDate(7, afd.getAte_date());
//        prSt.executeUpdate();
//    }
//
//    public void UpdateUserInfromInDates(User user) throws SQLException, ClassNotFoundException {
//        String select = "UPDATE " + ConstAteFoodDates.AFD_TABLE + " SET user_name = ?" +
//                "  WHERE (id_user = ?);";
//        PreparedStatement prSt = getDbConnection().prepareStatement(select);
//        prSt.setString(1, user.getLogin());
//        prSt.setInt(2, user.getId_user());
//        prSt.executeUpdate();
//    }
//    public void ChangeAccess(User user) throws SQLException, ClassNotFoundException {
//        String select = "UPDATE " + ConstUser.USER_TABLE + " SET access = ?" +
//                "  WHERE (login = ?);";
//        PreparedStatement prSt = getDbConnection().prepareStatement(select);
//        prSt.setString(1, user.getAccess());
//        prSt.setString(2, user.getLogin());
//        prSt.executeUpdate();
//    }
//

//    public void DeleteAteFood(User user) throws SQLException, ClassNotFoundException {
//        String select = " DELETE FROM " + ConstAteFoodDates.AFD_TABLE +  " WHERE (id_user = ?);";
//        PreparedStatement prSt = getDbConnection().prepareStatement(select);
//        prSt.setInt(1, user.getId_user());
//        prSt.executeUpdate();
//    }



