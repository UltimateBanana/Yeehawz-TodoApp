package controller;

import database.TagManager;
import database.TaskManager;
import database.UserManager;
import java.util.ArrayList;
import model.Tag;
import model.Task;
import model.User;

public class Controller
{
    private TagManager tagManager;
    private TaskManager taskManager;
    private UserManager userManager;

    public Controller()
    {
	tagManager = TagManager.getInstance();
	taskManager = TaskManager.getInstance();
	userManager = UserManager.getInstance();
    }
    
    // USER CRUD
    public User loginUser( String username, String password )
    {
	User user = userManager.getUser(username, password);
	
	return user;
    }
    
    public int registerUser( User user )
    {
	return userManager.insertUser(user);
    }
    
    public boolean updateUser( User user )
    {
	return userManager.updateUser(user);
    }
    
    public boolean deleteUser( String userId )
    {
	return userManager.deleteUser(userId);
    }
    
    // TASK CRUD
    public Task getTask( String taskId )
    {
	return taskManager.getTask(taskId);
    }
    
    public ArrayList<Task> getAllTasks()
    {
	return taskManager.getAllTasks();
    }
    
    public ArrayList<Task> getAllUserTasks( String userId )
    {
	return taskManager.getAllUserTasks(userId);
    }
    
    public ArrayList<Task> getAllUserTagTasks( String userId, String tagId )
    {
	return taskManager.getAllUserTagTasks(userId, tagId);
    }
    
    public int insertTask( String userId, Task task )
    {
	return taskManager.insertTask(userId, task);
    }
    
    public boolean updateTask( Task task )
    {
	return taskManager.updateTask(task);
    }
    
    public boolean deleteTask( String taskId )
    {
	return taskManager.deleteTask(taskId);
    }
    
    public boolean deleteUserTasks( String userId )
    {
	return taskManager.deleteUserTasks(userId);
    }
    
    // TAG CRUD
    public Tag getTagByName( String tagName )
    {
	return tagManager.getTagByName(tagName);
    }
    
    public Tag getTagById( String tagId )
    {
	return tagManager.getTagById(tagId);
    }
    
    public ArrayList<Tag> getAllTags()
    {
	return tagManager.getAllTags();
    }
    
    public ArrayList<Tag> getAllTaskTags( String taskId )
    {
	return tagManager.getAllTaskTags(taskId);
    }
    
    public int insertTag( Tag tag )
    {
	return tagManager.insertTag(tag);
    }
    
    public boolean insertTaskTags( String taskId, ArrayList<Tag> tagList )
    {
	return tagManager.insertTaskTags(taskId, tagList);
    }
    
    public boolean updateTag( Tag tag )
    {
	return tagManager.updateTag(tag);
    }
    
    public boolean updateTaskTag( String taskId, ArrayList<Tag> tagList )
    {
	return tagManager.updateTaskTags(taskId, tagList);
    }
    
    public boolean deleteTag( String tagId )
    {
	return tagManager.deleteTag(tagId);
    }
    
    public boolean deleteTaskTags( String taskId )
    {
	return tagManager.deleteTaskTags(taskId);
    }
}
