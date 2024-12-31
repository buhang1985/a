package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class getsplitDoctorAdviceForOneRequest
{
    @JsonProperty(value = "encounterID")
    private String encounterID;
    @JsonProperty(value = "parentExecOrder")
    private String parentExecOrder;

    public void setEncounterID(String encounterID)
    {
        this.encounterID = encounterID;
    }
    public String getEncounterID()
    {
        return this.encounterID;
    }
    public void setParentExecOrder(String parentExecOrder)
    {
        this.parentExecOrder = parentExecOrder;
    }
    public String getParentExecOrder()
    {
        return this.parentExecOrder;
    }
}
