package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCUserCertification
{
    @JsonProperty(value = "DCUserCertification")
    private DCUserCertification[] DCUserCertification;

    public void setDCUserCertification(DCUserCertification[] DCUserCertification)
    {
        this.DCUserCertification = DCUserCertification;
    }
    public DCUserCertification[] getDCUserCertification()
    {
        return this.DCUserCertification;
    }
}
