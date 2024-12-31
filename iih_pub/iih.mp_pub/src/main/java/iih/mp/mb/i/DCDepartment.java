package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDepartment
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "ParentDeptID")
    private String ParentDeptID;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DeptCode_Real")
    private String DeptCode_Real;
    @JsonProperty(value = "StaInfo")
    private DCNurseStationTodayStatistics StaInfo;
    @JsonProperty(value = "IsVisual")
    private Boolean IsVisual;
    @JsonProperty(value = "OrgID")
    private String OrgID;
    @JsonProperty(value = "GrpID")
    private String GrpID;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setParentDeptID(String ParentDeptID)
    {
        this.ParentDeptID = ParentDeptID;
    }
    public String getParentDeptID()
    {
        return this.ParentDeptID;
    }
    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDeptCode_Real(String DeptCode_Real)
    {
        this.DeptCode_Real = DeptCode_Real;
    }
    public String getDeptCode_Real()
    {
        return this.DeptCode_Real;
    }
    public void setStaInfo(DCNurseStationTodayStatistics StaInfo)
    {
        this.StaInfo = StaInfo;
    }
    public DCNurseStationTodayStatistics getStaInfo()
    {
        return this.StaInfo;
    }
    public void setIsVisual(Boolean IsVisual)
    {
        this.IsVisual = IsVisual;
    }
    public Boolean getIsVisual()
    {
        return this.IsVisual;
    }
	public String getOrgID() {
		return OrgID;
	}
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}
	public String getGrpID() {
		return GrpID;
	}
	public void setGrpID(String grpID) {
		GrpID = grpID;
	}    
}