package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSFindRegisterByPrescriptionBarCodeResponse
{
    @JsonProperty(value = "TSFindRegisterByPrescriptionBarCodeResult")
    private TSTransfusionRegister TSFindRegisterByPrescriptionBarCodeResult;

    public void setTSFindRegisterByPrescriptionBarCodeResult(TSTransfusionRegister TSFindRegisterByPrescriptionBarCodeResult)
    {
        this.TSFindRegisterByPrescriptionBarCodeResult = TSFindRegisterByPrescriptionBarCodeResult;
    }
    public TSTransfusionRegister getTSFindRegisterByPrescriptionBarCodeResult()
    {
        return this.TSFindRegisterByPrescriptionBarCodeResult;
    }
}
