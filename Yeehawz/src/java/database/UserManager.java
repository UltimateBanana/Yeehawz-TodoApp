package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserManager
{
    private static UserManager userManager = new UserManager();
    private TaskManager taskManager = TaskManager.getInstance();
    private DatabaseConnector connection;
    
    private UserManager()
    {
	connection = DatabaseConnector.getInstance();
    }
    
    public static UserManager getInstance()
    {
	return userManager;
    }
    
    // QUERY
    public User getUser( String username, String password )
    {
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + User.TABLE_NAME
		+ " WHERE " + User.COLUMN_USERNAME + " = ? AND " + User.COLUMN_PASSWORD + " = ?;";

	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setString(1, username);
	    ps.setString(2, password);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    rs.next();
	    
	    User user = new User(Integer.toString(rs.getInt(User.COLUMN_ID)),
				    rs.getString(User.COLUMN_FIRST_NAME),
				    rs.getString(User.COLUMN_LAST_NAME),
				    rs.getString(User.COLUMN_USERNAME),
				    rs.getString(User.COLUMN_PASSWORD),
				    rs.getString(User.COLUMN_EMAIL));
	    
	    user.setTaskList(taskManager.getAllUserTasks(user.getUserId()));
	    
	    return user;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return null;
    }
    
    // INSERT
    public int insertUser( User user )
    {
	PreparedStatement ps;
	String sql = "INSERT INTO " + User.TABLE_NAME
		+ " ( " + User.COLUMN_FIRST_NAME + ", " + User.COLUMN_LAST_NAME + ", " + User.COLUMN_USERNAME + ", " + User.COLUMN_PASSWORD + ", " + User.COLUMN_EMAIL + " ) "
		+ " VALUES ( ?, ?, ?, ?, ? );";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    ps.setString(1, user.getFirstName());
	    ps.setString(2, user.getLastName());
	    ps.setString(3, user.getUsername());
	    ps.setString(4, user.getPassword());
	    ps.setString(5, user.getEmail());
	    
	    int affectedRows = ps.executeUpdate();
	    int genId;

	    if (affectedRows == 0) 
	    {
		throw new SQLException("Creating user failed, no rows affected.");
	    }
	    
	    try (ResultSet generatedKeys = ps.getGeneratedKeys()) 
	    {
		if (generatedKeys.next()) 
		{
		    genId = generatedKeys.getInt(1);
		    
		    return genId;
		}
		else 
		{
		    throw new SQLException("Creating user failed, no ID obtained.");
		}
	    }
	    catch(SQLException e)
	    {
		    e.printStackTrace();
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return -999;
    }
    
    // UPDATE
    public boolean updateUser( User user )
    {
	PreparedStatement ps;
	String sql = "UPDATE " + User.TABLE_NAME
		+ " SET " + User.COLUMN_FIRST_NAME + " = ?, " + User.COLUMN_LAST_NAME + " = ?, " + User.COLUMN_USERNAME + " = ?, " + User.COLUMN_PASSWORD + " = ?, " + User.COLUMN_EMAIL + " = ? "
		+ " WHERE " + User.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setString(1, user.getFirstName());
	    ps.setString(2, user.getLastName());
	    ps.setString(3, user.getUsername());
	    ps.setString(4, user.getPassword());
	    ps.setString(5, user.getEmail());
	    ps.setInt(6, Integer.parseInt(user.getUserId()));
	    
	    ps.executeUpdate();
	    
	    return true;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
    
    // DELETE
    public boolean deleteUser( String userId )
    {
	PreparedStatement ps;
	String sql = "DELETE FROM " + User.TABLE_NAME
		+ " WHERE " + User.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(userId));
	    
	    if( taskManager.deleteUserTasks(userId) )
	    {
		ps.executeUpdate();
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
}
