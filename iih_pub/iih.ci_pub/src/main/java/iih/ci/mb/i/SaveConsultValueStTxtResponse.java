package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveConsultValueStTxtResponse
{
    @JsonProperty(value = "SaveConsultValueStTxtResult")
    private Integer SaveConsultValueStTxtResult;

    public void setSaveConsultValueStTxtResult(Integer SaveConsultValueStTxtResult)
    {
        this.SaveConsultValueStTxtResult = SaveConsultValueStTxtResult;
    }
    public Integer getSaveConsultValueStTxtResult()
    {
        return this.SaveConsultValueStTxtResult;
    }
}
