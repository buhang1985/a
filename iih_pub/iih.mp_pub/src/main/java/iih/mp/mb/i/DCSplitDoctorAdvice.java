package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.mw.coreitf.d.FBoolean;

public class DCSplitDoctorAdvice
{
    @JsonProperty(value = "IsPermitExec")
    private String IsPermitExec;
    @JsonProperty(value = "isPerExec")
    private String isPerExec;
    @JsonProperty(value = "InState")
    private String InState;
    @JsonProperty(value = "IsDrugAdvice")
    private String IsDrugAdvice;
    @JsonProperty(value = "execName")
    private String execName;
    @JsonProperty(value = "InPatientNo")
    private String InPatientNo;
    @JsonProperty(value = "IsLong")
    private String IsLong;
    @JsonProperty(value = "PatientNo")
    private String PatientNo;
    @JsonProperty(value = "OrderNo")
    private String OrderNo;
    @JsonProperty(value = "Execsqn")
    private String Execsqn;
    @JsonProperty(value = "ExecFlag")
    private String ExecFlag;
    @JsonProperty(value = "DocName")
    private String DocName;
    @JsonProperty(value = "TypeCode")
    private String TypeCode;
    @JsonProperty(value = "UsageCode")
    private String UsageCode;
    @JsonProperty(value = "OrderClass")
    private String OrderClass;
    @JsonProperty(value = "OrderClassString")
    private String OrderClassString;
    @JsonProperty(value = "ValidFlag")
    private String ValidFlag;
    @JsonProperty(value = "PrintFlag")
    private String PrintFlag;
    @JsonProperty(value = "DrugedFlag")
    private String DrugedFlag;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "Specs")
    private String Specs;
    @JsonProperty(value = "UseName")
    private String UseName;
    @JsonProperty(value = "QtyTot")
    private String QtyTot;
    @JsonProperty(value = "DoseOnce")
    private String DoseOnce;
    @JsonProperty(value = "PriceUnit")
    private String PriceUnit;
    @JsonProperty(value = "UseTime")
    private String UseTime;
    @JsonProperty(value = "DecoDate")
    private String DecoDate;
    @JsonProperty(value = "ChargeDate")
    private String ChargeDate;
    @JsonProperty(value = "DrugedDate")
    private String DrugedDate;
    @JsonProperty(value = "MoDate")
    private String MoDate;
    @JsonProperty(value = "ValidDate")
    private String ValidDate;
    @JsonProperty(value = "SJExecuteDate")
    private String SJExecuteDate;
    @JsonProperty(value = "ExecuteDate")
    private String ExecuteDate;
    @JsonProperty(value = "FrequencyCode")
    private String FrequencyCode;
    @JsonProperty(value = "Frequency")
    private String Frequency;
    @JsonProperty(value = "FrequencyCI")
    private String FrequencyCI;
    @JsonProperty(value = "MoNote1")
    private String MoNote1;
    @JsonProperty(value = "MoNote2")
    private String MoNote2;
    @JsonProperty(value = "MoOder")
    private String MoOder;
    @JsonProperty(value = "CombNo")
    private String CombNo;
    @JsonProperty(value = "SetSubTbl")
    private String SetSubTbl;
    @JsonProperty(value = "ExecDpcd")
    private String ExecDpcd;
    @JsonProperty(value = "ChargeFlag")
    private String ChargeFlag;
    @JsonProperty(value = "ChargeUserCD")
    private String ChargeUserCD;
    @JsonProperty(value = "ExecUserCD")
    private String ExecUserCD;
    @JsonProperty(value = "ValidUserCD")
    private String ValidUserCD;
    @JsonProperty(value = "RecipeNo")
    private String RecipeNo;
    @JsonProperty(value = "BaseDosage")
    private String BaseDosage;
    @JsonProperty(value = "DosageUnit")
    private String DosageUnit;
    @JsonProperty(value = "ExecDepartment")
    private String ExecDepartment;
    @JsonProperty(value = "LastExecuteDate")
    private String LastExecuteDate;
    @JsonProperty(value = "ExecuteNature")
    private String ExecuteNature;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "StateString")
    private String StateString;
    @JsonProperty(value = "IsLongTerm")
    private String IsLongTerm;
    @JsonProperty(value = "ExecDpcdName")
    private String ExecDpcdName;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "Bedno")
    private String Bedno;
    @JsonProperty(value = "Bedno1")
    private String Bedno1;
    @JsonProperty(value = "HID")
    private String HID;
    @JsonProperty(value = "SEX")
    private String SEX;
    @JsonProperty(value = "AGE")
    private String AGE;
    @JsonProperty(value = "ENTERDATE")
    private String ENTERDATE;
    @JsonProperty(value = "ValidNurse")
    private String ValidNurse;
    @JsonProperty(value = "ValidNurseDate")
    private String ValidNurseDate;
    @JsonProperty(value = "ExecNum")
    private String ExecNum;
    @JsonProperty(value = "ExecTime")
    private String ExecTime;
    @JsonProperty(value = "ExecCI")
    private String ExecCI;
    @JsonProperty(value = "PhoneTime")
    private String PhoneTime;
    @JsonProperty(value = "FirstDate")
    private String FirstDate;
    @JsonProperty(value = "LastDate")
    private String LastDate;
    @JsonProperty(value = "ExecType")
    private String ExecType;
    @JsonProperty(value = "execContent")
    private String execContent;
    @JsonProperty(value = "PrintNum")
    private String PrintNum;
    @JsonProperty(value = "Result")
    private String Result;
    @JsonProperty(value = "RecordID")
    private String RecordID;
    @JsonProperty(value = "flag0")
    private String flag0;
    @JsonProperty(value = "flag1")
    private String flag1;
    @JsonProperty(value = "flag2")
    private String flag2;
    @JsonProperty(value = "flag0Oper")
    private String flag0Oper;
    @JsonProperty(value = "flag1Oper")
    private String flag1Oper;
    @JsonProperty(value = "flag2Oper")
    private String flag2Oper;
    
    @JsonProperty(value = "flag0OperName")
    private String flag0OperName;
    @JsonProperty(value = "flag1OperName")
    private String flag1OperName;
    @JsonProperty(value = "flag2OperName")
    private String flag2OperName;
    
    @JsonProperty(value = "gwState")
    private String gwState;
    @JsonProperty(value = "dmState")
    private String dmState;
    @JsonProperty(value = "effe")
    private String effe;
    @JsonProperty(value = "SkinFlag")
    private String SkinFlag;
    @JsonProperty(value = "ParentExecOrderII")
    private String ParentExecOrderII;
    @JsonProperty(value = "OrderStatus")
    private String OrderStatus;
    @JsonProperty(value = "Rate")
    private String Rate;
    @JsonProperty(value = "ExecuteTime")
    private String ExecuteTime;
    @JsonProperty(value = "NeedDoubleCheck")
    private String NeedDoubleCheck;
    @JsonProperty(value = "IsPdaExec")
    private String IsPdaExec;
    @JsonProperty(value = "SecondExecEmployeeII")
    private String SecondExecEmployeeII;
    @JsonProperty(value = "SecondExecTime")
    private String SecondExecTime;
    @JsonProperty(value = "multi_flag")
    private String multi_flag;
    @JsonProperty(value = "ypCode")
    private String ypCode;
    @JsonProperty(value = "groupid")
    private String groupid;
    @JsonProperty(value = "amount")
    private String amount;
    @JsonProperty(value = "ishandExec")
    private String ishandExec;
  
    
    @JsonProperty(value = "eu_su")//执行状态
    private String eu_su;
    

    private FBoolean fg_skintest;
    
    
    
	public FBoolean getFg_skintest() {
		return fg_skintest;
	}
	public void setFg_skintest(FBoolean fg_skintest) {
		this.fg_skintest = fg_skintest;
	}
	public String getEu_su() {
		return eu_su;
	}
	public void setEu_su(String eu_su) {
		this.eu_su = eu_su;
	}
	public void setIsPermitExec(String IsPermitExec)
    {
        this.IsPermitExec = IsPermitExec;
    }
    public String getIsPermitExec()
    {
        return this.IsPermitExec;
    }
    public void setIsPerExec(String isPerExec)
    {
        this.isPerExec = isPerExec;
    }
    public String getIsPerExec()
    {
        return this.isPerExec;
    }
    public void setInState(String InState)
    {
        this.InState = InState;
    }
    public String getInState()
    {
        return this.InState;
    }
    public void setIsDrugAdvice(String IsDrugAdvice)
    {
        this.IsDrugAdvice = IsDrugAdvice;
    }
    public String getIsDrugAdvice()
    {
        return this.IsDrugAdvice;
    }
    public void setExecName(String execName)
    {
        this.execName = execName;
    }
    public String getExecName()
    {
        return this.execName;
    }
    public void setInPatientNo(String InPatientNo)
    {
        this.InPatientNo = InPatientNo;
    }
    public String getInPatientNo()
    {
        return this.InPatientNo;
    }
    public void setIsLong(String IsLong)
    {
        this.IsLong = IsLong;
    }
    public String getIsLong()
    {
        return this.IsLong;
    }
    public void setPatientNo(String PatientNo)
    {
        this.PatientNo = PatientNo;
    }
    public String getPatientNo()
    {
        return this.PatientNo;
    }
    public void setOrderNo(String OrderNo)
    {
        this.OrderNo = OrderNo;
    }
    public String getOrderNo()
    {
        return this.OrderNo;
    }
    public void setExecsqn(String Execsqn)
    {
        this.Execsqn = Execsqn;
    }
    public String getExecsqn()
    {
        return this.Execsqn;
    }
    public void setExecFlag(String ExecFlag)
    {
        this.ExecFlag = ExecFlag;
    }
    public String getExecFlag()
    {
        return this.ExecFlag;
    }
    public void setDocName(String DocName)
    {
        this.DocName = DocName;
    }
    public String getDocName()
    {
        return this.DocName;
    }
    public void setTypeCode(String TypeCode)
    {
        this.TypeCode = TypeCode;
    }
    public String getTypeCode()
    {
        return this.TypeCode;
    }
    public void setUsageCode(String UsageCode)
    {
        this.UsageCode = UsageCode;
    }
    public String getUsageCode()
    {
        return this.UsageCode;
    }
    public void setOrderClass(String OrderClass)
    {
        this.OrderClass = OrderClass;
    }
    public String getOrderClass()
    {
        return this.OrderClass;
    }
    public void setOrderClassString(String OrderClassString)
    {
        this.OrderClassString = OrderClassString;
    }
    public String getOrderClassString()
    {
        return this.OrderClassString;
    }
    public void setValidFlag(String ValidFlag)
    {
        this.ValidFlag = ValidFlag;
    }
    public String getValidFlag()
    {
        return this.ValidFlag;
    }
    public void setPrintFlag(String PrintFlag)
    {
        this.PrintFlag = PrintFlag;
    }
    public String getPrintFlag()
    {
        return this.PrintFlag;
    }
    public void setDrugedFlag(String DrugedFlag)
    {
        this.DrugedFlag = DrugedFlag;
    }
    public String getDrugedFlag()
    {
        return this.DrugedFlag;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setSpecs(String Specs)
    {
        this.Specs = Specs;
    }
    public String getSpecs()
    {
        return this.Specs;
    }
    public void setUseName(String UseName)
    {
        this.UseName = UseName;
    }
    public String getUseName()
    {
        return this.UseName;
    }
    public void setQtyTot(String QtyTot)
    {
        this.QtyTot = QtyTot;
    }
    public String getQtyTot()
    {
        return this.QtyTot;
    }
    public void setDoseOnce(String DoseOnce)
    {
        this.DoseOnce = DoseOnce;
    }
    public String getDoseOnce()
    {
        return this.DoseOnce;
    }
    public void setPriceUnit(String PriceUnit)
    {
        this.PriceUnit = PriceUnit;
    }
    public String getPriceUnit()
    {
        return this.PriceUnit;
    }
    public void setUseTime(String UseTime)
    {
        this.UseTime = UseTime;
    }
    public String getUseTime()
    {
        return this.UseTime;
    }
    public void setDecoDate(String DecoDate)
    {
        this.DecoDate = DecoDate;
    }
    public String getDecoDate()
    {
        return this.DecoDate;
    }
    public void setChargeDate(String ChargeDate)
    {
        this.ChargeDate = ChargeDate;
    }
    public String getChargeDate()
    {
        return this.ChargeDate;
    }
    public void setDrugedDate(String DrugedDate)
    {
        this.DrugedDate = DrugedDate;
    }
    public String getDrugedDate()
    {
        return this.DrugedDate;
    }
    public void setMoDate(String MoDate)
    {
        this.MoDate = MoDate;
    }
    public String getMoDate()
    {
        return this.MoDate;
    }
    public void setValidDate(String ValidDate)
    {
        this.ValidDate = ValidDate;
    }
    public String getValidDate()
    {
        return this.ValidDate;
    }
    public void setSJExecuteDate(String SJExecuteDate)
    {
        this.SJExecuteDate = SJExecuteDate;
    }
    public String getSJExecuteDate()
    {
        return this.SJExecuteDate;
    }
    public void setExecuteDate(String ExecuteDate)
    {
        this.ExecuteDate = ExecuteDate;
    }
    public String getExecuteDate()
    {
        return this.ExecuteDate;
    }
    public void setFrequencyCode(String FrequencyCode)
    {
        this.FrequencyCode = FrequencyCode;
    }
    public String getFrequencyCode()
    {
        return this.FrequencyCode;
    }
    public void setFrequency(String Frequency)
    {
        this.Frequency = Frequency;
    }
    public String getFrequency()
    {
        return this.Frequency;
    }
    public void setFrequencyCI(String FrequencyCI)
    {
        this.FrequencyCI = FrequencyCI;
    }
    public String getFrequencyCI()
    {
        return this.FrequencyCI;
    }
    public void setMoNote1(String MoNote1)
    {
        this.MoNote1 = MoNote1;
    }
    public String getMoNote1()
    {
        return this.MoNote1;
    }
    public void setMoNote2(String MoNote2)
    {
        this.MoNote2 = MoNote2;
    }
    public String getMoNote2()
    {
        return this.MoNote2;
    }
    public void setMoOder(String MoOder)
    {
        this.MoOder = MoOder;
    }
    public String getMoOder()
    {
        return this.MoOder;
    }
    public void setCombNo(String CombNo)
    {
        this.CombNo = CombNo;
    }
    public String getCombNo()
    {
        return this.CombNo;
    }
    public void setSetSubTbl(String SetSubTbl)
    {
        this.SetSubTbl = SetSubTbl;
    }
    public String getSetSubTbl()
    {
        return this.SetSubTbl;
    }
    public void setExecDpcd(String ExecDpcd)
    {
        this.ExecDpcd = ExecDpcd;
    }
    public String getExecDpcd()
    {
        return this.ExecDpcd;
    }
    public void setChargeFlag(String ChargeFlag)
    {
        this.ChargeFlag = ChargeFlag;
    }
    public String getChargeFlag()
    {
        return this.ChargeFlag;
    }
    public void setChargeUserCD(String ChargeUserCD)
    {
        this.ChargeUserCD = ChargeUserCD;
    }
    public String getChargeUserCD()
    {
        return this.ChargeUserCD;
    }
    public void setExecUserCD(String ExecUserCD)
    {
        this.ExecUserCD = ExecUserCD;
    }
    public String getExecUserCD()
    {
        return this.ExecUserCD;
    }
    public void setValidUserCD(String ValidUserCD)
    {
        this.ValidUserCD = ValidUserCD;
    }
    public String getValidUserCD()
    {
        return this.ValidUserCD;
    }
    public void setRecipeNo(String RecipeNo)
    {
        this.RecipeNo = RecipeNo;
    }
    public String getRecipeNo()
    {
        return this.RecipeNo;
    }
    public void setBaseDosage(String BaseDosage)
    {
        this.BaseDosage = BaseDosage;
    }
    public String getBaseDosage()
    {
        return this.BaseDosage;
    }
    public void setDosageUnit(String DosageUnit)
    {
        this.DosageUnit = DosageUnit;
    }
    public String getDosageUnit()
    {
        return this.DosageUnit;
    }
    public void setExecDepartment(String ExecDepartment)
    {
        this.ExecDepartment = ExecDepartment;
    }
    public String getExecDepartment()
    {
        return this.ExecDepartment;
    }
    public void setLastExecuteDate(String LastExecuteDate)
    {
        this.LastExecuteDate = LastExecuteDate;
    }
    public String getLastExecuteDate()
    {
        return this.LastExecuteDate;
    }
    public void setExecuteNature(String ExecuteNature)
    {
        this.ExecuteNature = ExecuteNature;
    }
    public String getExecuteNature()
    {
        return this.ExecuteNature;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setStateString(String StateString)
    {
        this.StateString = StateString;
    }
    public String getStateString()
    {
        return this.StateString;
    }
    public void setIsLongTerm(String IsLongTerm)
    {
        this.IsLongTerm = IsLongTerm;
    }
    public String getIsLongTerm()
    {
        return this.IsLongTerm;
    }
    public void setExecDpcdName(String ExecDpcdName)
    {
        this.ExecDpcdName = ExecDpcdName;
    }
    public String getExecDpcdName()
    {
        return this.ExecDpcdName;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setBedno(String Bedno)
    {
        this.Bedno = Bedno;
    }
    public String getBedno()
    {
        return this.Bedno;
    }
    public void setBedno1(String Bedno1)
    {
        this.Bedno1 = Bedno1;
    }
    public String getBedno1()
    {
        return this.Bedno1;
    }
    public void setHID(String HID)
    {
        this.HID = HID;
    }
    public String getHID()
    {
        return this.HID;
    }
    public void setSEX(String SEX)
    {
        this.SEX = SEX;
    }
    public String getSEX()
    {
        return this.SEX;
    }
    public void setAGE(String AGE)
    {
        this.AGE = AGE;
    }
    public String getAGE()
    {
        return this.AGE;
    }
    public void setENTERDATE(String ENTERDATE)
    {
        this.ENTERDATE = ENTERDATE;
    }
    public String getENTERDATE()
    {
        return this.ENTERDATE;
    }
    public void setValidNurse(String ValidNurse)
    {
        this.ValidNurse = ValidNurse;
    }
    public String getValidNurse()
    {
        return this.ValidNurse;
    }
    public void setValidNurseDate(String ValidNurseDate)
    {
        this.ValidNurseDate = ValidNurseDate;
    }
    public String getValidNurseDate()
    {
        return this.ValidNurseDate;
    }
    public void setExecNum(String ExecNum)
    {
        this.ExecNum = ExecNum;
    }
    public String getExecNum()
    {
        return this.ExecNum;
    }
    public void setExecTime(String ExecTime)
    {
        this.ExecTime = ExecTime;
    }
    public String getExecTime()
    {
        return this.ExecTime;
    }
    public void setExecCI(String ExecCI)
    {
        this.ExecCI = ExecCI;
    }
    public String getExecCI()
    {
        return this.ExecCI;
    }
    public void setPhoneTime(String PhoneTime)
    {
        this.PhoneTime = PhoneTime;
    }
    public String getPhoneTime()
    {
        return this.PhoneTime;
    }
    public void setFirstDate(String FirstDate)
    {
        this.FirstDate = FirstDate;
    }
    public String getFirstDate()
    {
        return this.FirstDate;
    }
    public void setLastDate(String LastDate)
    {
        this.LastDate = LastDate;
    }
    public String getLastDate()
    {
        return this.LastDate;
    }
    public void setExecType(String ExecType)
    {
        this.ExecType = ExecType;
    }
    public String getExecType()
    {
        return this.ExecType;
    }
    public void setExecContent(String execContent)
    {
        this.execContent = execContent;
    }
    public String getExecContent()
    {
        return this.execContent;
    }
    public void setPrintNum(String PrintNum)
    {
        this.PrintNum = PrintNum;
    }
    public String getPrintNum()
    {
        return this.PrintNum;
    }
    public void setResult(String Result)
    {
        this.Result = Result;
    }
    public String getResult()
    {
        return this.Result;
    }
    public void setRecordID(String RecordID)
    {
        this.RecordID = RecordID;
    }
    public String getRecordID()
    {
        return this.RecordID;
    }
    public void setFlag0(String flag0)
    {
        this.flag0 = flag0;
    }
    public String getFlag0()
    {
        return this.flag0;
    }
    public void setFlag1(String flag1)
    {
        this.flag1 = flag1;
    }
    public String getFlag1()
    {
        return this.flag1;
    }
    public void setFlag2(String flag2)
    {
        this.flag2 = flag2;
    }
    public String getFlag2()
    {
        return this.flag2;
    }
    public void setFlag0Oper(String flag0Oper)
    {
        this.flag0Oper = flag0Oper;
    }
    public String getFlag0Oper()
    {
        return this.flag0Oper;
    }
    public void setFlag1Oper(String flag1Oper)
    {
        this.flag1Oper = flag1Oper;
    }
    public String getFlag1Oper()
    {
        return this.flag1Oper;
    }
    public void setFlag2Oper(String flag2Oper)
    {
        this.flag2Oper = flag2Oper;
    }
    public String getFlag2Oper()
    {
        return this.flag2Oper;
    }
    
    public String getFlag0OperName() {
		return flag0OperName;
	}
	public void setFlag0OperName(String flag0OperName) {
		this.flag0OperName = flag0OperName;
	}
	public String getFlag1OperName() {
		return flag1OperName;
	}
	public void setFlag1OperName(String flag1OperName) {
		this.flag1OperName = flag1OperName;
	}
	public String getFlag2OperName() {
		return flag2OperName;
	}
	public void setFlag2OperName(String flag2OperName) {
		this.flag2OperName = flag2OperName;
	}
	public void setGwState(String gwState)
    {
        this.gwState = gwState;
    }
    public String getGwState()
    {
        return this.gwState;
    }
    public void setDmState(String dmState)
    {
        this.dmState = dmState;
    }
    public String getDmState()
    {
        return this.dmState;
    }
    public void setEffe(String effe)
    {
        this.effe = effe;
    }
    public String getEffe()
    {
        return this.effe;
    }
    public void setSkinFlag(String SkinFlag)
    {
        this.SkinFlag = SkinFlag;
    }
    public String getSkinFlag()
    {
        return this.SkinFlag;
    }
    public void setParentExecOrderII(String ParentExecOrderII)
    {
        this.ParentExecOrderII = ParentExecOrderII;
    }
    public String getParentExecOrderII()
    {
        return this.ParentExecOrderII;
    }
    public void setOrderStatus(String OrderStatus)
    {
        this.OrderStatus = OrderStatus;
    }
    public String getOrderStatus()
    {
        return this.OrderStatus;
    }
    public void setRate(String Rate)
    {
        this.Rate = Rate;
    }
    public String getRate()
    {
        return this.Rate;
    }
    public void setExecuteTime(String ExecuteTime)
    {
        this.ExecuteTime = ExecuteTime;
    }
    public String getExecuteTime()
    {
        return this.ExecuteTime;
    }
    public void setNeedDoubleCheck(String NeedDoubleCheck)
    {
        this.NeedDoubleCheck = NeedDoubleCheck;
    }
    public String getNeedDoubleCheck()
    {
        return this.NeedDoubleCheck;
    }
    public void setIsPdaExec(String IsPdaExec)
    {
        this.IsPdaExec = IsPdaExec;
    }
    public String getIsPdaExec()
    {
        return this.IsPdaExec;
    }
    public void setSecondExecEmployeeII(String SecondExecEmployeeII)
    {
        this.SecondExecEmployeeII = SecondExecEmployeeII;
    }
    public String getSecondExecEmployeeII()
    {
        return this.SecondExecEmployeeII;
    }
    public void setSecondExecTime(String SecondExecTime)
    {
        this.SecondExecTime = SecondExecTime;
    }
    public String getSecondExecTime()
    {
        return this.SecondExecTime;
    }
    public void setMulti_flag(String multi_flag)
    {
        this.multi_flag = multi_flag;
    }
    public String getMulti_flag()
    {
        return this.multi_flag;
    }
    public void setYpCode(String ypCode)
    {
        this.ypCode = ypCode;
    }
    public String getYpCode()
    {
        return this.ypCode;
    }
    public void setGroupid(String groupid)
    {
        this.groupid = groupid;
    }
    public String getGroupid()
    {
        return this.groupid;
    }
    public void setAmount(String amount)
    {
        this.amount = amount;
    }
    public String getAmount()
    {
        return this.amount;
    }
    public void setIshandExec(String ishandExec)
    {
        this.ishandExec = ishandExec;
    }
    public String getIshandExec()
    {
        return this.ishandExec;
    }
}
