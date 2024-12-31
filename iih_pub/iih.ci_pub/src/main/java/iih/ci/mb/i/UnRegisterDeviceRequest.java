package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UnRegisterDeviceRequest
{
    @JsonProperty(value = "deviceID")
    private String deviceID;

    public void setDeviceID(String deviceID)
    {
        this.deviceID = deviceID;
    }
    public String getDeviceID()
    {
        return this.deviceID;
    }
}
