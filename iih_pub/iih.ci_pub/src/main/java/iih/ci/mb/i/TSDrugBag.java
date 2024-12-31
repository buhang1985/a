package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSDrugBag
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "RegisterID")
    private String RegisterID;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "OrderID")
    private Integer OrderID;
    @JsonProperty(value = "BarID")
    private String BarID;
    @JsonProperty(value = "DispensingDate")
    private String DispensingDate;
    @JsonProperty(value = "DispensingNurseID")
    private String DispensingNurseID;
    @JsonProperty(value = "DispensingNurseName")
    private String DispensingNurseName;
    @JsonProperty(value = "ExecuteDate")
    private String ExecuteDate;
    @JsonProperty(value = "ExecuteNurseID")
    private String ExecuteNurseID;
    @JsonProperty(value = "ExecuteNurseName")
    private String ExecuteNurseName;
    @JsonProperty(value = "FinishedDate")
    private String FinishedDate;
    @JsonProperty(value = "FinishedNurseID")
    private String FinishedNurseID;
    @JsonProperty(value = "FinishedNurseName")
    private String FinishedNurseName;
    @JsonProperty(value = "DrugBagItems")
    private ArrayOfTSDrugBagItem DrugBagItems;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setRegisterID(String RegisterID)
    {
        this.RegisterID = RegisterID;
    }
    public String getRegisterID()
    {
        return this.RegisterID;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setOrderID(Integer OrderID)
    {
        this.OrderID = OrderID;
    }
    public Integer getOrderID()
    {
        return this.OrderID;
    }
    public void setBarID(String BarID)
    {
        this.BarID = BarID;
    }
    public String getBarID()
    {
        return this.BarID;
    }
    public void setDispensingDate(String DispensingDate)
    {
        this.DispensingDate = DispensingDate;
    }
    public String getDispensingDate()
    {
        return this.DispensingDate;
    }
    public void setDispensingNurseID(String DispensingNurseID)
    {
        this.DispensingNurseID = DispensingNurseID;
    }
    public String getDispensingNurseID()
    {
        return this.DispensingNurseID;
    }
    public void setDispensingNurseName(String DispensingNurseName)
    {
        this.DispensingNurseName = DispensingNurseName;
    }
    public String getDispensingNurseName()
    {
        return this.DispensingNurseName;
    }
    public void setExecuteDate(String ExecuteDate)
    {
        this.ExecuteDate = ExecuteDate;
    }
    public String getExecuteDate()
    {
        return this.ExecuteDate;
    }
    public void setExecuteNurseID(String ExecuteNurseID)
    {
        this.ExecuteNurseID = ExecuteNurseID;
    }
    public String getExecuteNurseID()
    {
        return this.ExecuteNurseID;
    }
    public void setExecuteNurseName(String ExecuteNurseName)
    {
        this.ExecuteNurseName = ExecuteNurseName;
    }
    public String getExecuteNurseName()
    {
        return this.ExecuteNurseName;
    }
    public void setFinishedDate(String FinishedDate)
    {
        this.FinishedDate = FinishedDate;
    }
    public String getFinishedDate()
    {
        return this.FinishedDate;
    }
    public void setFinishedNurseID(String FinishedNurseID)
    {
        this.FinishedNurseID = FinishedNurseID;
    }
    public String getFinishedNurseID()
    {
        return this.FinishedNurseID;
    }
    public void setFinishedNurseName(String FinishedNurseName)
    {
        this.FinishedNurseName = FinishedNurseName;
    }
    public String getFinishedNurseName()
    {
        return this.FinishedNurseName;
    }
    public void setDrugBagItems(ArrayOfTSDrugBagItem DrugBagItems)
    {
        this.DrugBagItems = DrugBagItems;
    }
    public ArrayOfTSDrugBagItem getDrugBagItems()
    {
        return this.DrugBagItems;
    }
}
