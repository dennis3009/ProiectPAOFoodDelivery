package model;

public class User {


    private int id;
    private String name;
    private String email;
    private Order[] orders = new Order[42];

    public User (int id, String name, String email, Order[] orders)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        if(orders != null)
            this.orders = orders;
        else this.orders = new Order[42];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Order[] getOrders() {
        return orders;
    }

    public int getMaxOrderId()
    {
        int max = 0;
        if(orders != null)
        for(int i=0; i<orders.length; i++)
        {
            if(orders[i] != null)
                if(orders[i].getId() > max)
                    max = orders[i].getId();
        }
        return max;
    }

    public void addOrder(Order order)
    {
        orders[this.getMaxOrderId() + 1] = order;
    }
}