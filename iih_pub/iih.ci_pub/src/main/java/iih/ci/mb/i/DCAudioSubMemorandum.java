package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCAudioSubMemorandum
{
    @JsonProperty(value = "GUID")
    private String GUID;
    @JsonProperty(value = "MainID")
    private String MainID;
    @JsonProperty(value = "FileType")
    private String FileType;
    @JsonProperty(value = "FileName")
    private String FileName;
    @JsonProperty(value = "FilePath")
    private String FilePath;
    @JsonProperty(value = "FileBytes")
    private String FileBytes;
    @JsonProperty(value = "CreateTime")
    private String CreateTime;
    @JsonProperty(value = "FileUrl")
    private String FileUrl;

    public void setGUID(String GUID)
    {
        this.GUID = GUID;
    }
    public String getGUID()
    {
        return this.GUID;
    }
    public void setMainID(String MainID)
    {
        this.MainID = MainID;
    }
    public String getMainID()
    {
        return this.MainID;
    }
    public void setFileType(String FileType)
    {
        this.FileType = FileType;
    }
    public String getFileType()
    {
        return this.FileType;
    }
    public void setFileName(String FileName)
    {
        this.FileName = FileName;
    }
    public String getFileName()
    {
        return this.FileName;
    }
    public void setFilePath(String FilePath)
    {
        this.FilePath = FilePath;
    }
    public String getFilePath()
    {
        return this.FilePath;
    }
    public void setFileBytes(String FileBytes)
    {
        this.FileBytes = FileBytes;
    }
    public String getFileBytes()
    {
        return this.FileBytes;
    }
    public void setCreateTime(String CreateTime)
    {
        this.CreateTime = CreateTime;
    }
    public String getCreateTime()
    {
        return this.CreateTime;
    }
    public void setFileUrl(String FileUrl)
    {
        this.FileUrl = FileUrl;
    }
    public String getFileUrl()
    {
        return this.FileUrl;
    }
}
