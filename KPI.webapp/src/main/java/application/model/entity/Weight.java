package application.model.entity;

public class Weight {
    private String name;
    private double price;

    public Weight(double price) {
        this.price = price;
    }

    public Weight(String name) {
        this.name = name;
    }

    public Weight( String name, double price) {

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
        return "Weight{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
