package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddChargeItemRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "operater")
    private String operater;
    @JsonProperty(value = "listCI")
    private ArrayOfDCChargeItem listCI;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setOperater(String operater)
    {
        this.operater = operater;
    }
    public String getOperater()
    {
        return this.operater;
    }
    public void setListCI(ArrayOfDCChargeItem listCI)
    {
        this.listCI = listCI;
    }
    public ArrayOfDCChargeItem getListCI()
    {
        return this.listCI;
    }
}
