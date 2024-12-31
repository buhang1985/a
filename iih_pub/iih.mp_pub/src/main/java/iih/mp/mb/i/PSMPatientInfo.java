package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMPatientInfo
{
    @JsonProperty(value = "PatientId")
    private String PatientId;
    @JsonProperty(value = "Times")
    private String Times;
    @JsonProperty(value = "InPatientNo")
    private String InPatientNo;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "Sex")
    private String Sex;
    @JsonProperty(value = "Age")
    private String Age;
    @JsonProperty(value = "Dept")
    private String Dept;
    @JsonProperty(value = "Ward")
    private String Ward;
    @JsonProperty(value = "ResponceType")
    private String ResponceType;
    @JsonProperty(value = "AdmissDate")
    private String AdmissDate;
    @JsonProperty(value = "DiagName")
    private String DiagName;
    @JsonProperty(value = "bedcode")
    private String bedcode;
    @JsonProperty(value = "SvcLocationId")//床位所属病区
    private String SvcLocationId;
    
    
    
    /**
	 * @return 
	 */
	public String getSvcLocationId() {
		return SvcLocationId;
	}
	/**
	 * @param 
	 */
	public void setSvcLocationId(String svcLocationId) {
		SvcLocationId = svcLocationId;
	}
	
	/**
	 * @return
	 */
	public String getBedcode() {
		return bedcode;
	}
	/**
	 * @param 
	 */
	public void setBedcode(String bedcode) {
		this.bedcode = bedcode;
	}
	public void setPatientId(String PatientId)
    {
        this.PatientId = PatientId;
    }
    public String getPatientId()
    {
        return this.PatientId;
    }
    public void setTimes(String Times)
    {
        this.Times = Times;
    }
    public String getTimes()
    {
        return this.Times;
    }
    public void setInPatientNo(String InPatientNo)
    {
        this.InPatientNo = InPatientNo;
    }
    public String getInPatientNo()
    {
        return this.InPatientNo;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setSex(String Sex)
    {
        this.Sex = Sex;
    }
    public String getSex()
    {
        return this.Sex;
    }
    public void setAge(String Age)
    {
        this.Age = Age;
    }
    public String getAge()
    {
        return this.Age;
    }
    public void setDept(String Dept)
    {
        this.Dept = Dept;
    }
    public String getDept()
    {
        return this.Dept;
    }
    public void setWard(String Ward)
    {
        this.Ward = Ward;
    }
    public String getWard()
    {
        return this.Ward;
    }
    public void setResponceType(String ResponceType)
    {
        this.ResponceType = ResponceType;
    }
    public String getResponceType()
    {
        return this.ResponceType;
    }
    public void setAdmissDate(String AdmissDate)
    {
        this.AdmissDate = AdmissDate;
    }
    public String getAdmissDate()
    {
        return this.AdmissDate;
    }
    public void setDiagName(String DiagName)
    {
        this.DiagName = DiagName;
    }
    public String getDiagName()
    {
        return this.DiagName;
    }
}
