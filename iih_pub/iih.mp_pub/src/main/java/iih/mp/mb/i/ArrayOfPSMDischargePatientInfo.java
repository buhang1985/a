package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfPSMDischargePatientInfo
{
    @JsonProperty(value = "PSMDischargePatientInfo")
    private PSMDischargePatientInfo[] PSMDischargePatientInfo;

    public void setPSMDischargePatientInfo(PSMDischargePatientInfo[] PSMDischargePatientInfo)
    {
        this.PSMDischargePatientInfo = PSMDischargePatientInfo;
    }
    public PSMDischargePatientInfo[] getPSMDischargePatientInfo()
    {
        return this.PSMDischargePatientInfo;
    }
}
