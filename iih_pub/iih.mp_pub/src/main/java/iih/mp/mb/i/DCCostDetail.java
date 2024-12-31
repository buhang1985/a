package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCCostDetail
{
    @JsonProperty(value = "CreateDate")
    private String CreateDate;
    @JsonProperty(value = "ReciptID")
    private String ReciptID;
    @JsonProperty(value = "CreatePersonName")
    private String CreatePersonName;
    @JsonProperty(value = "CreateDepartmentName")
    private String CreateDepartmentName;
    @JsonProperty(value = "ExecuteDepartmentName")
    private String ExecuteDepartmentName;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "Spefication")
    private String Spefication;
    @JsonProperty(value = "ChargeType")
    private String ChargeType;
    @JsonProperty(value = "Amount")
    private String Amount;
    @JsonProperty(value = "StandardPrice")
    private String StandardPrice;
    @JsonProperty(value = "StandardCost")
    private String StandardCost;
    @JsonProperty(value = "UnSettled")
    private String UnSettled;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "FeeItemCode")
    private String FeeItemCode;
    @JsonProperty(value = "BillType")
    private String BillType;
    @JsonProperty(value = "BillTypeName")
    private String BillTypeName;

    public void setCreateDate(String CreateDate)
    {
        this.CreateDate = CreateDate;
    }
    public String getCreateDate()
    {
        return this.CreateDate;
    }
    public void setReciptID(String ReciptID)
    {
        this.ReciptID = ReciptID;
    }
    public String getReciptID()
    {
        return this.ReciptID;
    }
    public void setCreatePersonName(String CreatePersonName)
    {
        this.CreatePersonName = CreatePersonName;
    }
    public String getCreatePersonName()
    {
        return this.CreatePersonName;
    }
    public void setCreateDepartmentName(String CreateDepartmentName)
    {
        this.CreateDepartmentName = CreateDepartmentName;
    }
    public String getCreateDepartmentName()
    {
        return this.CreateDepartmentName;
    }
    public void setExecuteDepartmentName(String ExecuteDepartmentName)
    {
        this.ExecuteDepartmentName = ExecuteDepartmentName;
    }
    public String getExecuteDepartmentName()
    {
        return this.ExecuteDepartmentName;
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
    public void setChargeType(String ChargeType)
    {
        this.ChargeType = ChargeType;
    }
    public String getChargeType()
    {
        return this.ChargeType;
    }
    public void setAmount(String Amount)
    {
        this.Amount = Amount;
    }
    public String getAmount()
    {
        return this.Amount;
    }
    public void setStandardPrice(String StandardPrice)
    {
        this.StandardPrice = StandardPrice;
    }
    public String getStandardPrice()
    {
        return this.StandardPrice;
    }
    public void setStandardCost(String StandardCost)
    {
        this.StandardCost = StandardCost;
    }
    public String getStandardCost()
    {
        return this.StandardCost;
    }
    public void setUnSettled(String UnSettled)
    {
        this.UnSettled = UnSettled;
    }
    public String getUnSettled()
    {
        return this.UnSettled;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setFeeItemCode(String FeeItemCode)
    {
        this.FeeItemCode = FeeItemCode;
    }
    public String getFeeItemCode()
    {
        return this.FeeItemCode;
    }
    public void setBillType(String BillType)
    {
        this.BillType = BillType;
    }
    public String getBillType()
    {
        return this.BillType;
    }
    public void setBillTypeName(String BillTypeName)
    {
        this.BillTypeName = BillTypeName;
    }
    public String getBillTypeName()
    {
        return this.BillTypeName;
    }
}
