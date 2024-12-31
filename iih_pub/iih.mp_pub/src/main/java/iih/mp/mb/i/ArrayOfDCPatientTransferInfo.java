package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientTransferInfo
{
    @JsonProperty(value = "DCPatientTransferInfo")
    private DCPatientTransferInfo[] DCPatientTransferInfo;

    public void setDCPatientTransferInfo(DCPatientTransferInfo[] DCPatientTransferInfo)
    {
        this.DCPatientTransferInfo = DCPatientTransferInfo;
    }
    public DCPatientTransferInfo[] getDCPatientTransferInfo()
    {
        return this.DCPatientTransferInfo;
    }
}
