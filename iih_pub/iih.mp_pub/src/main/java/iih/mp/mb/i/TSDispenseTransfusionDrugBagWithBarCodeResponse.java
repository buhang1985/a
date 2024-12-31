package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSDispenseTransfusionDrugBagWithBarCodeResponse
{
    @JsonProperty(value = "TSDispenseTransfusionDrugBagWithBarCodeResult")
    private TSDrugBag TSDispenseTransfusionDrugBagWithBarCodeResult;

    public void setTSDispenseTransfusionDrugBagWithBarCodeResult(TSDrugBag TSDispenseTransfusionDrugBagWithBarCodeResult)
    {
        this.TSDispenseTransfusionDrugBagWithBarCodeResult = TSDispenseTransfusionDrugBagWithBarCodeResult;
    }
    public TSDrugBag getTSDispenseTransfusionDrugBagWithBarCodeResult()
    {
        return this.TSDispenseTransfusionDrugBagWithBarCodeResult;
    }
}
