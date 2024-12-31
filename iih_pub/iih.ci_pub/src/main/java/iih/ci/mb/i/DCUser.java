package iih.ci.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfInt;

public class DCUser
{
    @JsonProperty(value = "ModulePermission")
    private ArrayOfInt ModulePermission;
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "Certification")
    private DCUserCertification Certification;
    @JsonProperty(value = "CertificationRequired")
    private Boolean CertificationRequired;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "UserName")
    private String UserName;
    @JsonProperty(value = "Password")
    private String Password;
    @JsonProperty(value = "IdentityCard")
    private String IdentityCard;
    @JsonProperty(value = "Sex")
    private String Sex;
    @JsonProperty(value = "Nation")
    private String Nation;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "LevelCode")
    private String LevelCode;
    @JsonProperty(value = "ImageUri")
    private String ImageUri;
    @JsonProperty(value = "UserRole")
    private Integer UserRole;
    @JsonProperty(value = "SursurgeryClass")
    private String SursurgeryClass;
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DELETE_FLAG")
    private String DELETE_FLAG;
    @JsonProperty(value = "flag")
    private Integer flag;
    @JsonProperty(value = "Dept_IDS")
    private String Dept_IDS;

    public void setModulePermission(ArrayOfInt ModulePermission)
    {
        this.ModulePermission = ModulePermission;
    }
    public ArrayOfInt getModulePermission()
    {
        return this.ModulePermission;
    }
    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setCertification(DCUserCertification Certification)
    {
        this.Certification = Certification;
    }
    public DCUserCertification getCertification()
    {
        return this.Certification;
    }
    public void setCertificationRequired(Boolean CertificationRequired)
    {
        this.CertificationRequired = CertificationRequired;
    }
    public Boolean getCertificationRequired()
    {
        return this.CertificationRequired;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public String getUserName()
    {
        return this.UserName;
    }
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public void setIdentityCard(String IdentityCard)
    {
        this.IdentityCard = IdentityCard;
    }
    public String getIdentityCard()
    {
        return this.IdentityCard;
    }
    public void setSex(String Sex)
    {
        this.Sex = Sex;
    }
    public String getSex()
    {
        return this.Sex;
    }
    public void setNation(String Nation)
    {
        this.Nation = Nation;
    }
    public String getNation()
    {
        return this.Nation;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setLevelCode(String LevelCode)
    {
        this.LevelCode = LevelCode;
    }
    public String getLevelCode()
    {
        return this.LevelCode;
    }
    public void setImageUri(String ImageUri)
    {
        this.ImageUri = ImageUri;
    }
    public String getImageUri()
    {
        return this.ImageUri;
    }
    public void setUserRole(Integer UserRole)
    {
        this.UserRole = UserRole;
    }
    public Integer getUserRole()
    {
        return this.UserRole;
    }
    public void setSursurgeryClass(String SursurgeryClass)
    {
        this.SursurgeryClass = SursurgeryClass;
    }
    public String getSursurgeryClass()
    {
        return this.SursurgeryClass;
    }
    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDELETE_FLAG(String DELETE_FLAG)
    {
        this.DELETE_FLAG = DELETE_FLAG;
    }
    public String getDELETE_FLAG()
    {
        return this.DELETE_FLAG;
    }
    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }
    public Integer getFlag()
    {
        return this.flag;
    }
    public void setDept_IDS(String Dept_IDS)
    {
        this.Dept_IDS = Dept_IDS;
    }
    public String getDept_IDS()
    {
        return this.Dept_IDS;
    }
}
