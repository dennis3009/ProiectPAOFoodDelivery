package service;
import model.*;
import model.MenuItem;

import java.util.List;

public class OrderService {
    private List<Driver> drivers;
    private List<User> users;
    private List<Order> orders;
    private List<Local> locals;

    public OrderService(List<Driver> drivers, List<User> users, List<Order> orders, List<Local> locals) {
        this.drivers = drivers;
        this.users = users;
        this.orders = orders;
        this.locals = locals;
    }

    public void printOrder(Order order)
    {
        String userName ="";
        String driverName="";
        for(var usr : this.users)
        {
            if(usr.getId() == order.getId())
            {
                userName = usr.getName();
                break;
            }
        }
        for(var drv : this.drivers)
        {
            if(drv.getId() == order.getId())
            {
                driverName = drv.getName();
                break;
            }
        }
        String msg = userName + " ordered: ";
        MenuItem[] items = new MenuItem[42];
        items = order.getItems();
        for(int i=0; i<items.length; i++)
        {
            if(items[i] != null)
            {
                msg += " " + items[i].getName() + ",";
            }
        }
        /*
        for (var ord : order.getItems())
        {
            msg += " " + ord.getName() + ",";
        }
         */
        msg = msg.substring(0, msg.length() - 1);
        msg += " | " + "delivered by: " + driverName + " for: " + String.valueOf(order.getPrice());
        System.out.println(msg);
    }
    public void printDriver(Driver driver)
    {
        String msg = String.valueOf(driver.getId()) + " | " +  driver.getName() + " | " +driver.getEmail() + " | Orders: ";
        for (var ord : driver.getOrders())
        {
            if(ord != null)
            {
                msg += String.valueOf(ord.getId()) + " - " + ord.getStatus() + ",";
            }
        }
        msg = msg.substring(0, msg.length() - 1);
        System.out.println(msg);
    }
}
