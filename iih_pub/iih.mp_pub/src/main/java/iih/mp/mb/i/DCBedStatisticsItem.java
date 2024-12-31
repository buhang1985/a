package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCBedStatisticsItem
{
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "WardCode")
    private String WardCode;
    @JsonProperty(value = "WardName")
    private String WardName;
    @JsonProperty(value = "NormalBed")
    private String NormalBed;
    @JsonProperty(value = "EmptyNormalBed")
    private String EmptyNormalBed;
    @JsonProperty(value = "AdditionalBed")
    private String AdditionalBed;
    @JsonProperty(value = "EmptyAddditionalBed")
    private String EmptyAddditionalBed;

    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
    public void setWardCode(String WardCode)
    {
        this.WardCode = WardCode;
    }
    public String getWardCode()
    {
        return this.WardCode;
    }
    public void setWardName(String WardName)
    {
        this.WardName = WardName;
    }
    public String getWardName()
    {
        return this.WardName;
    }
    public void setNormalBed(String NormalBed)
    {
        this.NormalBed = NormalBed;
    }
    public String getNormalBed()
    {
        return this.NormalBed;
    }
    public void setEmptyNormalBed(String EmptyNormalBed)
    {
        this.EmptyNormalBed = EmptyNormalBed;
    }
    public String getEmptyNormalBed()
    {
        return this.EmptyNormalBed;
    }
    public void setAdditionalBed(String AdditionalBed)
    {
        this.AdditionalBed = AdditionalBed;
    }
    public String getAdditionalBed()
    {
        return this.AdditionalBed;
    }
    public void setEmptyAddditionalBed(String EmptyAddditionalBed)
    {
        this.EmptyAddditionalBed = EmptyAddditionalBed;
    }
    public String getEmptyAddditionalBed()
    {
        return this.EmptyAddditionalBed;
    }
}
