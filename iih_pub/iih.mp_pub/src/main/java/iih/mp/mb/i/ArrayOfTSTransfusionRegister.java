package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTSTransfusionRegister
{
    @JsonProperty(value = "TSTransfusionRegister")
    private TSTransfusionRegister[] TSTransfusionRegister;

    public void setTSTransfusionRegister(TSTransfusionRegister[] TSTransfusionRegister)
    {
        this.TSTransfusionRegister = TSTransfusionRegister;
    }
    public TSTransfusionRegister[] getTSTransfusionRegister()
    {
        return this.TSTransfusionRegister;
    }
}
