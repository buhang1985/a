package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NDCVitalSignNode
{
    @JsonProperty(value = "VITALSIGNVALUE")
    private String VITALSIGNVALUE;
    @JsonProperty(value = "DEPTCODE")
    private String DEPTCODE;
    @JsonProperty(value = "DEPTNAME")
    private String DEPTNAME;
    @JsonProperty(value = "PATIENTID")
    private String PATIENTID;
    @JsonProperty(value = "VISITID")
    private String VISITID;
    @JsonProperty(value = "CRISISVALUETYPE")
    private String CRISISVALUETYPE;
    @JsonProperty(value = "RECORDID")
    private Integer RECORDID;
    @JsonProperty(value = "TYPEUNIT")
    private String TYPEUNIT;
    @JsonProperty(value = "TIMEPOINT")
    private String TIMEPOINT;
    @JsonProperty(value = "TYPEID")
    private String TYPEID;
    @JsonProperty(value = "TYPENAME")
    private String TYPENAME;
    @JsonProperty(value = "NURSEID")
    private String NURSEID;
    @JsonProperty(value = "NURSENAME")
    private String NURSENAME;
    @JsonProperty(value = "POSITION")
    private String POSITION;
    @JsonProperty(value = "SAVETIME")
    private String SAVETIME;
    @JsonProperty(value = "Missreason")
    private String Missreason;
    @JsonProperty(value = "ValueFlag")
    private String ValueFlag;
    @JsonProperty(value = "ValueFrom")
    private String ValueFrom;
    @JsonProperty(value = "Recorder")
    private String Recorder;
    @JsonProperty(value = "ValueGroup")
    private String ValueGroup;
    @JsonProperty(value = "CreateTime")
    private String CreateTime;
    @JsonProperty(value = "VALUELIST")
    private String VALUELIST;
    @JsonProperty(value = "KEYBOARD")
    private String KEYBOARD;
    @JsonProperty(value = "MASTERNO")
    private String MASTERNO;
    @JsonProperty(value = "DETAILNO")
    private String DETAILNO;
    @JsonProperty(value = "MAX")
    private String MAX;
    @JsonProperty(value = "MIN")
    private String MIN;
    @JsonProperty(value = "DATAVALID")
    private String DATAVALID;
    @JsonProperty(value = "INPUTVALID")
    private String INPUTVALID;
    @JsonProperty(value = "FORMULA")
    private String FORMULA;
    @JsonProperty(value = "NurseRecordII")
    private String NurseRecordII;
    
    @JsonProperty(value = "KEYBOARDTYPE")
    private String KEYBOARDTYPE;
    //增加是否自定义项目
    @JsonProperty(value = "Fg_custom")
    private String Fg_custom;
    
	public String getFg_custom() {
		return Fg_custom;
	}
	public void setFg_custom(String fg_custom) {
		Fg_custom = fg_custom;
	}
	public void setKeyBoardType(String KEYBOARDTYPE){
    	this.KEYBOARDTYPE=KEYBOARDTYPE;
    }
    public String getKeyBoardType(){
    	return this.KEYBOARDTYPE;
    }
    
    public void setVITALSIGNVALUE(String VITALSIGNVALUE)
    {
        this.VITALSIGNVALUE = VITALSIGNVALUE;
    }
    public String getVITALSIGNVALUE()
    {
        return this.VITALSIGNVALUE;
    }
    public void setDEPTCODE(String DEPTCODE)
    {
        this.DEPTCODE = DEPTCODE;
    }
    public String getDEPTCODE()
    {
        return this.DEPTCODE;
    }
    public void setDEPTNAME(String DEPTNAME)
    {
        this.DEPTNAME = DEPTNAME;
    }
    public String getDEPTNAME()
    {
        return this.DEPTNAME;
    }
    public void setPATIENTID(String PATIENTID)
    {
        this.PATIENTID = PATIENTID;
    }
    public String getPATIENTID()
    {
        return this.PATIENTID;
    }
    public void setVISITID(String VISITID)
    {
        this.VISITID = VISITID;
    }
    public String getVISITID()
    {
        return this.VISITID;
    }
    public void setCRISISVALUETYPE(String CRISISVALUETYPE)
    {
        this.CRISISVALUETYPE = CRISISVALUETYPE;
    }
    public String getCRISISVALUETYPE()
    {
        return this.CRISISVALUETYPE;
    }
    public void setRECORDID(Integer RECORDID)
    {
        this.RECORDID = RECORDID;
    }
    public Integer getRECORDID()
    {
        return this.RECORDID;
    }
    public void setTYPEUNIT(String TYPEUNIT)
    {
        this.TYPEUNIT = TYPEUNIT;
    }
    public String getTYPEUNIT()
    {
        return this.TYPEUNIT;
    }
    public void setTIMEPOINT(String TIMEPOINT)
    {
        this.TIMEPOINT = TIMEPOINT;
    }
    public String getTIMEPOINT()
    {
        return this.TIMEPOINT;
    }
    public void setTYPEID(String TYPEID)
    {
        this.TYPEID = TYPEID;
    }
    public String getTYPEID()
    {
        return this.TYPEID;
    }
    public void setTYPENAME(String TYPENAME)
    {
        this.TYPENAME = TYPENAME;
    }
    public String getTYPENAME()
    {
        return this.TYPENAME;
    }
    public void setNURSEID(String NURSEID)
    {
        this.NURSEID = NURSEID;
    }
    public String getNURSEID()
    {
        return this.NURSEID;
    }
    public void setNURSENAME(String NURSENAME)
    {
        this.NURSENAME = NURSENAME;
    }
    public String getNURSENAME()
    {
        return this.NURSENAME;
    }
    public void setPOSITION(String POSITION)
    {
        this.POSITION = POSITION;
    }
    public String getPOSITION()
    {
        return this.POSITION;
    }
    public void setSAVETIME(String SAVETIME)
    {
        this.SAVETIME = SAVETIME;
    }
    public String getSAVETIME()
    {
        return this.SAVETIME;
    }
    public void setMissreason(String Missreason)
    {
        this.Missreason = Missreason;
    }
    public String getMissreason()
    {
        return this.Missreason;
    }
    public void setValueFlag(String ValueFlag)
    {
        this.ValueFlag = ValueFlag;
    }
    public String getValueFlag()
    {
        return this.ValueFlag;
    }
    public void setValueFrom(String ValueFrom)
    {
        this.ValueFrom = ValueFrom;
    }
    public String getValueFrom()
    {
        return this.ValueFrom;
    }
    public void setRecorder(String Recorder)
    {
        this.Recorder = Recorder;
    }
    public String getRecorder()
    {
        return this.Recorder;
    }
    public void setValueGroup(String ValueGroup)
    {
        this.ValueGroup = ValueGroup;
    }
    public String getValueGroup()
    {
        return this.ValueGroup;
    }
    public void setCreateTime(String CreateTime)
    {
        this.CreateTime = CreateTime;
    }
    public String getCreateTime()
    {
        return this.CreateTime;
    }
    public void setVALUELIST(String VALUELIST)
    {
        this.VALUELIST = VALUELIST;
    }
    public String getVALUELIST()
    {
        return this.VALUELIST;
    }
    public void setKEYBOARD(String KEYBOARD)
    {
        this.KEYBOARD = KEYBOARD;
    }
    public String getKEYBOARD()
    {
        return this.KEYBOARD;
    }
    public void setMASTERNO(String MASTERNO)
    {
        this.MASTERNO = MASTERNO;
    }
    public String getMASTERNO()
    {
        return this.MASTERNO;
    }
    public void setDETAILNO(String DETAILNO)
    {
        this.DETAILNO = DETAILNO;
    }
    public String getDETAILNO()
    {
        return this.DETAILNO;
    }
    public void setMAX(String MAX)
    {
        this.MAX = MAX;
    }
    public String getMAX()
    {
        return this.MAX;
    }
    public void setMIN(String MIN)
    {
        this.MIN = MIN;
    }
    public String getMIN()
    {
        return this.MIN;
    }
    public void setDATAVALID(String DATAVALID)
    {
        this.DATAVALID = DATAVALID;
    }
    public String getDATAVALID()
    {
        return this.DATAVALID;
    }
    public void setINPUTVALID(String INPUTVALID)
    {
        this.INPUTVALID = INPUTVALID;
    }
    public String getINPUTVALID()
    {
        return this.INPUTVALID;
    }
    public void setFORMULA(String FORMULA)
    {
        this.FORMULA = FORMULA;
    }
    public String getFORMULA()
    {
        return this.FORMULA;
    }
    public void setNurseRecordII(String NurseRecordII)
    {
        this.NurseRecordII = NurseRecordII;
    }
    public String getNurseRecordII()
    {
        return this.NurseRecordII;
    }
}
