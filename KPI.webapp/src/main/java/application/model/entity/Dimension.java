package application.model.entity;

public class Dimension {
    private int id;
    private BaggageType baggageType;
    private double name;
    private double price;

    public Dimension(BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    public Dimension(double name) {
        this.name = name;
    }

    public Dimension(int id, BaggageType baggageType, double name, double price) {
        this.id = id;
        this.baggageType = baggageType;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BaggageType getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    public double getName() {
        return name;
    }

    public void setName(double name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "id=" + id +
                ", baggageType=" + baggageType +
                ", name=" + name +
                ", price=" + price +
                '}';
    }
}
