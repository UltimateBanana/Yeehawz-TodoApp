package model;

import java.util.ArrayList;

public class User
{
    public static String TABLE_NAME = "user";
    public static String COLUMN_ID = "user_id";
    public static String COLUMN_FIRST_NAME = "first_name";
    public static String COLUMN_LAST_NAME = "last_name";
    public static String COLUMN_USERNAME = "username";
    public static String COLUMN_PASSWORD = "password";
    public static String COLUMN_EMAIL = "email";
    
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private ArrayList<Task> taskList;
    
    public User()
    {
    }

    public User(String firstName, String lastName, String username, String password, String email)
    {
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.password = password;
	this.email = email;
    }
    
    public User(String userId, String firstName, String lastName, String username, String password, String email)
    {
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.password = password;
	this.email = email;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public String getLastName()
    {
	return lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

    public ArrayList<Task> getTaskList()
    {
	return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList)
    {
	this.taskList = taskList;
    }
}
