package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSettingPermissionResponse
{
    @JsonProperty(value = "GetSettingPermissionResult")
    private String GetSettingPermissionResult;

    public void setGetSettingPermissionResult(String GetSettingPermissionResult)
    {
        this.GetSettingPermissionResult = GetSettingPermissionResult;
    }
    public String getGetSettingPermissionResult()
    {
        return this.GetSettingPermissionResult;
    }
}
