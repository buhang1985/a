package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCOrderOccDetailInfo
{
    @JsonProperty(value = "comboNo")
    private String comboNo;
    @JsonProperty(value = "occTime")
    private String occTime;
    @JsonProperty(value = "occContent")
    private String occContent;
    @JsonProperty(value = "operaCode")
    private String operaCode;
    @JsonProperty(value = "operaName")
    private String operaName;

    public void setComboNo(String comboNo)
    {
        this.comboNo = comboNo;
    }
    public String getComboNo()
    {
        return this.comboNo;
    }
    public void setOccTime(String occTime)
    {
        this.occTime = occTime;
    }
    public String getOccTime()
    {
        return this.occTime;
    }
    public void setOccContent(String occContent)
    {
        this.occContent = occContent;
    }
    public String getOccContent()
    {
        return this.occContent;
    }
    public void setOperaCode(String operaCode)
    {
        this.operaCode = operaCode;
    }
    public String getOperaCode()
    {
        return this.operaCode;
    }
    public void setOperaName(String operaName)
    {
        this.operaName = operaName;
    }
    public String getOperaName()
    {
        return this.operaName;
    }
}
