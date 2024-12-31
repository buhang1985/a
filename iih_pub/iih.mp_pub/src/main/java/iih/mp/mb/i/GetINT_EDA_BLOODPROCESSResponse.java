package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetINT_EDA_BLOODPROCESSResponse
{
    @JsonProperty(value = "GetINT_EDA_BLOODPROCESSResult")
    private ArrayOfDCBloodTransfusionsItem GetINT_EDA_BLOODPROCESSResult;

    public void setGetINT_EDA_BLOODPROCESSResult(ArrayOfDCBloodTransfusionsItem GetINT_EDA_BLOODPROCESSResult)
    {
        this.GetINT_EDA_BLOODPROCESSResult = GetINT_EDA_BLOODPROCESSResult;
    }
    public ArrayOfDCBloodTransfusionsItem getGetINT_EDA_BLOODPROCESSResult()
    {
        return this.GetINT_EDA_BLOODPROCESSResult;
    }
}
