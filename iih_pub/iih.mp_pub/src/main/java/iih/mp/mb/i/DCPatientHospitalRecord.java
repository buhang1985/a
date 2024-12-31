package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientHospitalRecord
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "HID")
    private String HID;
    @JsonProperty(value = "CaseID")
    private String CaseID;
    @JsonProperty(value = "SubID")
    private String SubID;
    @JsonProperty(value = "ClinicID")
    private String ClinicID;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "DischargeDeptName")
    private String DischargeDeptName;
    @JsonProperty(value = "WardCode")
    private String WardCode;
    @JsonProperty(value = "WardName")
    private String WardName;
    @JsonProperty(value = "BedNo")
    private String BedNo;
    @JsonProperty(value = "DoctorInChargeCode")
    private String DoctorInChargeCode;
    @JsonProperty(value = "DoctorInCharge")
    private String DoctorInCharge;
    @JsonProperty(value = "NurseInChargeCode")
    private String NurseInChargeCode;
    @JsonProperty(value = "NurseInCharge")
    private String NurseInCharge;
    @JsonProperty(value = "Diagnosis")
    private String Diagnosis;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "NamePhonetic")
    private String NamePhonetic;
    @JsonProperty(value = "Nation")
    private String Nation;
    @JsonProperty(value = "Sex")
    private String Sex;
    @JsonProperty(value = "BirthDay")
    private String BirthDay;
    @JsonProperty(value = "Age")
    private String Age;
    @JsonProperty(value = "EnterDate")
    private String EnterDate;
    @JsonProperty(value = "ExitDate")
    private String ExitDate;
    @JsonProperty(value = "EnterDeptDate")
    private String EnterDeptDate;
    @JsonProperty(value = "MedicalInsuranceID")
    private String MedicalInsuranceID;
    @JsonProperty(value = "IdentityType")
    private String IdentityType;
    @JsonProperty(value = "Company")
    private String Company;
    @JsonProperty(value = "Phone")
    private String Phone;
    @JsonProperty(value = "Address")
    private String Address;
    @JsonProperty(value = "ZipCode")
    private String ZipCode;
    @JsonProperty(value = "LinkManName")
    private String LinkManName;
    @JsonProperty(value = "LinkManRelation")
    private String LinkManRelation;
    @JsonProperty(value = "LinkManPhone")
    private String LinkManPhone;
    @JsonProperty(value = "IdentityNumber")
    private String IdentityNumber;
    @JsonProperty(value = "Payment")
    private String Payment;
    @JsonProperty(value = "CurrentState")
    private String CurrentState;
    @JsonProperty(value = "CareLevel")
    private String CareLevel;
    @JsonProperty(value = "PrePayments")
    private String PrePayments;
    @JsonProperty(value = "TotalCost")
    private String TotalCost;
    @JsonProperty(value = "TotalPayments")
    private String TotalPayments;
    @JsonProperty(value = "BalanceMoney")
    private String BalanceMoney;
    @JsonProperty(value = "InHosDay")
    private Integer InHosDay;
    @JsonProperty(value = "IsWaiting")
    private Integer IsWaiting;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "DocAdivce")
    private String DocAdivce;
    @JsonProperty(value = "Frequency")
    private String Frequency;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "UseName")
    private String UseName;
    @JsonProperty(value = "CombNo")
    private String CombNo;
    @JsonProperty(value = "UseTime")
    private String UseTime;
    @JsonProperty(value = "GroupStringString")
    private String GroupStringString;
    @JsonProperty(value = "Grave")
    private String Grave;
    @JsonProperty(value = "ISAllergy")
    private String ISAllergy;
    @JsonProperty(value = "ISArrearage")
    private String ISArrearage;
    @JsonProperty(value = "Ward_id")
    private String Ward_id;
    @JsonProperty(value = "Warning")
    private String Warning;
    @JsonProperty(value = "Risk")
    private String Risk;
    @JsonProperty(value = "Other")
    private String Other;
    @JsonProperty(value = "OverFee")
    private String OverFee;
    @JsonProperty(value = "OpFlag")
    private String OpFlag;
    @JsonProperty(value = "ClinicPathFlag")
    private String ClinicPathFlag;
    @JsonProperty(value = "PaymentType")
    private String PaymentType;
    @JsonProperty(value = "Settled")
    private String Settled;
    @JsonProperty(value = "UnSettled")
    private String UnSettled;
    @JsonProperty(value = "isoperation")
    private String isoperation;
    @JsonProperty(value = "bloodtype")
    private String bloodtype;
    @JsonProperty(value = "DiagnsisHistoryList")
    private ArrayOfDCPatientDiagnosis DiagnsisHistoryList;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setHID(String HID)
    {
        this.HID = HID;
    }
    public String getHID()
    {
        return this.HID;
    }
    public void setCaseID(String CaseID)
    {
        this.CaseID = CaseID;
    }
    public String getCaseID()
    {
        return this.CaseID;
    }
    public void setSubID(String SubID)
    {
        this.SubID = SubID;
    }
    public String getSubID()
    {
        return this.SubID;
    }
    public void setClinicID(String ClinicID)
    {
        this.ClinicID = ClinicID;
    }
    public String getClinicID()
    {
        return this.ClinicID;
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
    public void setDischargeDeptName(String DischargeDeptName)
    {
        this.DischargeDeptName = DischargeDeptName;
    }
    public String getDischargeDeptName()
    {
        return this.DischargeDeptName;
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
    public void setBedNo(String BedNo)
    {
        this.BedNo = BedNo;
    }
    public String getBedNo()
    {
        return this.BedNo;
    }
    public void setDoctorInChargeCode(String DoctorInChargeCode)
    {
        this.DoctorInChargeCode = DoctorInChargeCode;
    }
    public String getDoctorInChargeCode()
    {
        return this.DoctorInChargeCode;
    }
    public void setDoctorInCharge(String DoctorInCharge)
    {
        this.DoctorInCharge = DoctorInCharge;
    }
    public String getDoctorInCharge()
    {
        return this.DoctorInCharge;
    }
    public void setNurseInChargeCode(String NurseInChargeCode)
    {
        this.NurseInChargeCode = NurseInChargeCode;
    }
    public String getNurseInChargeCode()
    {
        return this.NurseInChargeCode;
    }
    public void setNurseInCharge(String NurseInCharge)
    {
        this.NurseInCharge = NurseInCharge;
    }
    public String getNurseInCharge()
    {
        return this.NurseInCharge;
    }
    public void setDiagnosis(String Diagnosis)
    {
        this.Diagnosis = Diagnosis;
    }
    public String getDiagnosis()
    {
        return this.Diagnosis;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setNamePhonetic(String NamePhonetic)
    {
        this.NamePhonetic = NamePhonetic;
    }
    public String getNamePhonetic()
    {
        return this.NamePhonetic;
    }
    public void setNation(String Nation)
    {
        this.Nation = Nation;
    }
    public String getNation()
    {
        return this.Nation;
    }
    public void setSex(String Sex)
    {
        this.Sex = Sex;
    }
    public String getSex()
    {
        return this.Sex;
    }
    public void setBirthDay(String BirthDay)
    {
        this.BirthDay = BirthDay;
    }
    public String getBirthDay()
    {
        return this.BirthDay;
    }
    public void setAge(String Age)
    {
        this.Age = Age;
    }
    public String getAge()
    {
        return this.Age;
    }
    public void setEnterDate(String EnterDate)
    {
        this.EnterDate = EnterDate;
    }
    public String getEnterDate()
    {
        return this.EnterDate;
    }
    public void setExitDate(String ExitDate)
    {
        this.ExitDate = ExitDate;
    }
    public String getExitDate()
    {
        return this.ExitDate;
    }
    public void setEnterDeptDate(String EnterDeptDate)
    {
        this.EnterDeptDate = EnterDeptDate;
    }
    public String getEnterDeptDate()
    {
        return this.EnterDeptDate;
    }
    public void setMedicalInsuranceID(String MedicalInsuranceID)
    {
        this.MedicalInsuranceID = MedicalInsuranceID;
    }
    public String getMedicalInsuranceID()
    {
        return this.MedicalInsuranceID;
    }
    public void setIdentityType(String IdentityType)
    {
        this.IdentityType = IdentityType;
    }
    public String getIdentityType()
    {
        return this.IdentityType;
    }
    public void setCompany(String Company)
    {
        this.Company = Company;
    }
    public String getCompany()
    {
        return this.Company;
    }
    public void setPhone(String Phone)
    {
        this.Phone = Phone;
    }
    public String getPhone()
    {
        return this.Phone;
    }
    public void setAddress(String Address)
    {
        this.Address = Address;
    }
    public String getAddress()
    {
        return this.Address;
    }
    public void setZipCode(String ZipCode)
    {
        this.ZipCode = ZipCode;
    }
    public String getZipCode()
    {
        return this.ZipCode;
    }
    public void setLinkManName(String LinkManName)
    {
        this.LinkManName = LinkManName;
    }
    public String getLinkManName()
    {
        return this.LinkManName;
    }
    public void setLinkManRelation(String LinkManRelation)
    {
        this.LinkManRelation = LinkManRelation;
    }
    public String getLinkManRelation()
    {
        return this.LinkManRelation;
    }
    public void setLinkManPhone(String LinkManPhone)
    {
        this.LinkManPhone = LinkManPhone;
    }
    public String getLinkManPhone()
    {
        return this.LinkManPhone;
    }
    public void setIdentityNumber(String IdentityNumber)
    {
        this.IdentityNumber = IdentityNumber;
    }
    public String getIdentityNumber()
    {
        return this.IdentityNumber;
    }
    public void setPayment(String Payment)
    {
        this.Payment = Payment;
    }
    public String getPayment()
    {
        return this.Payment;
    }
    public void setCurrentState(String CurrentState)
    {
        this.CurrentState = CurrentState;
    }
    public String getCurrentState()
    {
        return this.CurrentState;
    }
    public void setCareLevel(String CareLevel)
    {
        this.CareLevel = CareLevel;
    }
    public String getCareLevel()
    {
        return this.CareLevel;
    }
    public void setPrePayments(String PrePayments)
    {
        this.PrePayments = PrePayments;
    }
    public String getPrePayments()
    {
        return this.PrePayments;
    }
    public void setTotalCost(String TotalCost)
    {
        this.TotalCost = TotalCost;
    }
    public String getTotalCost()
    {
        return this.TotalCost;
    }
    public void setTotalPayments(String TotalPayments)
    {
        this.TotalPayments = TotalPayments;
    }
    public String getTotalPayments()
    {
        return this.TotalPayments;
    }
    public void setBalanceMoney(String BalanceMoney)
    {
        this.BalanceMoney = BalanceMoney;
    }
    public String getBalanceMoney()
    {
        return this.BalanceMoney;
    }
    public void setInHosDay(Integer InHosDay)
    {
        this.InHosDay = InHosDay;
    }
    public Integer getInHosDay()
    {
        return this.InHosDay;
    }
    public void setIsWaiting(Integer IsWaiting)
    {
        this.IsWaiting = IsWaiting;
    }
    public Integer getIsWaiting()
    {
        return this.IsWaiting;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setDocAdivce(String DocAdivce)
    {
        this.DocAdivce = DocAdivce;
    }
    public String getDocAdivce()
    {
        return this.DocAdivce;
    }
    public void setFrequency(String Frequency)
    {
        this.Frequency = Frequency;
    }
    public String getFrequency()
    {
        return this.Frequency;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setUseName(String UseName)
    {
        this.UseName = UseName;
    }
    public String getUseName()
    {
        return this.UseName;
    }
    public void setCombNo(String CombNo)
    {
        this.CombNo = CombNo;
    }
    public String getCombNo()
    {
        return this.CombNo;
    }
    public void setUseTime(String UseTime)
    {
        this.UseTime = UseTime;
    }
    public String getUseTime()
    {
        return this.UseTime;
    }
    public void setGroupStringString(String GroupStringString)
    {
        this.GroupStringString = GroupStringString;
    }
    public String getGroupStringString()
    {
        return this.GroupStringString;
    }
    public void setGrave(String Grave)
    {
        this.Grave = Grave;
    }
    public String getGrave()
    {
        return this.Grave;
    }
    public void setISAllergy(String ISAllergy)
    {
        this.ISAllergy = ISAllergy;
    }
    public String getISAllergy()
    {
        return this.ISAllergy;
    }
    public void setISArrearage(String ISArrearage)
    {
        this.ISArrearage = ISArrearage;
    }
    public String getISArrearage()
    {
        return this.ISArrearage;
    }
    public void setWard_id(String Ward_id)
    {
        this.Ward_id = Ward_id;
    }
    public String getWard_id()
    {
        return this.Ward_id;
    }
    public void setWarning(String Warning)
    {
        this.Warning = Warning;
    }
    public String getWarning()
    {
        return this.Warning;
    }
    public void setRisk(String Risk)
    {
        this.Risk = Risk;
    }
    public String getRisk()
    {
        return this.Risk;
    }
    public void setOther(String Other)
    {
        this.Other = Other;
    }
    public String getOther()
    {
        return this.Other;
    }
    public void setOverFee(String OverFee)
    {
        this.OverFee = OverFee;
    }
    public String getOverFee()
    {
        return this.OverFee;
    }
    public void setOpFlag(String OpFlag)
    {
        this.OpFlag = OpFlag;
    }
    public String getOpFlag()
    {
        return this.OpFlag;
    }
    public void setClinicPathFlag(String ClinicPathFlag)
    {
        this.ClinicPathFlag = ClinicPathFlag;
    }
    public String getClinicPathFlag()
    {
        return this.ClinicPathFlag;
    }
    public void setPaymentType(String PaymentType)
    {
        this.PaymentType = PaymentType;
    }
    public String getPaymentType()
    {
        return this.PaymentType;
    }
    public void setSettled(String Settled)
    {
        this.Settled = Settled;
    }
    public String getSettled()
    {
        return this.Settled;
    }
    public void setUnSettled(String UnSettled)
    {
        this.UnSettled = UnSettled;
    }
    public String getUnSettled()
    {
        return this.UnSettled;
    }
    public void setIsoperation(String isoperation)
    {
        this.isoperation = isoperation;
    }
    public String getIsoperation()
    {
        return this.isoperation;
    }
    public void setBloodtype(String bloodtype)
    {
        this.bloodtype = bloodtype;
    }
    public String getBloodtype()
    {
        return this.bloodtype;
    }
    public void setDiagnsisHistoryList(ArrayOfDCPatientDiagnosis DiagnsisHistoryList)
    {
        this.DiagnsisHistoryList = DiagnsisHistoryList;
    }
    public ArrayOfDCPatientDiagnosis getDiagnsisHistoryList()
    {
        return this.DiagnsisHistoryList;
    }
}
