package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCConsultApplyZD
{
    @JsonProperty(value = "DCConsultApplyZD")
    private DCConsultApplyZD[] DCConsultApplyZD;

    public void setDCConsultApplyZD(DCConsultApplyZD[] DCConsultApplyZD)
    {
        this.DCConsultApplyZD = DCConsultApplyZD;
    }
    public DCConsultApplyZD[] getDCConsultApplyZD()
    {
        return this.DCConsultApplyZD;
    }
}
