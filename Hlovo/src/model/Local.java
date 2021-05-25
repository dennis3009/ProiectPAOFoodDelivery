package model;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Local {
    private int id;
    private String address;


    private String name;
    private String type;
    private List<MenuItem> menuItems;


    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


    public Local(int id, String address, String name, String type, List<MenuItem> menuItems)
    {
        this.id = id;
        this.address = address;
        this.name = name;
        this.type = type;
        if(menuItems != null)
            this.menuItems = menuItems;
        else this.menuItems = new ArrayList<MenuItem>();
    }
    public int getMaxMenuItemId()
    {
        int i = 0;
        if(this.menuItems == null)
            return i;
        for (MenuItem itm : this.menuItems)
        {
            if(itm.getId() > i)
            {
                i = itm.getId();
            }
        }
        return i;
    }
    public void addMenuItem(MenuItem menuItem)
    {
        this.menuItems.add(menuItem);
    }
    public void removeMenuItem(int id)
    {
        for(MenuItem mI : this.menuItems)
        {
            if(mI.getId() == id)
            {
                this.menuItems.remove(mI);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
