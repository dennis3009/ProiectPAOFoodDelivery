package repository;

import model.User;

import java.sql.ResultSet;

public class UserRepository {
    private SqlHelper sHelp;
    private String command;

    public void addUser(User user, String connstr)
    {
        command = "insert into users values(null, ?, ?)";
        String[] argList = new String[2];
        argList[0] = user.getName();
        argList[1] = user.getEmail();
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void deleteUser(User user, String connstr)
    {
        command = "delete from users where id = ?";
        String[] argList = new String[1];
        argList[0] = String.valueOf(user.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public void updateUser(User user, String connstr)
    {
        command = "update users set" +
                "name = ?, " +
                "email = ? " +
                "where id = ?";
        String[] argList = new String[3];
        argList[0] = user.getName();
        argList[1] = user.getEmail();
        argList[2] = String.valueOf(user.getId());
        sHelp.ExecuteQuery(connstr, command, argList);
    }

    public User readUser(User user, String connstr)
    {
        command = "select * from users where id = "+ user.getId() + ";";
        ResultSet rs = sHelp.getResultSetFromQuery(connstr, command);
        try{
            while(rs.next())
            {
                User us1 = new User(rs.getInt(1), rs.getString(2), rs.getString(3), null);
                return us1;
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
}
