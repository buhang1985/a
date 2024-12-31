package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveInsertNURSE_Blood_AcceptResponse
{
    @JsonProperty(value = "SaveInsertNURSE_Blood_AcceptResult")
    private Boolean SaveInsertNURSE_Blood_AcceptResult;

    public void setSaveInsertNURSE_Blood_AcceptResult(Boolean SaveInsertNURSE_Blood_AcceptResult)
    {
        this.SaveInsertNURSE_Blood_AcceptResult = SaveInsertNURSE_Blood_AcceptResult;
    }
    public Boolean getSaveInsertNURSE_Blood_AcceptResult()
    {
        return this.SaveInsertNURSE_Blood_AcceptResult;
    }
}
