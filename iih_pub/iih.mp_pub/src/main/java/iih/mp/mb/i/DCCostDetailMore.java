package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCCostDetailMore
{
    @JsonProperty(value = "HappenDate")
    private String HappenDate;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "Spefication")
    private String Spefication;
    @JsonProperty(value = "Price")
    private String Price;
    @JsonProperty(value = "Amount")
    private String Amount;
    @JsonProperty(value = "TotalFee")
    private String TotalFee;
    @JsonProperty(value = "ConfirmDate")
    private String ConfirmDate;
    @JsonProperty(value = "ConfirmOpearName")
    private String ConfirmOpearName;

    public void setHappenDate(String HappenDate)
    {
        this.HappenDate = HappenDate;
    }
    public String getHappenDate()
    {
        return this.HappenDate;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setSpefication(String Spefication)
    {
        this.Spefication = Spefication;
    }
    public String getSpefication()
    {
        return this.Spefication;
    }
    public void setPrice(String Price)
    {
        this.Price = Price;
    }
    public String getPrice()
    {
        return this.Price;
    }
    public void setAmount(String Amount)
    {
        this.Amount = Amount;
    }
    public String getAmount()
    {
        return this.Amount;
    }
    public void setTotalFee(String TotalFee)
    {
        this.TotalFee = TotalFee;
    }
    public String getTotalFee()
    {
        return this.TotalFee;
    }
    public void setConfirmDate(String ConfirmDate)
    {
        this.ConfirmDate = ConfirmDate;
    }
    public String getConfirmDate()
    {
        return this.ConfirmDate;
    }
    public void setConfirmOpearName(String ConfirmOpearName)
    {
        this.ConfirmOpearName = ConfirmOpearName;
    }
    public String getConfirmOpearName()
    {
        return this.ConfirmOpearName;
    }
}
