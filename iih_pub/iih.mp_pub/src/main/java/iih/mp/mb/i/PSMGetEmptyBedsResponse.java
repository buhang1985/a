package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetEmptyBedsResponse
{
    @JsonProperty(value = "PSMGetEmptyBedsResult")
    private ArrayOfPSMBedInfo PSMGetEmptyBedsResult;

    public void setPSMGetEmptyBedsResult(ArrayOfPSMBedInfo PSMGetEmptyBedsResult)
    {
        this.PSMGetEmptyBedsResult = PSMGetEmptyBedsResult;
    }
    public ArrayOfPSMBedInfo getPSMGetEmptyBedsResult()
    {
        return this.PSMGetEmptyBedsResult;
    }
}
