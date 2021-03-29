package model;

public class MenuItem {

    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public double getPrice()
    {
        return this.price;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
