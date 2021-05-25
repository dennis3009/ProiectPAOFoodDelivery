package model;
import model.MenuItem;

public class Order {

    private int id;
    private User user;
    private Driver driver;
    private String status;
    private MenuItem[] items;
    private String destination;
    private double tip;
    private double discount;
    private double price;

    public int getId() {
        return id;
    }

    public User getUserId() {
        return user;
    }

    public int getDriverId() {
        return driver.getId();
    }

    public String getStatus() {
        return status;
    }

    public MenuItem[] getItems() {
        return items;
    }

    public String getDestination() {
        return destination;
    }

    public double getTip() {
        return tip;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }


    public Order(int id, User user, Driver driver, String status, MenuItem[] items, String destination, double discount, double tip)
    {
        this.id = id;
        this.user = user;
        this.driver = driver;
        this.status = status;
        this.items = items;
        this.destination = destination;
        this.price = 0;
        this.tip = tip;

        for(int i=0 ; i< items.length; i++)
        {
            if(items[i] != null)
            this.price += items[i].getPrice();
        }
        if(discount > 0 && discount <1)
        {
            this.price *= 1-discount;
        }
        this.price += tip;

        user.addOrder(this);
        driver.addOrder(this);
    }
}




