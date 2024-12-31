package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ZuoFeiDoctorAdviceOfPatientHRRequest
{
    @JsonProperty(value = "patientID")
    private String patientID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "orderID")
    private String orderID;
    @JsonProperty(value = "doctor")
    private String doctor;
    @JsonProperty(value = "state")
    private Integer state;
    @JsonProperty(value = "type")
    private Integer type;

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    public String getPatientID()
    {
        return this.patientID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setOrderID(String orderID)
    {
        this.orderID = orderID;
    }
    public String getOrderID()
    {
        return this.orderID;
    }
    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }
    public String getDoctor()
    {
        return this.doctor;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }
    public Integer getState()
    {
        return this.state;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }
    public Integer getType()
    {
        return this.type;
    }
}
