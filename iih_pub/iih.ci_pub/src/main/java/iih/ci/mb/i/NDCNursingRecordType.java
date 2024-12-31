package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NDCNursingRecordType
{
    @JsonProperty(value = "TYPEID")
    private Integer TYPEID;
    @JsonProperty(value = "DEPTCODE")
    private String DEPTCODE;
    @JsonProperty(value = "TYPENAME")
    private String TYPENAME;
    @JsonProperty(value = "TYPEUNIT")
    private String TYPEUNIT;
    @JsonProperty(value = "TYPEDICT")
    private String TYPEDICT;
    @JsonProperty(value = "TYPEGROUPNAME")
    private String TYPEGROUPNAME;
    @JsonProperty(value = "TYPECLASS")
    private String TYPECLASS;
    @JsonProperty(value = "TYPEMAXVALUE")
    private Double TYPEMAXVALUE;
    @JsonProperty(value = "TYPEMINVALUE")
    private Double TYPEMINVALUE;
    @JsonProperty(value = "TYPEREPORTTYPE")
    private Integer TYPEREPORTTYPE;
    @JsonProperty(value = "TYPEFREQ")
    private Integer TYPEFREQ;
    @JsonProperty(value = "TYPESORT")
    private Integer TYPESORT;
    @JsonProperty(value = "TYPETEXTTYPE")
    private Integer TYPETEXTTYPE;
    @JsonProperty(value = "TYPEPOSITION")
    private String TYPEPOSITION;

    public void setTYPEID(Integer TYPEID)
    {
        this.TYPEID = TYPEID;
    }
    public Integer getTYPEID()
    {
        return this.TYPEID;
    }
    public void setDEPTCODE(String DEPTCODE)
    {
        this.DEPTCODE = DEPTCODE;
    }
    public String getDEPTCODE()
    {
        return this.DEPTCODE;
    }
    public void setTYPENAME(String TYPENAME)
    {
        this.TYPENAME = TYPENAME;
    }
    public String getTYPENAME()
    {
        return this.TYPENAME;
    }
    public void setTYPEUNIT(String TYPEUNIT)
    {
        this.TYPEUNIT = TYPEUNIT;
    }
    public String getTYPEUNIT()
    {
        return this.TYPEUNIT;
    }
    public void setTYPEDICT(String TYPEDICT)
    {
        this.TYPEDICT = TYPEDICT;
    }
    public String getTYPEDICT()
    {
        return this.TYPEDICT;
    }
    public void setTYPEGROUPNAME(String TYPEGROUPNAME)
    {
        this.TYPEGROUPNAME = TYPEGROUPNAME;
    }
    public String getTYPEGROUPNAME()
    {
        return this.TYPEGROUPNAME;
    }
    public void setTYPECLASS(String TYPECLASS)
    {
        this.TYPECLASS = TYPECLASS;
    }
    public String getTYPECLASS()
    {
        return this.TYPECLASS;
    }
    public void setTYPEMAXVALUE(Double TYPEMAXVALUE)
    {
        this.TYPEMAXVALUE = TYPEMAXVALUE;
    }
    public Double getTYPEMAXVALUE()
    {
        return this.TYPEMAXVALUE;
    }
    public void setTYPEMINVALUE(Double TYPEMINVALUE)
    {
        this.TYPEMINVALUE = TYPEMINVALUE;
    }
    public Double getTYPEMINVALUE()
    {
        return this.TYPEMINVALUE;
    }
    public void setTYPEREPORTTYPE(Integer TYPEREPORTTYPE)
    {
        this.TYPEREPORTTYPE = TYPEREPORTTYPE;
    }
    public Integer getTYPEREPORTTYPE()
    {
        return this.TYPEREPORTTYPE;
    }
    public void setTYPEFREQ(Integer TYPEFREQ)
    {
        this.TYPEFREQ = TYPEFREQ;
    }
    public Integer getTYPEFREQ()
    {
        return this.TYPEFREQ;
    }
    public void setTYPESORT(Integer TYPESORT)
    {
        this.TYPESORT = TYPESORT;
    }
    public Integer getTYPESORT()
    {
        return this.TYPESORT;
    }
    public void setTYPETEXTTYPE(Integer TYPETEXTTYPE)
    {
        this.TYPETEXTTYPE = TYPETEXTTYPE;
    }
    public Integer getTYPETEXTTYPE()
    {
        return this.TYPETEXTTYPE;
    }
    public void setTYPEPOSITION(String TYPEPOSITION)
    {
        this.TYPEPOSITION = TYPEPOSITION;
    }
    public String getTYPEPOSITION()
    {
        return this.TYPEPOSITION;
    }
}
