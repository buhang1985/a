package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSNurseWorkDetail
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "NurseID")
    private String NurseID;
    @JsonProperty(value = "NurseName")
    private String NurseName;
    @JsonProperty(value = "WorkType")
    private Integer WorkType;
    @JsonProperty(value = "WorkDateTime")
    private Long WorkDateTime;
    @JsonProperty(value = "WorkDepartmentID")
    private String WorkDepartmentID;
    @JsonProperty(value = "WorkDepartmentName")
    private String WorkDepartmentName;
    @JsonProperty(value = "RegisterID")
    private String RegisterID;
    @JsonProperty(value = "DrugBagID1")
    private String DrugBagID1;
    @JsonProperty(value = "DrugBagID2")
    private String DrugBagID2;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setNurseID(String NurseID)
    {
        this.NurseID = NurseID;
    }
    public String getNurseID()
    {
        return this.NurseID;
    }
    public void setNurseName(String NurseName)
    {
        this.NurseName = NurseName;
    }
    public String getNurseName()
    {
        return this.NurseName;
    }
    public void setWorkType(Integer WorkType)
    {
        this.WorkType = WorkType;
    }
    public Integer getWorkType()
    {
        return this.WorkType;
    }
    public void setWorkDateTime(Long WorkDateTime)
    {
        this.WorkDateTime = WorkDateTime;
    }
    public Long getWorkDateTime()
    {
        return this.WorkDateTime;
    }
    public void setWorkDepartmentID(String WorkDepartmentID)
    {
        this.WorkDepartmentID = WorkDepartmentID;
    }
    public String getWorkDepartmentID()
    {
        return this.WorkDepartmentID;
    }
    public void setWorkDepartmentName(String WorkDepartmentName)
    {
        this.WorkDepartmentName = WorkDepartmentName;
    }
    public String getWorkDepartmentName()
    {
        return this.WorkDepartmentName;
    }
    public void setRegisterID(String RegisterID)
    {
        this.RegisterID = RegisterID;
    }
    public String getRegisterID()
    {
        return this.RegisterID;
    }
    public void setDrugBagID1(String DrugBagID1)
    {
        this.DrugBagID1 = DrugBagID1;
    }
    public String getDrugBagID1()
    {
        return this.DrugBagID1;
    }
    public void setDrugBagID2(String DrugBagID2)
    {
        this.DrugBagID2 = DrugBagID2;
    }
    public String getDrugBagID2()
    {
        return this.DrugBagID2;
    }
}
