package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateConfigResponse
{
    @JsonProperty(value = "UpdateConfigResult")
    private Boolean UpdateConfigResult;

    public void setUpdateConfigResult(Boolean UpdateConfigResult)
    {
        this.UpdateConfigResult = UpdateConfigResult;
    }
    public Boolean getUpdateConfigResult()
    {
        return this.UpdateConfigResult;
    }
}
