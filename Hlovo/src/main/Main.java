package main;

import model.*;
import Service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args)
    {
        //testLocalService();
        testOrderService();
    }
    public static void testOrderService()
    {


        MenuItem it1 = new MenuItem(1, "burger", 14.99);
        MenuItem it2 = new MenuItem(2, "pizza", 24.99);
        MenuItem it3 = new MenuItem(3, "fries", 9.99);

        MenuItem[] items = new MenuItem[42];
        items[0] = it1;
        items[1] = it2;
        items[2] = it3;


        Driver dr1 = new Driver(1, "Gion", null, null);
        User us1 = new User(1, "Big Smoke", "fi@fai.fo", null);

        Order or1 = new Order(1, us1, dr1, "Pending", items, "dest", 0.1, 5);
        Local l = new Local(1, "add", "Bargar Kong", "fast-food", null);

        List<Driver> drivers = new ArrayList<Driver>();
        List<User> users = new ArrayList<User>();
        List<Order> orders = new ArrayList<Order>();
        List<Local> locals = new ArrayList<Local>();

        drivers.add(dr1);
        users.add(us1);
        orders.add(or1);
        locals.add(l);

        OrderService os = new OrderService(drivers, users, orders, locals);
        os.printOrder(or1);
    }

    public static void testLocalService()
    {
        LocalService ls = new LocalService();
        Local l = new Local(1, "add", "Bargar Kong", "fast-food", null);

        MenuItem it1 = new MenuItem(1, "Burger", 14.99);
        MenuItem it2 = new MenuItem(2, "Pizza", 24.99);
        MenuItem it3 = new MenuItem(5, "Fries", 4.99);

        ls.addMenuItem(l, it1);
        ls.addMenuItem(l, it2);
        ls.addMenuItem(l, it3);

        ls.showMenuItems(l);

        ls.removeMenuItem(l, 2);

        ls.showMenuItems(l);
    }
}
