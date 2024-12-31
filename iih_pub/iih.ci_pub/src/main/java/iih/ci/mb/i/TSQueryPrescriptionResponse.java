package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSQueryPrescriptionResponse
{
    @JsonProperty(value = "TSQueryPrescriptionResult")
    private ArrayOfTSPrescription TSQueryPrescriptionResult;

    public void setTSQueryPrescriptionResult(ArrayOfTSPrescription TSQueryPrescriptionResult)
    {
        this.TSQueryPrescriptionResult = TSQueryPrescriptionResult;
    }
    public ArrayOfTSPrescription getTSQueryPrescriptionResult()
    {
        return this.TSQueryPrescriptionResult;
    }
}
