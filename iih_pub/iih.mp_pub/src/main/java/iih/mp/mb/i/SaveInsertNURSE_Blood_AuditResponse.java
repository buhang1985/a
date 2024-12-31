package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveInsertNURSE_Blood_AuditResponse
{
    @JsonProperty(value = "SaveInsertNURSE_Blood_AuditResult")
    private Boolean SaveInsertNURSE_Blood_AuditResult;

    public void setSaveInsertNURSE_Blood_AuditResult(Boolean SaveInsertNURSE_Blood_AuditResult)
    {
        this.SaveInsertNURSE_Blood_AuditResult = SaveInsertNURSE_Blood_AuditResult;
    }
    public Boolean getSaveInsertNURSE_Blood_AuditResult()
    {
        return this.SaveInsertNURSE_Blood_AuditResult;
    }
}
