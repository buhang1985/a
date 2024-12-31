package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDeviceInfo
{
    @JsonProperty(value = "DeviceName")
    private String DeviceName;
    @JsonProperty(value = "DeviceSerial")
    private String DeviceSerial;
    @JsonProperty(value = "DeviceNumber")
    private String DeviceNumber;
    @JsonProperty(value = "DeviceVersion")
    private String DeviceVersion;
    @JsonProperty(value = "OtherInfo")
    private String OtherInfo;
    @JsonProperty(value = "RegistTime")
    private String RegistTime;
    @JsonProperty(value = "RegistUser")
    private String RegistUser;
    @JsonProperty(value = "DeviceState")
    private String DeviceState;
    @JsonProperty(value = "DeviceManageCode")
    private String DeviceManageCode;
    @JsonProperty(value = "DeviceManageName")
    private String DeviceManageName;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DeptName")
    private String DeptName;

    public void setDeviceName(String DeviceName)
    {
        this.DeviceName = DeviceName;
    }
    public String getDeviceName()
    {
        return this.DeviceName;
    }
    public void setDeviceSerial(String DeviceSerial)
    {
        this.DeviceSerial = DeviceSerial;
    }
    public String getDeviceSerial()
    {
        return this.DeviceSerial;
    }
    public void setDeviceNumber(String DeviceNumber)
    {
        this.DeviceNumber = DeviceNumber;
    }
    public String getDeviceNumber()
    {
        return this.DeviceNumber;
    }
    public void setDeviceVersion(String DeviceVersion)
    {
        this.DeviceVersion = DeviceVersion;
    }
    public String getDeviceVersion()
    {
        return this.DeviceVersion;
    }
    public void setOtherInfo(String OtherInfo)
    {
        this.OtherInfo = OtherInfo;
    }
    public String getOtherInfo()
    {
        return this.OtherInfo;
    }
    public void setRegistTime(String RegistTime)
    {
        this.RegistTime = RegistTime;
    }
    public String getRegistTime()
    {
        return this.RegistTime;
    }
    public void setRegistUser(String RegistUser)
    {
        this.RegistUser = RegistUser;
    }
    public String getRegistUser()
    {
        return this.RegistUser;
    }
    public void setDeviceState(String DeviceState)
    {
        this.DeviceState = DeviceState;
    }
    public String getDeviceState()
    {
        return this.DeviceState;
    }
    public void setDeviceManageCode(String DeviceManageCode)
    {
        this.DeviceManageCode = DeviceManageCode;
    }
    public String getDeviceManageCode()
    {
        return this.DeviceManageCode;
    }
    public void setDeviceManageName(String DeviceManageName)
    {
        this.DeviceManageName = DeviceManageName;
    }
    public String getDeviceManageName()
    {
        return this.DeviceManageName;
    }
    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
}
