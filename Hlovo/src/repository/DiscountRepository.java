package repository;
import model.Discount;
import java.sql.*;

public class DiscountRepository {

    private SqlHelper sHelp;
    private String command;

    public void addDiscount(Discount discount, String connstr)
    {
        command = "insert into discounts values (null, ?, ?, ?)";
        String[] argList = new String[3];
        argList[0] = String.valueOf(discount.getItem());
        argList[1] = String.valueOf(discount.getLocal());
        argList[2] = String.valueOf(discount.getDiscountAmount());

        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void deleteDiscount(Discount discount, String connstr)
    {
        command = "delete from discounts where id = ?";
        String[] argList = new String[1];
        argList[0] = String.valueOf(discount.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void updateDiscount(Discount discount, String connstr)
    {
        command = "update discounts set " +
                "itemId = ? , " +
                "localId = ? , " +
                "discountAmount = ? " +
                "where id = ?";
        String[] argList = new String[4];
        argList[0] = String.valueOf(discount.getItem());
        argList[1] = String.valueOf(discount.getLocal());
        argList[2] = String.valueOf(discount.getDiscountAmount());
        argList[3] = String.valueOf(discount.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public Discount readDiscount(Discount discount, String connstr)
    {
        command = "select * from discounts where id = " + discount.getId();
        ResultSet rs = sHelp.getResultSetFromQuery(connstr, command);
        try{
            while (rs.next())
            {
                Discount disc1 = new Discount(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4));
                return disc1;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
}
