package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMPatientFeeInfo
{
    @JsonProperty(value = "TotalCharge")
    private Double TotalCharge;
    @JsonProperty(value = "DepoCharge")
    private Double DepoCharge;
    @JsonProperty(value = "Balance")
    private Double Balance;
    @JsonProperty(value = "OweLimit")
    private Double OweLimit;

    public void setTotalCharge(Double TotalCharge)
    {
        this.TotalCharge = TotalCharge;
    }
    public Double getTotalCharge()
    {
        return this.TotalCharge;
    }
    public void setDepoCharge(Double DepoCharge)
    {
        this.DepoCharge = DepoCharge;
    }
    public Double getDepoCharge()
    {
        return this.DepoCharge;
    }
    public void setBalance(Double Balance)
    {
        this.Balance = Balance;
    }
    public Double getBalance()
    {
        return this.Balance;
    }
    public void setOweLimit(Double OweLimit)
    {
        this.OweLimit = OweLimit;
    }
    public Double getOweLimit()
    {
        return this.OweLimit;
    }
}
