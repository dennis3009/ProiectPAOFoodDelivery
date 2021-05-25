package repository;
import java.sql.*;

public class SqlHelper {
    public void ExecuteQuery(String connectionString, String command, String [] parameters/*, CommandType type, SqlParameter[] parameters*/)
    {
        try
        {
            if (command == null || command.equals(""))
                return;


            String[] connectionParams = connectionString.split("\\r?\\n");
            String JDBC_DRIVER = connectionParams[0];
            String DB_URL = connectionParams[1];
            String USER = connectionParams[2];
            String PASS = connectionParams[3];
            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement pStatement = connection.prepareStatement(command);
            System.out.println(command + " : ");
            for(int i = 0; i < parameters.length; i++)
            {
                System.out.println(parameters[i]);
                pStatement.setString(i+1, parameters[i]);
            }

            boolean x = pStatement.execute();

            connection.close();
            pStatement.close();

        }
        catch (Exception ex)
        {

            System.out.println("ExecuteNonQuery: "+ command + " " + ex.toString());
        }

    }

    public ResultSet  getResultSetFromQuery(String connectionString, String command/*, CommandType type, SqlParameter[] parameters*/)
    {

        ResultSet x = null;
        try
        {

            if (command == null || command.equals(""))
                return null;


            String[] connectionParams = connectionString.split("\\r?\\n");
            String JDBC_DRIVER = connectionParams[0];
            String DB_URL = connectionParams[1];
            String USER = connectionParams[2];
            String PASS = connectionParams[3];
            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);


            PreparedStatement pStatement = connection.prepareStatement(command);

            x = pStatement.executeQuery();


            return x;
        }
        catch (Exception ex)
        {
            System.out.println("getResultSetFromQuery: "+ command + " " + ex.toString());
        }
        return null;

    }
}
