package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;
import model.User;

public class TaskManager
{
    private static TaskManager taskManager = new TaskManager();
    private TagManager tagManager = TagManager.getInstance();
    private DatabaseConnector connection;
    
    private TaskManager()
    {
	connection = DatabaseConnector.getInstance();
    }
    
    public static TaskManager getInstance()
    {
	return taskManager;
    }
    
    // QUERY
    public Task getTask( String taskId )
    {
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + Task.TABLE_NAME
		+ " WHERE " + Task.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(taskId));
	    
	    ResultSet rs = ps.executeQuery();
	    
	    rs.next();
	 
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(rs.getDate(Task.COLUMN_SCHEDULE));
	    
	    Task task = new Task(Integer.toString(rs.getInt(Task.COLUMN_ID)),
				    rs.getString(Task.COLUMN_TITLE),
				    rs.getString(Task.COLUMN_DESCRIPTION),
				    calendar);
	    
	    task.setTagList(tagManager.getAllTaskTags(task.getTaskId()));
	    
	    return task;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return null;
    }
    
    public ArrayList<Task> getAllTasks()
    {
	ArrayList<Task> taskList = new ArrayList<>(0);
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + Task.TABLE_NAME;
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next())
	    {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rs.getDate(Task.COLUMN_SCHEDULE));

		Task task = new Task(Integer.toString(rs.getInt(Task.COLUMN_ID)),
					rs.getString(Task.COLUMN_TITLE),
					rs.getString(Task.COLUMN_DESCRIPTION),
					calendar);

		task.setTagList(tagManager.getAllTaskTags(task.getTaskId()));

		taskList.add(task);
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return (ArrayList<Task>) taskList.clone();
    }
    
    public ArrayList<Task> getAllUserTasks( String userId )
    {
	ArrayList<Task> taskList = new ArrayList<>(0);
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + Task.TABLE_NAME
		+ " WHERE " + Task.COLUMN_USER_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(userId));
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next())
	    {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rs.getDate(Task.COLUMN_SCHEDULE));

		Task task = new Task(Integer.toString(rs.getInt(Task.COLUMN_ID)),
					rs.getString(Task.COLUMN_TITLE),
					rs.getString(Task.COLUMN_DESCRIPTION),
					calendar);

		task.setTagList(tagManager.getAllTaskTags(task.getTaskId()));

		taskList.add(task);
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return (ArrayList<Task>) taskList.clone();
    }
    
    public ArrayList<Task> getAllUserTagTasks( String userId, String tagId )
    {
	ArrayList<Task> userTasks = getAllUserTasks(userId);
	ArrayList<Task> userTagTasks = new ArrayList<>(0);
	
	for( int i = 0; i < userTasks.size(); i++ )
	{
	    if( userTasks.get(i).hasTag(tagId) )
	    {
		userTagTasks.add(userTasks.get(i));
	    }
	}
	
	return (ArrayList<Task>) userTagTasks.clone();
    }
    
    // INSERT
    public int insertTask( String userId, Task task )
    {
	PreparedStatement ps;
	String sql = "INSERT INTO " + Task.TABLE_NAME
		+ " ( " + Task.COLUMN_USER_ID + ", " + Task.COLUMN_TITLE + ", " + Task.COLUMN_DESCRIPTION + ", " + Task.COLUMN_SCHEDULE + " ) "
		+ " VALUES ( ?, ?, ?, ? );";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    ps.setInt(1, Integer.parseInt(userId));
	    ps.setString(2, task.getTitle());
	    ps.setString(3, task.getDescription());
	    ps.setDate(4, new java.sql.Date(task.getCalendar().getTimeInMillis()));
	    
	    int affectedRows = ps.executeUpdate();
	    int genId;

	    if (affectedRows == 0) 
	    {
		throw new SQLException("Creating task failed, no rows affected.");
	    }
	    
	    try (ResultSet generatedKeys = ps.getGeneratedKeys()) 
	    {
		if (generatedKeys.next()) 
		{
		    genId = generatedKeys.getInt(1);
		    
		    tagManager.insertTaskTags(Integer.toString(genId), task.getTagList());
		    
		    return genId;
		}
		else 
		{
		    throw new SQLException("Creating task failed, no ID obtained.");
		}
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return -999;
    }
    
    // UPDATE
    public boolean updateTask( Task task )
    {
	PreparedStatement ps;
	String sql = "UPDATE " + Task.TABLE_NAME
		+ " SET " + Task.COLUMN_TITLE + " = ?, " + Task.COLUMN_DESCRIPTION + " = ?, " + Task.COLUMN_SCHEDULE + " = ? "
		+ " WHERE " + Task.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setString(1, task.getTitle());
	    ps.setString(2, task.getDescription());
	    ps.setDate(3, new java.sql.Date(task.getCalendar().getTimeInMillis()));
	    ps.setInt(4, Integer.parseInt(task.getTaskId()));
	    
	    ps.executeUpdate();
	    
	    if( tagManager.updateTaskTags(task.getTaskId(), task.getTagList()) )
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
    
    // DELETE
    public boolean deleteTask( String taskId )
    {
	PreparedStatement ps;
	String sql = "DELETE FROM " + Task.TABLE_NAME
		+ " WHERE " + Task.COLUMN_ID + " = ?;";
	
	tagManager.deleteTaskTags(taskId);
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(taskId));
	    
	    if( tagManager.deleteTaskTags(taskId) )
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
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
    
    public boolean deleteUserTasks( String userId )
    {
	PreparedStatement ps;
	String sql = "SELECT " + Task.COLUMN_ID
		+ " FROM " + Task.TABLE_NAME
		+ " WHERE " + User.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(userId));
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next())
	    {
		deleteTask(Integer.toString(rs.getInt(Task.COLUMN_ID)));
	    }
	    
	    return true;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
}
