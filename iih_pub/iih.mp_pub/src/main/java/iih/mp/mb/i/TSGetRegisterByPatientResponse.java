package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetRegisterByPatientResponse
{
    @JsonProperty(value = "TSGetRegisterByPatientResult")
    private ArrayOfTSTransfusionRegister TSGetRegisterByPatientResult;

    public void setTSGetRegisterByPatientResult(ArrayOfTSTransfusionRegister TSGetRegisterByPatientResult)
    {
        this.TSGetRegisterByPatientResult = TSGetRegisterByPatientResult;
    }
    public ArrayOfTSTransfusionRegister getTSGetRegisterByPatientResult()
    {
        return this.TSGetRegisterByPatientResult;
    }
}
