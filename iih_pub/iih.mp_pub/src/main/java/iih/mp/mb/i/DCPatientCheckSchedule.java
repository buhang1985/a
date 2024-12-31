package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientCheckSchedule
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "PatientVisitID")
    private String PatientVisitID;
    @JsonProperty(value = "PatientBedNo")
    private String PatientBedNo;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "PatientSex")
    private String PatientSex;
    @JsonProperty(value = "PatientAge")
    private String PatientAge;
    @JsonProperty(value = "ZipCode")
    private String ZipCode;
    @JsonProperty(value = "MailingAddress")
    private String MailingAddress;
    @JsonProperty(value = "NamePhonetic")
    private String NamePhonetic;
    @JsonProperty(value = "PatientIdentityTitle")
    private String PatientIdentityTitle;
    @JsonProperty(value = "PatientChargeType")
    private String PatientChargeType;
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "Position")
    private String Position;
    @JsonProperty(value = "ApplyDoctorName")
    private String ApplyDoctorName;
    @JsonProperty(value = "ApplyDate")
    private String ApplyDate;
    @JsonProperty(value = "IsBedSide")
    private Boolean IsBedSide;
    @JsonProperty(value = "IsEmergy")
    private Boolean IsEmergy;
    @JsonProperty(value = "Announcements")
    private String Announcements;
    @JsonProperty(value = "Purpose")
    private String Purpose;
    @JsonProperty(value = "ZhengZhuang")
    private String ZhengZhuang;
    @JsonProperty(value = "TiZheng")
    private String TiZheng;
    @JsonProperty(value = "Diagnosis")
    private String Diagnosis;
    @JsonProperty(value = "OtherDiagonsis")
    private String OtherDiagonsis;
    @JsonProperty(value = "AssociateTestResult")
    private String AssociateTestResult;
    @JsonProperty(value = "Summary")
    private String Summary;
    @JsonProperty(value = "ScheduledDate")
    private String ScheduledDate;
    @JsonProperty(value = "Charges")
    private String Charges;
    @JsonProperty(value = "Costs")
    private String Costs;
    @JsonProperty(value = "ReqDeptCode")
    private String ReqDeptCode;
    @JsonProperty(value = "PatientSource")
    private String PatientSource;
    @JsonProperty(value = "PerformedBy")
    private String PerformedBy;
    @JsonProperty(value = "ItemList")
    private ArrayOfDCPatientCheckItem ItemList;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setPatientVisitID(String PatientVisitID)
    {
        this.PatientVisitID = PatientVisitID;
    }
    public String getPatientVisitID()
    {
        return this.PatientVisitID;
    }
    public void setPatientBedNo(String PatientBedNo)
    {
        this.PatientBedNo = PatientBedNo;
    }
    public String getPatientBedNo()
    {
        return this.PatientBedNo;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setPatientSex(String PatientSex)
    {
        this.PatientSex = PatientSex;
    }
    public String getPatientSex()
    {
        return this.PatientSex;
    }
    public void setPatientAge(String PatientAge)
    {
        this.PatientAge = PatientAge;
    }
    public String getPatientAge()
    {
        return this.PatientAge;
    }
    public void setZipCode(String ZipCode)
    {
        this.ZipCode = ZipCode;
    }
    public String getZipCode()
    {
        return this.ZipCode;
    }
    public void setMailingAddress(String MailingAddress)
    {
        this.MailingAddress = MailingAddress;
    }
    public String getMailingAddress()
    {
        return this.MailingAddress;
    }
    public void setNamePhonetic(String NamePhonetic)
    {
        this.NamePhonetic = NamePhonetic;
    }
    public String getNamePhonetic()
    {
        return this.NamePhonetic;
    }
    public void setPatientIdentityTitle(String PatientIdentityTitle)
    {
        this.PatientIdentityTitle = PatientIdentityTitle;
    }
    public String getPatientIdentityTitle()
    {
        return this.PatientIdentityTitle;
    }
    public void setPatientChargeType(String PatientChargeType)
    {
        this.PatientChargeType = PatientChargeType;
    }
    public String getPatientChargeType()
    {
        return this.PatientChargeType;
    }
    public void setType(String Type)
    {
        this.Type = Type;
    }
    public String getType()
    {
        return this.Type;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setPosition(String Position)
    {
        this.Position = Position;
    }
    public String getPosition()
    {
        return this.Position;
    }
    public void setApplyDoctorName(String ApplyDoctorName)
    {
        this.ApplyDoctorName = ApplyDoctorName;
    }
    public String getApplyDoctorName()
    {
        return this.ApplyDoctorName;
    }
    public void setApplyDate(String ApplyDate)
    {
        this.ApplyDate = ApplyDate;
    }
    public String getApplyDate()
    {
        return this.ApplyDate;
    }
    public void setIsBedSide(Boolean IsBedSide)
    {
        this.IsBedSide = IsBedSide;
    }
    public Boolean getIsBedSide()
    {
        return this.IsBedSide;
    }
    public void setIsEmergy(Boolean IsEmergy)
    {
        this.IsEmergy = IsEmergy;
    }
    public Boolean getIsEmergy()
    {
        return this.IsEmergy;
    }
    public void setAnnouncements(String Announcements)
    {
        this.Announcements = Announcements;
    }
    public String getAnnouncements()
    {
        return this.Announcements;
    }
    public void setPurpose(String Purpose)
    {
        this.Purpose = Purpose;
    }
    public String getPurpose()
    {
        return this.Purpose;
    }
    public void setZhengZhuang(String ZhengZhuang)
    {
        this.ZhengZhuang = ZhengZhuang;
    }
    public String getZhengZhuang()
    {
        return this.ZhengZhuang;
    }
    public void setTiZheng(String TiZheng)
    {
        this.TiZheng = TiZheng;
    }
    public String getTiZheng()
    {
        return this.TiZheng;
    }
    public void setDiagnosis(String Diagnosis)
    {
        this.Diagnosis = Diagnosis;
    }
    public String getDiagnosis()
    {
        return this.Diagnosis;
    }
    public void setOtherDiagonsis(String OtherDiagonsis)
    {
        this.OtherDiagonsis = OtherDiagonsis;
    }
    public String getOtherDiagonsis()
    {
        return this.OtherDiagonsis;
    }
    public void setAssociateTestResult(String AssociateTestResult)
    {
        this.AssociateTestResult = AssociateTestResult;
    }
    public String getAssociateTestResult()
    {
        return this.AssociateTestResult;
    }
    public void setSummary(String Summary)
    {
        this.Summary = Summary;
    }
    public String getSummary()
    {
        return this.Summary;
    }
    public void setScheduledDate(String ScheduledDate)
    {
        this.ScheduledDate = ScheduledDate;
    }
    public String getScheduledDate()
    {
        return this.ScheduledDate;
    }
    public void setCharges(String Charges)
    {
        this.Charges = Charges;
    }
    public String getCharges()
    {
        return this.Charges;
    }
    public void setCosts(String Costs)
    {
        this.Costs = Costs;
    }
    public String getCosts()
    {
        return this.Costs;
    }
    public void setReqDeptCode(String ReqDeptCode)
    {
        this.ReqDeptCode = ReqDeptCode;
    }
    public String getReqDeptCode()
    {
        return this.ReqDeptCode;
    }
    public void setPatientSource(String PatientSource)
    {
        this.PatientSource = PatientSource;
    }
    public String getPatientSource()
    {
        return this.PatientSource;
    }
    public void setPerformedBy(String PerformedBy)
    {
        this.PerformedBy = PerformedBy;
    }
    public String getPerformedBy()
    {
        return this.PerformedBy;
    }
    public void setItemList(ArrayOfDCPatientCheckItem ItemList)
    {
        this.ItemList = ItemList;
    }
    public ArrayOfDCPatientCheckItem getItemList()
    {
        return this.ItemList;
    }
}
