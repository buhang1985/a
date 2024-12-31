package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCConsultRegister
{
    @JsonProperty(value = "REG_ID")
    private Integer REG_ID;
    @JsonProperty(value = "ORDER_ID")
    private Integer ORDER_ID;
    @JsonProperty(value = "ENTER_TIME")
    private String ENTER_TIME;
    @JsonProperty(value = "ENTER_OPERA")
    private String ENTER_OPERA;
    @JsonProperty(value = "REG_TYPE")
    private String REG_TYPE;
    @JsonProperty(value = "REG_TEXT")
    private String REG_TEXT;
    @JsonProperty(value = "MEMO")
    private String MEMO;
    @JsonProperty(value = "SIGNATURE")
    private String SIGNATURE;
    @JsonProperty(value = "ENC_ID")
    private String ENC_ID;
    @JsonProperty(value = "DEPT_SN")
    private String DEPT_SN;
    @JsonProperty(value = "WARD_SN")
    private String WARD_SN;

    public void setREG_ID(Integer REG_ID)
    {
        this.REG_ID = REG_ID;
    }
    public Integer getREG_ID()
    {
        return this.REG_ID;
    }
    public void setORDER_ID(Integer ORDER_ID)
    {
        this.ORDER_ID = ORDER_ID;
    }
    public Integer getORDER_ID()
    {
        return this.ORDER_ID;
    }
    public void setENTER_TIME(String ENTER_TIME)
    {
        this.ENTER_TIME = ENTER_TIME;
    }
    public String getENTER_TIME()
    {
        return this.ENTER_TIME;
    }
    public void setENTER_OPERA(String ENTER_OPERA)
    {
        this.ENTER_OPERA = ENTER_OPERA;
    }
    public String getENTER_OPERA()
    {
        return this.ENTER_OPERA;
    }
    public void setREG_TYPE(String REG_TYPE)
    {
        this.REG_TYPE = REG_TYPE;
    }
    public String getREG_TYPE()
    {
        return this.REG_TYPE;
    }
    public void setREG_TEXT(String REG_TEXT)
    {
        this.REG_TEXT = REG_TEXT;
    }
    public String getREG_TEXT()
    {
        return this.REG_TEXT;
    }
    public void setMEMO(String MEMO)
    {
        this.MEMO = MEMO;
    }
    public String getMEMO()
    {
        return this.MEMO;
    }
    public void setSIGNATURE(String SIGNATURE)
    {
        this.SIGNATURE = SIGNATURE;
    }
    public String getSIGNATURE()
    {
        return this.SIGNATURE;
    }
    public void setENC_ID(String ENC_ID)
    {
        this.ENC_ID = ENC_ID;
    }
    public String getENC_ID()
    {
        return this.ENC_ID;
    }
    public void setDEPT_SN(String DEPT_SN)
    {
        this.DEPT_SN = DEPT_SN;
    }
    public String getDEPT_SN()
    {
        return this.DEPT_SN;
    }
    public void setWARD_SN(String WARD_SN)
    {
        this.WARD_SN = WARD_SN;
    }
    public String getWARD_SN()
    {
        return this.WARD_SN;
    }
}
