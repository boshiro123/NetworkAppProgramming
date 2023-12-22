package javafx.realestate.Model;

public class House {
    private int id;
    private String city;
    private String streetName;
    private int homeNumber;
    private int rooms;
    private int square;
    private int cost;

    public House(int id, String city, String streetName, int homeNumber, int rooms, int square, int price) {
        this.id = id;
        this.city = city;
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.rooms = rooms;
        this.square = square;
        this.cost = price;
    }

    public House(String city, String streetName, int homeNumber, int rooms, int square, int price) {
        this.city = city;
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.rooms = rooms;
        this.square = square;
        this.cost = price;
    }

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
