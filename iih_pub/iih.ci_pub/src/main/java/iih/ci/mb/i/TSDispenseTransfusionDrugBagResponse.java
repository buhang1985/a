package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSDispenseTransfusionDrugBagResponse
{
    @JsonProperty(value = "TSDispenseTransfusionDrugBagResult")
    private TSDrugBag TSDispenseTransfusionDrugBagResult;

    public void setTSDispenseTransfusionDrugBagResult(TSDrugBag TSDispenseTransfusionDrugBagResult)
    {
        this.TSDispenseTransfusionDrugBagResult = TSDispenseTransfusionDrugBagResult;
    }
    public TSDrugBag getTSDispenseTransfusionDrugBagResult()
    {
        return this.TSDispenseTransfusionDrugBagResult;
    }
}
