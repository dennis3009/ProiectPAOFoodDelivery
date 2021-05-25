package model;

public class Customer extends User {

    public Customer(int id, String name, String email, Order[] orders) {
        super(id, name, email, orders);
    }
}
