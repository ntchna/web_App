package application.model.entity;

public class Check {
    private int checkID;
    private Order order;
    private double price;
    private String checkStatus = "registered";


    public Check(int checkID, Order order, double price, String checkStatus){
        this.checkID = checkID;
        this.order = order;
        this.price = price;
        this.checkStatus = checkStatus;
    }

    public int getCheckID() {
        return checkID;
    }

    public void setCheckID(int id) {
        this.checkID = checkID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus() {
        return checkStatus;
    }
    public int getStatusId(){
        if(this.checkStatus.equals("canceled")) return 3;
        else if(this.checkStatus.equals("paid")) return 2;
        else return 1;
    }

    public void setStatusId(int statusId) {
        if (statusId == 1) this.checkStatus = "registered";
        else if(statusId == 2) this.checkStatus = "paid";
        else this.checkStatus ="canceled";
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkID=" + checkID +
                ", order=" + order +
                ", price=" + price +
                ", checkStatus='" + checkStatus + '\'' +
                '}';
    }
}
