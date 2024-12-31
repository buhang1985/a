package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMQueryDischargerDiagnoseResponse
{
    @JsonProperty(value = "PSMQueryDischargerDiagnoseResult")
    private ArrayOfPSMDiagnoseInfo PSMQueryDischargerDiagnoseResult;

    public void setPSMQueryDischargerDiagnoseResult(ArrayOfPSMDiagnoseInfo PSMQueryDischargerDiagnoseResult)
    {
        this.PSMQueryDischargerDiagnoseResult = PSMQueryDischargerDiagnoseResult;
    }
    public ArrayOfPSMDiagnoseInfo getPSMQueryDischargerDiagnoseResult()
    {
        return this.PSMQueryDischargerDiagnoseResult;
    }
}
