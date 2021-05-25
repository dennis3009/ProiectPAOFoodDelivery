package model;

public class Discount {
    private int id;
    private int itemId;
    private int localId;
    private float discountAmount;

    public Discount(int id, int item, int local, float discountAmount)
    {
        this.id = id;
        this.itemId = item;
        this.localId = local;
        this.discountAmount = discountAmount;
    }

    public int getId() {
        return id;
    }

    public int getItem() {
        return itemId;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public int getLocal() {
        return localId;
    }
}
