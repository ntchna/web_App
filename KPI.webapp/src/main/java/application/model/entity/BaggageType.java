package application.model.entity;

public class BaggageType {
    private int id;
    private String name;

    public BaggageType(int id) {
        this.id = id;
    }

    public BaggageType(String name) {
        this.name = name;
    }

    public BaggageType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BaggageType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
