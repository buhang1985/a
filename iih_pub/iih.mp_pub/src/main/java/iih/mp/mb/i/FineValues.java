package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class FineValues
{
    @JsonProperty(value = "vaules")
    private String vaules;
    @JsonProperty(value = "DepName")
    private String DepName;
    @JsonProperty(value = "OperationLevel")
    private String OperationLevel;

    public void setVaules(String vaules)
    {
        this.vaules = vaules;
    }
    public String getVaules()
    {
        return this.vaules;
    }
    public void setDepName(String DepName)
    {
        this.DepName = DepName;
    }
    public String getDepName()
    {
        return this.DepName;
    }
    public void setOperationLevel(String OperationLevel)
    {
        this.OperationLevel = OperationLevel;
    }
    public String getOperationLevel()
    {
        return this.OperationLevel;
    }
}
