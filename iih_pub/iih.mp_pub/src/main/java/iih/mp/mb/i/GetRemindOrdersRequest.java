package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetRemindOrdersRequest
{
    @JsonProperty(value = "patientNo")
    private String patientNo;
    @JsonProperty(value = "visitId")
    private String visitId;
    @JsonProperty(value = "state")
    private String state;

    public void setPatientNo(String patientNo)
    {
        this.patientNo = patientNo;
    }
    public String getPatientNo()
    {
        return this.patientNo;
    }
    public void setVisitId(String visitId)
    {
        this.visitId = visitId;
    }
    public String getVisitId()
    {
        return this.visitId;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getState()
    {
        return this.state;
    }
}
