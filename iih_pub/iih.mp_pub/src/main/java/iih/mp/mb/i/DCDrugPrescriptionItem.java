package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDrugPrescriptionItem
{
    @JsonProperty(value = "PrescID")
    private String PrescID;
    @JsonProperty(value = "PrescDate")
    private String PrescDate;
    @JsonProperty(value = "ItemNo")
    private Integer ItemNo;
    @JsonProperty(value = "DrugCode")
    private String DrugCode;
    @JsonProperty(value = "DrugName")
    private String DrugName;
    @JsonProperty(value = "DrugSpecification")
    private String DrugSpecification;
    @JsonProperty(value = "FirmDescription")
    private String FirmDescription;
    @JsonProperty(value = "PackageSpecification")
    private String PackageSpecification;
    @JsonProperty(value = "PackageUnit")
    private String PackageUnit;
    @JsonProperty(value = "Quantity")
    private String Quantity;
    @JsonProperty(value = "Dosage")
    private String Dosage;
    @JsonProperty(value = "DosageUnit")
    private String DosageUnit;
    @JsonProperty(value = "Administration")
    private String Administration;
    @JsonProperty(value = "Frequency")
    private String Frequency;
    @JsonProperty(value = "Price")
    private String Price;
    @JsonProperty(value = "PrescDays")
    private String PrescDays;
    @JsonProperty(value = "PrescDaysUnit")
    private String PrescDaysUnit;
    @JsonProperty(value = "BoilFlag")
    private String BoilFlag;

    public void setPrescID(String PrescID)
    {
        this.PrescID = PrescID;
    }
    public String getPrescID()
    {
        return this.PrescID;
    }
    public void setPrescDate(String PrescDate)
    {
        this.PrescDate = PrescDate;
    }
    public String getPrescDate()
    {
        return this.PrescDate;
    }
    public void setItemNo(Integer ItemNo)
    {
        this.ItemNo = ItemNo;
    }
    public Integer getItemNo()
    {
        return this.ItemNo;
    }
    public void setDrugCode(String DrugCode)
    {
        this.DrugCode = DrugCode;
    }
    public String getDrugCode()
    {
        return this.DrugCode;
    }
    public void setDrugName(String DrugName)
    {
        this.DrugName = DrugName;
    }
    public String getDrugName()
    {
        return this.DrugName;
    }
    public void setDrugSpecification(String DrugSpecification)
    {
        this.DrugSpecification = DrugSpecification;
    }
    public String getDrugSpecification()
    {
        return this.DrugSpecification;
    }
    public void setFirmDescription(String FirmDescription)
    {
        this.FirmDescription = FirmDescription;
    }
    public String getFirmDescription()
    {
        return this.FirmDescription;
    }
    public void setPackageSpecification(String PackageSpecification)
    {
        this.PackageSpecification = PackageSpecification;
    }
    public String getPackageSpecification()
    {
        return this.PackageSpecification;
    }
    public void setPackageUnit(String PackageUnit)
    {
        this.PackageUnit = PackageUnit;
    }
    public String getPackageUnit()
    {
        return this.PackageUnit;
    }
    public void setQuantity(String Quantity)
    {
        this.Quantity = Quantity;
    }
    public String getQuantity()
    {
        return this.Quantity;
    }
    public void setDosage(String Dosage)
    {
        this.Dosage = Dosage;
    }
    public String getDosage()
    {
        return this.Dosage;
    }
    public void setDosageUnit(String DosageUnit)
    {
        this.DosageUnit = DosageUnit;
    }
    public String getDosageUnit()
    {
        return this.DosageUnit;
    }
    public void setAdministration(String Administration)
    {
        this.Administration = Administration;
    }
    public String getAdministration()
    {
        return this.Administration;
    }
    public void setFrequency(String Frequency)
    {
        this.Frequency = Frequency;
    }
    public String getFrequency()
    {
        return this.Frequency;
    }
    public void setPrice(String Price)
    {
        this.Price = Price;
    }
    public String getPrice()
    {
        return this.Price;
    }
    public void setPrescDays(String PrescDays)
    {
        this.PrescDays = PrescDays;
    }
    public String getPrescDays()
    {
        return this.PrescDays;
    }
    public void setPrescDaysUnit(String PrescDaysUnit)
    {
        this.PrescDaysUnit = PrescDaysUnit;
    }
    public String getPrescDaysUnit()
    {
        return this.PrescDaysUnit;
    }
    public void setBoilFlag(String BoilFlag)
    {
        this.BoilFlag = BoilFlag;
    }
    public String getBoilFlag()
    {
        return this.BoilFlag;
    }
}
