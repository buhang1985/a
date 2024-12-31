package iih.ci.mb.i;

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
    private Integer TYPEID;
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
    public void setTYPEID(Integer TYPEID)
    {
        this.TYPEID = TYPEID;
    }
    public Integer getTYPEID()
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
}
