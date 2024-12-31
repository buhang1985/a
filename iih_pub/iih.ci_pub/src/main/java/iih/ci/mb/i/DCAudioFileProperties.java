package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCAudioFileProperties
{
    @JsonProperty(value = "FileName")
    private String FileName;
    @JsonProperty(value = "FilePath")
    private String FilePath;
    @JsonProperty(value = "FileSize")
    private Long FileSize;

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
    public void setFileSize(Long FileSize)
    {
        this.FileSize = FileSize;
    }
    public Long getFileSize()
    {
        return this.FileSize;
    }
}
