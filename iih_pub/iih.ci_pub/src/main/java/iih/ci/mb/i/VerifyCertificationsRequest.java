package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VerifyCertificationsRequest
{
    @JsonProperty(value = "cers")
    private ArrayOfDCUserCertification cers;

    public void setCers(ArrayOfDCUserCertification cers)
    {
        this.cers = cers;
    }
    public ArrayOfDCUserCertification getCers()
    {
        return this.cers;
    }
}
