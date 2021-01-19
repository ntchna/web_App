package application.model.entity;

public class Direction {
    private String name;
    private double price;

    public Direction(double price) {
        this.price = price;
    }

    public Direction(String name) {
        this.name = name;
    }

    public Direction( String name, double price) {

        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        return "Direction{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
