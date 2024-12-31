package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PrintPatientTestInformationResponse
{
    @JsonProperty(value = "PrintPatientTestInformationResult")
    private Boolean PrintPatientTestInformationResult;

    public void setPrintPatientTestInformationResult(Boolean PrintPatientTestInformationResult)
    {
        this.PrintPatientTestInformationResult = PrintPatientTestInformationResult;
    }
    public Boolean getPrintPatientTestInformationResult()
    {
        return this.PrintPatientTestInformationResult;
    }
}
