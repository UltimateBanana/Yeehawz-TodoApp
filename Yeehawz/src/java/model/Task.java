package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Task
{
    public static String TABLE_NAME = "task";
    public static String COLUMN_ID = "task_id";
    public static String COLUMN_USER_ID = "user_id";
    public static String COLUMN_TITLE = "title";
    public static String COLUMN_DESCRIPTION = "description";
    public static String COLUMN_SCHEDULE = "schedule";
    
    private String taskId;
    private String title;
    private String description;
    private Calendar calendar;
    private ArrayList<Tag> tagList;
    
    public Task()
    {
    }

    public Task(String title, String description, Calendar calendar)
    {
	this.title = title;
	this.description = description;
	this.calendar = calendar;
    }

    public Task(String title, String description, Calendar calendar, ArrayList<Tag> tagList)
    {
	this.title = title;
	this.description = description;
	this.calendar = calendar;
	this.tagList = tagList;
    }
    
    public Task(String taskId, String title, String description, Calendar calendar)
    {
	this.taskId = taskId;
	this.title = title;
	this.description = description;
	this.calendar = calendar;
    }

    public Task(String taskId, String title, String description, Calendar calendar, ArrayList<Tag> tagList)
    {
	this.taskId = taskId;
	this.title = title;
	this.description = description;
	this.calendar = calendar;
	this.tagList = tagList;
    }
    
    public String getTaskId()
    {
	return taskId;
    }

    public void setTaskId(String taskId)
    {
	this.taskId = taskId;
    }

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public Calendar getCalendar()
    {
	return calendar;
    }

    public void setCalendar(Calendar calendar)
    {
	this.calendar = calendar;
    }

    public ArrayList<Tag> getTagList()
    {
	return tagList;
    }

    public void setTagList(ArrayList<Tag> tag)
    {
	this.tagList = tagList;
    }
    
    public boolean hasTag(String tagId)
    {
	for( int i = 0; i < tagList.size(); i++ )
	{
	    if( tagList.get(i).getTagId() == tagId )
	    {
		return true;
	    }
	}
	
	return false;
    }
}
