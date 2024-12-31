package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetMulKeyBoard2Request
{
    @JsonProperty(value = "templateNo")
    private String templateNo;

    public void setTemplateNo(String templateNo)
    {
        this.templateNo = templateNo;
    }
    public String getTemplateNo()
    {
        return this.templateNo;
    }
}
