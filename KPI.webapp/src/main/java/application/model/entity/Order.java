package application.model.entity;

import java.util.Date;

public class Order {

    private int orderID;
    private User userID;
    private BaggageType typeID;
    private Dimension dimensionID;
    private Weight weight;
    private Direction direction;
    private java.sql.Date dateOfReceiving;

    public Order(int  orderID , User userID, BaggageType typeID, Dimension dimensionID, Weight weight, Direction direction, java.sql.Date dateOfReceiving) {
        this.orderID = orderID;
        this.userID = userID;
        this.typeID = typeID;
        this.dimensionID = dimensionID;
        this.weight = weight;
        this.direction = direction;
        this.dateOfReceiving = dateOfReceiving;
    }

    public Order(User userID, BaggageType typeID, Dimension dimensionID, Weight weight, Direction direction) {
        this.userID = userID;
        this.typeID = typeID;
        this.dimensionID = dimensionID;
        this.weight = weight;
        this.direction = direction;

    }

    public Order(User userID) {
        this.userID = userID;
    }




    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID=orderID;
    }

    public BaggageType getTypeID() {
        return typeID;
    }

    public void setTypeID(BaggageType typeID) {
        this.typeID = typeID;
    }

    public Dimension getDimencionID() {
        return dimensionID;
    }

    public void setDimencionID(Dimension dimensionID) {
        this.dimensionID = dimensionID;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Date getDateOfReceiving() {
        return dateOfReceiving;
    }

    public void setDateOfReceiving(java.sql.Date dateOfReceiving) {
        this.dateOfReceiving = dateOfReceiving;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", typeID=" + typeID +
                ", dimensionID=" + dimensionID +
                ", weight=" + weight +
                ", direction=" + direction +
                ", dateOfReceiving=" + dateOfReceiving +
                '}';
    }
}
