package model;

public class Tag
{
    public static String TABLE_NAME = "tag";
    public static String COLUMN_ID = "tag_id";
    public static String COLUMN_TAG_NAME = "tag_name";
    
    private String tagId;
    private String tag;

    public Tag()
    {
    }

    public Tag(String tag)
    {
	this.tag = tag;
    }

    public Tag(String tagId, String tag)
    {
	this.tagId = tagId;
	this.tag = tag;
    }

    public String getTagId()
    {
	return tagId;
    }

    public void setTagId(String tagId)
    {
	this.tagId = tagId;
    }

    public String getTag()
    {
	return tag;
    }

    public void setTag(String tag)
    {
	this.tag = tag;
    }
}
