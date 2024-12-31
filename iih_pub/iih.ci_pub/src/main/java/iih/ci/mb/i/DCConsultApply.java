package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCConsultApply
{
    @JsonProperty(value = "OrderID")
    private Integer OrderID;
    @JsonProperty(value = "PatientId")
    private String PatientId;
    @JsonProperty(value = "VisitId")
    private String VisitId;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "Sex")
    private String Sex;
    @JsonProperty(value = "Age")
    private String Age;
    @JsonProperty(value = "ApplyNo")
    private Integer ApplyNo;
    @JsonProperty(value = "ApplyDate")
    private String ApplyDate;
    @JsonProperty(value = "ApplyDeptCode")
    private String ApplyDeptCode;
    @JsonProperty(value = "ApplyDeptName")
    private String ApplyDeptName;
    @JsonProperty(value = "ApplyWardCode")
    private String ApplyWardCode;
    @JsonProperty(value = "ApplyWardName")
    private String ApplyWardName;
    @JsonProperty(value = "ApplyDoctorCode")
    private String ApplyDoctorCode;
    @JsonProperty(value = "ApplyDoctorName")
    private String ApplyDoctorName;
    @JsonProperty(value = "ConsultDeptCode")
    private String ConsultDeptCode;
    @JsonProperty(value = "ConsultDeptName")
    private String ConsultDeptName;
    @JsonProperty(value = "ConsultApplyDate")
    private String ConsultApplyDate;
    @JsonProperty(value = "ConsultPurpose")
    private String ConsultPurpose;
    @JsonProperty(value = "MRSummary")
    private String MRSummary;
    @JsonProperty(value = "OrderSn")
    private String OrderSn;
    @JsonProperty(value = "OrderContent")
    private String OrderContent;
    @JsonProperty(value = "ConsultTypeCode")
    private String ConsultTypeCode;
    @JsonProperty(value = "ConsultTypeName")
    private String ConsultTypeName;
    @JsonProperty(value = "ConsultStatusCode")
    private String ConsultStatusCode;
    @JsonProperty(value = "ConsultStatusName")
    private String ConsultStatusName;
    @JsonProperty(value = "ConsultDate")
    private String ConsultDate;
    @JsonProperty(value = "RevertDeptCode")
    private String RevertDeptCode;
    @JsonProperty(value = "RevertDeptName")
    private String RevertDeptName;
    @JsonProperty(value = "RevertDoctorCode")
    private String RevertDoctorCode;
    @JsonProperty(value = "RevertDoctorName")
    private String RevertDoctorName;
    @JsonProperty(value = "RevertContent")
    private String RevertContent;
    @JsonProperty(value = "OrderContentCode")
    private String OrderContentCode;
    @JsonProperty(value = "RevertNo")
    private String RevertNo;
    @JsonProperty(value = "BedNo")
    private String BedNo;
    @JsonProperty(value = "InPatientNo")
    private String InPatientNo;
    @JsonProperty(value = "Attentder")
    private String Attentder;
    @JsonProperty(value = "AttentderName")
    private String AttentderName;
    @JsonProperty(value = "RevertDate")
    private String RevertDate;

    public void setOrderID(Integer OrderID)
    {
        this.OrderID = OrderID;
    }
    public Integer getOrderID()
    {
        return this.OrderID;
    }
    public void setPatientId(String PatientId)
    {
        this.PatientId = PatientId;
    }
    public String getPatientId()
    {
        return this.PatientId;
    }
    public void setVisitId(String VisitId)
    {
        this.VisitId = VisitId;
    }
    public String getVisitId()
    {
        return this.VisitId;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
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
    public void setApplyNo(Integer ApplyNo)
    {
        this.ApplyNo = ApplyNo;
    }
    public Integer getApplyNo()
    {
        return this.ApplyNo;
    }
    public void setApplyDate(String ApplyDate)
    {
        this.ApplyDate = ApplyDate;
    }
    public String getApplyDate()
    {
        return this.ApplyDate;
    }
    public void setApplyDeptCode(String ApplyDeptCode)
    {
        this.ApplyDeptCode = ApplyDeptCode;
    }
    public String getApplyDeptCode()
    {
        return this.ApplyDeptCode;
    }
    public void setApplyDeptName(String ApplyDeptName)
    {
        this.ApplyDeptName = ApplyDeptName;
    }
    public String getApplyDeptName()
    {
        return this.ApplyDeptName;
    }
    public void setApplyWardCode(String ApplyWardCode)
    {
        this.ApplyWardCode = ApplyWardCode;
    }
    public String getApplyWardCode()
    {
        return this.ApplyWardCode;
    }
    public void setApplyWardName(String ApplyWardName)
    {
        this.ApplyWardName = ApplyWardName;
    }
    public String getApplyWardName()
    {
        return this.ApplyWardName;
    }
    public void setApplyDoctorCode(String ApplyDoctorCode)
    {
        this.ApplyDoctorCode = ApplyDoctorCode;
    }
    public String getApplyDoctorCode()
    {
        return this.ApplyDoctorCode;
    }
    public void setApplyDoctorName(String ApplyDoctorName)
    {
        this.ApplyDoctorName = ApplyDoctorName;
    }
    public String getApplyDoctorName()
    {
        return this.ApplyDoctorName;
    }
    public void setConsultDeptCode(String ConsultDeptCode)
    {
        this.ConsultDeptCode = ConsultDeptCode;
    }
    public String getConsultDeptCode()
    {
        return this.ConsultDeptCode;
    }
    public void setConsultDeptName(String ConsultDeptName)
    {
        this.ConsultDeptName = ConsultDeptName;
    }
    public String getConsultDeptName()
    {
        return this.ConsultDeptName;
    }
    public void setConsultApplyDate(String ConsultApplyDate)
    {
        this.ConsultApplyDate = ConsultApplyDate;
    }
    public String getConsultApplyDate()
    {
        return this.ConsultApplyDate;
    }
    public void setConsultPurpose(String ConsultPurpose)
    {
        this.ConsultPurpose = ConsultPurpose;
    }
    public String getConsultPurpose()
    {
        return this.ConsultPurpose;
    }
    public void setMRSummary(String MRSummary)
    {
        this.MRSummary = MRSummary;
    }
    public String getMRSummary()
    {
        return this.MRSummary;
    }
    public void setOrderSn(String OrderSn)
    {
        this.OrderSn = OrderSn;
    }
    public String getOrderSn()
    {
        return this.OrderSn;
    }
    public void setOrderContent(String OrderContent)
    {
        this.OrderContent = OrderContent;
    }
    public String getOrderContent()
    {
        return this.OrderContent;
    }
    public void setConsultTypeCode(String ConsultTypeCode)
    {
        this.ConsultTypeCode = ConsultTypeCode;
    }
    public String getConsultTypeCode()
    {
        return this.ConsultTypeCode;
    }
    public void setConsultTypeName(String ConsultTypeName)
    {
        this.ConsultTypeName = ConsultTypeName;
    }
    public String getConsultTypeName()
    {
        return this.ConsultTypeName;
    }
    public void setConsultStatusCode(String ConsultStatusCode)
    {
        this.ConsultStatusCode = ConsultStatusCode;
    }
    public String getConsultStatusCode()
    {
        return this.ConsultStatusCode;
    }
    public void setConsultStatusName(String ConsultStatusName)
    {
        this.ConsultStatusName = ConsultStatusName;
    }
    public String getConsultStatusName()
    {
        return this.ConsultStatusName;
    }
    public void setConsultDate(String ConsultDate)
    {
        this.ConsultDate = ConsultDate;
    }
    public String getConsultDate()
    {
        return this.ConsultDate;
    }
    public void setRevertDeptCode(String RevertDeptCode)
    {
        this.RevertDeptCode = RevertDeptCode;
    }
    public String getRevertDeptCode()
    {
        return this.RevertDeptCode;
    }
    public void setRevertDeptName(String RevertDeptName)
    {
        this.RevertDeptName = RevertDeptName;
    }
    public String getRevertDeptName()
    {
        return this.RevertDeptName;
    }
    public void setRevertDoctorCode(String RevertDoctorCode)
    {
        this.RevertDoctorCode = RevertDoctorCode;
    }
    public String getRevertDoctorCode()
    {
        return this.RevertDoctorCode;
    }
    public void setRevertDoctorName(String RevertDoctorName)
    {
        this.RevertDoctorName = RevertDoctorName;
    }
    public String getRevertDoctorName()
    {
        return this.RevertDoctorName;
    }
    public void setRevertContent(String RevertContent)
    {
        this.RevertContent = RevertContent;
    }
    public String getRevertContent()
    {
        return this.RevertContent;
    }
    public void setOrderContentCode(String OrderContentCode)
    {
        this.OrderContentCode = OrderContentCode;
    }
    public String getOrderContentCode()
    {
        return this.OrderContentCode;
    }
    public void setRevertNo(String RevertNo)
    {
        this.RevertNo = RevertNo;
    }
    public String getRevertNo()
    {
        return this.RevertNo;
    }
    public void setBedNo(String BedNo)
    {
        this.BedNo = BedNo;
    }
    public String getBedNo()
    {
        return this.BedNo;
    }
    public void setInPatientNo(String InPatientNo)
    {
        this.InPatientNo = InPatientNo;
    }
    public String getInPatientNo()
    {
        return this.InPatientNo;
    }
    public void setAttentder(String Attentder)
    {
        this.Attentder = Attentder;
    }
    public String getAttentder()
    {
        return this.Attentder;
    }
    public void setAttentderName(String AttentderName)
    {
        this.AttentderName = AttentderName;
    }
    public String getAttentderName()
    {
        return this.AttentderName;
    }
    public void setRevertDate(String RevertDate)
    {
        this.RevertDate = RevertDate;
    }
    public String getRevertDate()
    {
        return this.RevertDate;
    }
}
