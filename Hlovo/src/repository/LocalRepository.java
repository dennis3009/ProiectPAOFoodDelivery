package repository;
import model.Local;
import java.sql.*;

public class LocalRepository {
    private SqlHelper sHelp = new SqlHelper();
    private String command;

    public void addLocal(Local local, String connstr)
    {
        command = "insert into locals values (locals_seq.nextval, ?, ?, ? )";
        String[] argList = new String[3];
        argList[0] = local.getAddress();
        argList[1] = local.getName();
        argList[2] = local.getType();
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void deleteLocal(Local local, String connstr)
    {
        command = "delete from locals where id = ?";
        String[] argList = new String[1];
        argList[0] = String.valueOf(local.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void updateLocal(Local local, String connstr)
    {
        command = "update locals set " +
                "address = ? , " +
                "name = ? , " +
                "type = ? " +
                "where id = ?";
        String[] argList = new String[4];
        argList[0] = local.getAddress();
        argList[1] = local.getName();
        argList[2] = local.getType();
        argList[3] = String.valueOf(local.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public Local readLocal(int id, String connstr)
    {
        command = "select * from locals where id = " + id;
        ResultSet rs = sHelp.getResultSetFromQuery(connstr, command);
        try{
            while (rs.next())
            {
                Local l = new Local(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), null);
                return l;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
}
