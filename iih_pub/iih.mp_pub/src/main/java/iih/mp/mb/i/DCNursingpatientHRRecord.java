package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNursingpatientHRRecord
{
    @JsonProperty(value = "BendNum")
    private String BendNum;
    @JsonProperty(value = "DepartmentID")
    private String DepartmentID;
    @JsonProperty(value = "H3")
    private String H3;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "H15")
    private String H15;
    @JsonProperty(value = "H7")
    private String H7;
    @JsonProperty(value = "H11")
    private String H11;
    @JsonProperty(value = "H19")
    private String H19;
    @JsonProperty(value = "H23")
    private String H23;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "HappenTime")
    private String HappenTime;
    @JsonProperty(value = "Info1")
    private String Info1;
    @JsonProperty(value = "Info2")
    private String Info2;
    @JsonProperty(value = "Flag")
    private String Flag;
    @JsonProperty(value = "Age")
    private String Age;

    public void setBendNum(String BendNum)
    {
        this.BendNum = BendNum;
    }
    public String getBendNum()
    {
        return this.BendNum;
    }
    public void setDepartmentID(String DepartmentID)
    {
        this.DepartmentID = DepartmentID;
    }
    public String getDepartmentID()
    {
        return this.DepartmentID;
    }
    public void setH3(String H3)
    {
        this.H3 = H3;
    }
    public String getH3()
    {
        return this.H3;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setH15(String H15)
    {
        this.H15 = H15;
    }
    public String getH15()
    {
        return this.H15;
    }
    public void setH7(String H7)
    {
        this.H7 = H7;
    }
    public String getH7()
    {
        return this.H7;
    }
    public void setH11(String H11)
    {
        this.H11 = H11;
    }
    public String getH11()
    {
        return this.H11;
    }
    public void setH19(String H19)
    {
        this.H19 = H19;
    }
    public String getH19()
    {
        return this.H19;
    }
    public void setH23(String H23)
    {
        this.H23 = H23;
    }
    public String getH23()
    {
        return this.H23;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setHappenTime(String HappenTime)
    {
        this.HappenTime = HappenTime;
    }
    public String getHappenTime()
    {
        return this.HappenTime;
    }
    public void setInfo1(String Info1)
    {
        this.Info1 = Info1;
    }
    public String getInfo1()
    {
        return this.Info1;
    }
    public void setInfo2(String Info2)
    {
        this.Info2 = Info2;
    }
    public String getInfo2()
    {
        return this.Info2;
    }
    public void setFlag(String Flag)
    {
        this.Flag = Flag;
    }
    public String getFlag()
    {
        return this.Flag;
    }
    public void setAge(String Age)
    {
        this.Age = Age;
    }
    public String getAge()
    {
        return this.Age;
    }
}
