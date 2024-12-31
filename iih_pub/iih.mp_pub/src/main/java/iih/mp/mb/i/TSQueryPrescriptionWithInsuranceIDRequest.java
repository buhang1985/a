package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSQueryPrescriptionWithInsuranceIDRequest
{
    @JsonProperty(value = "startDateTime")
    private Long startDateTime;
    @JsonProperty(value = "endDateTime")
    private Long endDateTime;
    @JsonProperty(value = "insuranceID")
    private String insuranceID;

    public void setStartDateTime(Long startDateTime)
    {
        this.startDateTime = startDateTime;
    }
    public Long getStartDateTime()
    {
        return this.startDateTime;
    }
    public void setEndDateTime(Long endDateTime)
    {
        this.endDateTime = endDateTime;
    }
    public Long getEndDateTime()
    {
        return this.endDateTime;
    }
    public void setInsuranceID(String insuranceID)
    {
        this.insuranceID = insuranceID;
    }
    public String getInsuranceID()
    {
        return this.insuranceID;
    }
}
