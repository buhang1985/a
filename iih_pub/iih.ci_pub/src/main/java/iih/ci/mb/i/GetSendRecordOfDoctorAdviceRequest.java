package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSendRecordOfDoctorAdviceRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "oid")
    private String oid;
    @JsonProperty(value = "osid")
    private String osid;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setOid(String oid)
    {
        this.oid = oid;
    }
    public String getOid()
    {
        return this.oid;
    }
    public void setOsid(String osid)
    {
        this.osid = osid;
    }
    public String getOsid()
    {
        return this.osid;
    }
}
