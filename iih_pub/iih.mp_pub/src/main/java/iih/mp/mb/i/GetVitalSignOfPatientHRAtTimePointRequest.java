package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetVitalSignOfPatientHRAtTimePointRequest
{
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "timePoint")
    private String timePoint;

    /**
     * 部门编码
     * @param deptCode
     */
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    /**
     * 患者住院记录标识ID
     * @param patientHRID
     */
    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    /**
     * 患者住院子ID
     * @param subID
     */
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    /**
     * 时间点
     * @param timePoint
     */
    public void setTimePoint(String timePoint)
    {
        this.timePoint = timePoint;
    }
    public String getTimePoint()
    {
        return this.timePoint;
    }
}
