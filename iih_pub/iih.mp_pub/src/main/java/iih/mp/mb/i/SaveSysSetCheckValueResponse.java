package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveSysSetCheckValueResponse
{
    @JsonProperty(value = "SaveSysSetCheckValueResult")
    private Boolean SaveSysSetCheckValueResult;

    public void setSaveSysSetCheckValueResult(Boolean SaveSysSetCheckValueResult)
    {
        this.SaveSysSetCheckValueResult = SaveSysSetCheckValueResult;
    }
    public Boolean getSaveSysSetCheckValueResult()
    {
        return this.SaveSysSetCheckValueResult;
    }
}
