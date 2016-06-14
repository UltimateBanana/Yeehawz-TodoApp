package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tag;
import model.Task;
import model.TaskTag;

public class TagManager
{
    private static TagManager tagManager = new TagManager();
    private DatabaseConnector connection;
    
    private TagManager()    
    {
	connection = DatabaseConnector.getInstance();
    }
    
    public static TagManager getInstance()
    {
	return tagManager;
    }
    
    // QUERY
    public Tag getTagByName( String tagName )
    {
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + Tag.TABLE_NAME 
		+ " WHERE " + Tag.COLUMN_TAG_NAME + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setString(1, tagName);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    rs.next();
	    
	    Tag tag = new Tag(Integer.toString(rs.getInt(Tag.COLUMN_ID)),
				rs.getString(Tag.COLUMN_TAG_NAME));
	    
	    return tag;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    
    public Tag getTagById( String tagId )
    {
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + Tag.TABLE_NAME 
		+ " WHERE " + Tag.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(tagId));
	    
	    ResultSet rs = ps.executeQuery();
	    
	    rs.next();
	    
	    Tag tag = new Tag(Integer.toString(rs.getInt(Tag.COLUMN_ID)),
				rs.getString(Tag.COLUMN_TAG_NAME));
	    
	    return tag;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
    
    public ArrayList<Tag> getAllTags()
    {
	ArrayList<Tag> tagList = new ArrayList<>(0);
	PreparedStatement ps;
	String sql = "SELECT * "
		+ " FROM " + Tag.TABLE_NAME + ";";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next())
	    {
		Tag tag = new Tag(Integer.toString(rs.getInt(Tag.COLUMN_ID)),
				rs.getString(Tag.COLUMN_TAG_NAME));
		
		tagList.add(tag);
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return (ArrayList<Tag>) tagList.clone();
    }
    
    public ArrayList<Tag> getAllTaskTags( String taskId )
    {
	ArrayList<Tag> tagList = new ArrayList<>(0);
	PreparedStatement ps;
	String sql = "SELECT T.* "
		+ " FROM " + Tag.TABLE_NAME + " T, " + TaskTag.TABLE_NAME + " TT "
		+ " WHERE T." + Tag.COLUMN_ID + " = TT." + Tag.COLUMN_ID + " AND "
		+ " TT." + Task.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(taskId));
	    
	    ResultSet rs = ps.executeQuery();
	    
	    while( rs.next() )
	    {
		Tag tag = new Tag(Integer.toString(rs.getInt(Tag.COLUMN_ID)),
				    rs.getString(Tag.COLUMN_TAG_NAME));
		
		tagList.add(tag);
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return (ArrayList<Tag>) tagList.clone();
    }
    
    // INSERT
    public int insertTag( Tag tag )
    {
	PreparedStatement ps;
	String sql = "INSERT INTO " + Tag.TABLE_NAME 
		+ " ( " + Tag.COLUMN_TAG_NAME + ") "
		+ " VALUES (?);";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setString(1, tag.getTag());
	    
	    int affectedRows = ps.executeUpdate();
	    int genId;

	    if (affectedRows == 0) 
	    {
		throw new SQLException("Creating tag failed, no rows affected.");
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
		    throw new SQLException("Creating tag failed, no ID obtained.");
		}
	    }
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return -999;
    }
    
    public boolean insertTaskTags( String taskId, ArrayList<Tag> tagList )
    {
	PreparedStatement ps;
	String sql = "INSERT INTO " + TaskTag.TABLE_NAME 
		+ "( " + Task.COLUMN_ID + ", " + Tag.COLUMN_ID + ")"
		+ " VALUES ( ?, ? );";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    
	    ps.setInt(1, Integer.parseInt(taskId));
	    
	    for( int i = 0; i < tagList.size(); i++ )
	    {
		ps.setInt(2, Integer.parseInt(tagList.get(i).getTagId()));
		ps.executeUpdate();
	    }
	    
	    return true;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
    
    // UPDATE
    public boolean updateTag( Tag tag )
    {
	PreparedStatement ps;
	String sql = "UPDATE " + Tag.TABLE_NAME
		+ " SET " + Tag.COLUMN_TAG_NAME + " = ? "
		+ " WHERE " + Tag.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setString(1, tag.getTag());
	    ps.setInt(2, Integer.parseInt(tag.getTagId()));
	    
	    ps.executeUpdate();
	    
	    return true;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
    
    public boolean updateTaskTags( String taskId, ArrayList<Tag> tagList )
    {
	if( deleteTaskTags(taskId) )
	{
	    insertTaskTags(taskId, tagList);
	    return true;
	}
	else
	{
	    return false;
	}
    }
    
    // DELETE
    public boolean deleteTag( String tagId )    
    {
	PreparedStatement ps;
	String sql = "DELETE FROM " + Tag.TABLE_NAME
		+ " WHERE " + Tag.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(tagId));
	    
	    ps.executeUpdate();
	    
	    return true;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
    
    public boolean deleteTaskTags( String taskId )
    {
	PreparedStatement ps;
	String sql = "DELETE FROM " + TaskTag.TABLE_NAME
		+ " WHERE " + Task.COLUMN_ID + " = ?;";
	
	try
	{
	    ps = connection.getConnection().prepareStatement(sql);
	    ps.setInt(1, Integer.parseInt(taskId));
	    
	    ps.executeUpdate();
	    
	    return true;
	}
	catch (SQLException ex)
	{
	    Logger.getLogger(TagManager.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return false;
    }
}
