package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class RegisterDeviceResponse
{
    @JsonProperty(value = "RegisterDeviceResult")
    private Boolean RegisterDeviceResult;

    public void setRegisterDeviceResult(Boolean RegisterDeviceResult)
    {
        this.RegisterDeviceResult = RegisterDeviceResult;
    }
    public Boolean getRegisterDeviceResult()
    {
        return this.RegisterDeviceResult;
    }
}
