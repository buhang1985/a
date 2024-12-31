package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class DCPacsSeries
{
    @JsonProperty(value = "SeriesID")
    private String SeriesID;
    @JsonProperty(value = "ThumbnailName")
    private String ThumbnailName;
    @JsonProperty(value = "FileNames")
    private ArrayOfString FileNames;
    @JsonProperty(value = "ZipFileName")
    private String ZipFileName;
    @JsonProperty(value = "UrlLink")
    private String UrlLink;
    @JsonProperty(value = "InstanceNumber")
    private String InstanceNumber;

    public void setSeriesID(String SeriesID)
    {
        this.SeriesID = SeriesID;
    }
    public String getSeriesID()
    {
        return this.SeriesID;
    }
    public void setThumbnailName(String ThumbnailName)
    {
        this.ThumbnailName = ThumbnailName;
    }
    public String getThumbnailName()
    {
        return this.ThumbnailName;
    }
    public void setFileNames(ArrayOfString FileNames)
    {
        this.FileNames = FileNames;
    }
    public ArrayOfString getFileNames()
    {
        return this.FileNames;
    }
    public void setZipFileName(String ZipFileName)
    {
        this.ZipFileName = ZipFileName;
    }
    public String getZipFileName()
    {
        return this.ZipFileName;
    }
    public void setUrlLink(String UrlLink)
    {
        this.UrlLink = UrlLink;
    }
    public String getUrlLink()
    {
        return this.UrlLink;
    }
    public void setInstanceNumber(String InstanceNumber)
    {
        this.InstanceNumber = InstanceNumber;
    }
    public String getInstanceNumber()
    {
        return this.InstanceNumber;
    }
}
