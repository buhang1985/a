package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetEMRReportContentRequest
{
    @JsonProperty(value = "docid")
    private String docid;

    public void setDocid(String docid)
    {
        this.docid = docid;
    }
    public String getDocid()
    {
        return this.docid;
    }
}
