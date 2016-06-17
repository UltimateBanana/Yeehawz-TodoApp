package database;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DatabaseConnector
{
    private static Connection connection;
    private static DatabaseConnector dbConn;

    private DatabaseConnector()
    {
        String dbname = "yeehawz";
        String connurl = "jdbc:mysql://localhost:3306/" + dbname;
        String username = "root";
        String password = "joshansar";

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = (Connection) DriverManager.getConnection(connurl, username, password);
            System.out.println("It works!");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("Exception: " + e.getMessage());
        } 
    }

    public static Connection getConnection()
    {
        return connection;
    }

    public static DatabaseConnector getInstance()
    {
        if(dbConn == null)
        {
            dbConn = new DatabaseConnector();
        }
        return dbConn;
    }
}
