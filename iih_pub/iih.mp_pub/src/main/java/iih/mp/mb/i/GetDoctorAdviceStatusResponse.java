package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorAdviceStatusResponse
{
    @JsonProperty(value = "GetDoctorAdviceStatusResult")
    private String GetDoctorAdviceStatusResult;

    @JsonProperty(value = "WarningInfo")
    private String WarningInfo;
    
    public void setGetDoctorAdviceStatusResult(String GetDoctorAdviceStatusResult)
    {
        this.GetDoctorAdviceStatusResult = GetDoctorAdviceStatusResult;
    }
    public String getGetDoctorAdviceStatusResult()
    {
        return this.GetDoctorAdviceStatusResult;
    }
	public String getWarningInfo() {
		return WarningInfo;
	}
	public void setWarningInfo(String warningInfo) {
		WarningInfo = warningInfo;
	}
    
}
