package model;

public class Driver extends User {
    protected double balance;

    public Driver(int id, String name, String email, Order[] orders) {
        super(id, name, email, orders);
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }
}
