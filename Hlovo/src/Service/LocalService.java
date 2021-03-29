package Service;
import model.MenuItem;
import model.Local;

import java.util.List;

public class LocalService {
    public void addMenuItem(Local local, MenuItem item)
    {
        int nextId = local.getMaxMenuItemId() + 1;
        item.setId(nextId);
        local.addMenuItem(item);
    }
    public void removeMenuItem(Local local, int id)
    {
        local.removeMenuItem(id);
    }

    public void showMenuItems(Local local)
    {
        System.out.println(local.getName() + ":");
        List<MenuItem> Menu = local.getMenuItems();
        for(MenuItem it : Menu)
        {
            String msg = String.valueOf(it.getId()) + " | " + it.getName() + " | " + String.valueOf(it.getPrice()) + " coco";
            System.out.println(msg);
        }
    }
}
