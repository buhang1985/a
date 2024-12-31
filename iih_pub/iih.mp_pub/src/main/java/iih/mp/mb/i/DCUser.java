package iih.mp.mb.i;


import org.codehaus.jackson.annotate.JsonProperty;

public class DCUser
{
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
    @JsonProperty(value = "ImageUri")
    private String ImageUri;
    @JsonProperty(value = "UserRole")
    private Integer UserRole;
    @JsonProperty(value = "SursurgeryClass")
    private String SursurgeryClass;
    @JsonProperty(value = "WardCode")
    private String WardCode;
    @JsonProperty(value = "WardName")
    private String WardName;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "ModulePermission")
    private ArrayOfInt ModulePermission;
    @JsonProperty(value = "Modules")
    private ArrayOfDCModule Modules;
    private Integer LoginResult;

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
    public void setWardCode(String WardCode)
    {
        this.WardCode = WardCode;
    }
    public String getWardCode()
    {
        return this.WardCode;
    }
    public void setWardName(String WardName)
    {
        this.WardName = WardName;
    }
    public String getWardName()
    {
        return this.WardName;
    }
    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
    public void setModulePermission(ArrayOfInt ModulePermission)
    {
        this.ModulePermission = ModulePermission;
    }
    public ArrayOfInt getModulePermission()
    {
        return this.ModulePermission;
    }
    public void setModules(ArrayOfDCModule Modules)
    {
        this.Modules = Modules;
    }
    public ArrayOfDCModule getModules()
    {
        return this.Modules;
    }
	public Integer getLoginResult() {
		return LoginResult;
	}
	public void setLoginResult(Integer loginResult) {
		LoginResult = loginResult;
	}
}
