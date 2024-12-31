package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMDiagnoseInfo
{
    @JsonProperty(value = "DiagnoseType")
    private String DiagnoseType;
    @JsonProperty(value = "DiagnoseContent")
    private String DiagnoseContent;
    @JsonProperty(value = "DiagnoseTime")
    private String DiagnoseTime;

    public void setDiagnoseType(String DiagnoseType)
    {
        this.DiagnoseType = DiagnoseType;
    }
    public String getDiagnoseType()
    {
        return this.DiagnoseType;
    }
    public void setDiagnoseContent(String DiagnoseContent)
    {
        this.DiagnoseContent = DiagnoseContent;
    }
    public String getDiagnoseContent()
    {
        return this.DiagnoseContent;
    }
    public void setDiagnoseTime(String DiagnoseTime)
    {
        this.DiagnoseTime = DiagnoseTime;
    }
    public String getDiagnoseTime()
    {
        return this.DiagnoseTime;
    }
}
