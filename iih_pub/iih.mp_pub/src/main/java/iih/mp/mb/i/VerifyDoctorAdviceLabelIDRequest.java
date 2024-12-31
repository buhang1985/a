package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VerifyDoctorAdviceLabelIDRequest
{
    @JsonProperty(value = "labelID")
    private String labelID;

    public void setLabelID(String labelID)
    {
        this.labelID = labelID;
    }
    public String getLabelID()
    {
        return this.labelID;
    }
}
