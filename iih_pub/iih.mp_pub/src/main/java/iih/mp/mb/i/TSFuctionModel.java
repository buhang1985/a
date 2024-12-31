package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSFuctionModel
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "FunctionName")
    private String FunctionName;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setFunctionName(String FunctionName)
    {
        this.FunctionName = FunctionName;
    }
    public String getFunctionName()
    {
        return this.FunctionName;
    }
}
