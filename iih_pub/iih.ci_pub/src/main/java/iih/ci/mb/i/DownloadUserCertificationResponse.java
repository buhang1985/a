package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DownloadUserCertificationResponse
{
    @JsonProperty(value = "DownloadUserCertificationResult")
    private DCUserCertification DownloadUserCertificationResult;

    public void setDownloadUserCertificationResult(DCUserCertification DownloadUserCertificationResult)
    {
        this.DownloadUserCertificationResult = DownloadUserCertificationResult;
    }
    public DCUserCertification getDownloadUserCertificationResult()
    {
        return this.DownloadUserCertificationResult;
    }
}
