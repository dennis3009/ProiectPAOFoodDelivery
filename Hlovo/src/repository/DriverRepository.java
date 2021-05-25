package repository;
import model.Driver;
import java.sql.*;

public class DriverRepository {
    private SqlHelper sHelp;
    private String command;

    public void addDriver(Driver driver, String connstr)
    {
        command = "insert into drivers values(null, ?, ?, ?)";
        String[] argList = new String[3];
        argList[0] = driver.getName();
        argList[1] = driver.getEmail();
        argList[2] = String.valueOf(driver.getBalance());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void deleteDriver(Driver driver, String connstr)
    {
        command = "delete from drivers where id = ?";
        String[] argList = new String[1];
        argList[0] = String.valueOf(driver.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void updateDriver(Driver driver, String connstr)
    {
        command = "update drivers set " +
                "name = ?, " +
                "email = ?, " +
                "balance = ? " +
                "where id = ?;";
        String[] argList = new String[4];
        argList[0] = driver.getName();
        argList[1] = driver.getEmail();
        argList[2] = String.valueOf(driver.getBalance());
        argList[3] = String.valueOf(driver.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public Driver readDriver(Driver driver, String connstr)
    {
        command = "select * from driver where id = " + driver.getId() + ";";
        ResultSet rs = sHelp.getResultSetFromQuery(connstr, command);
        try {
            while (rs.next())
            {
                Driver dr1 = new Driver(rs.getInt(1), rs.getString(2), rs.getString(3), null);
                return dr1;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
}
