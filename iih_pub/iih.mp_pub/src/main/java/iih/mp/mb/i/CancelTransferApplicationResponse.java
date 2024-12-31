package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CancelTransferApplicationResponse
{
    @JsonProperty(value = "CancelTransferApplicationResult")
    private Integer CancelTransferApplicationResult;

    public void setCancelTransferApplicationResult(Integer CancelTransferApplicationResult)
    {
        this.CancelTransferApplicationResult = CancelTransferApplicationResult;
    }
    public Integer getCancelTransferApplicationResult()
    {
        return this.CancelTransferApplicationResult;
    }
}
