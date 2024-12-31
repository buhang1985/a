package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InsertIntoCAInfoRequest
{
    @JsonProperty(value = "emp_sn")
    private String emp_sn;
    @JsonProperty(value = "enc_id")
    private String enc_id;
    @JsonProperty(value = "data_id")
    private String data_id;
    @JsonProperty(value = "data_sn")
    private String data_sn;
    @JsonProperty(value = "data_xml")
    private String data_xml;
    @JsonProperty(value = "cert_id")
    private String cert_id;
    @JsonProperty(value = "ca_data")
    private String ca_data;
    @JsonProperty(value = "ts_data")
    private String ts_data;
    @JsonProperty(value = "creata_time")
    private String creata_time;
    @JsonProperty(value = "sys_code")
    private String sys_code;
    @JsonProperty(value = "ca_state")
    private String ca_state;

    public void setEmp_sn(String emp_sn)
    {
        this.emp_sn = emp_sn;
    }
    public String getEmp_sn()
    {
        return this.emp_sn;
    }
    public void setEnc_id(String enc_id)
    {
        this.enc_id = enc_id;
    }
    public String getEnc_id()
    {
        return this.enc_id;
    }
    public void setData_id(String data_id)
    {
        this.data_id = data_id;
    }
    public String getData_id()
    {
        return this.data_id;
    }
    public void setData_sn(String data_sn)
    {
        this.data_sn = data_sn;
    }
    public String getData_sn()
    {
        return this.data_sn;
    }
    public void setData_xml(String data_xml)
    {
        this.data_xml = data_xml;
    }
    public String getData_xml()
    {
        return this.data_xml;
    }
    public void setCert_id(String cert_id)
    {
        this.cert_id = cert_id;
    }
    public String getCert_id()
    {
        return this.cert_id;
    }
    public void setCa_data(String ca_data)
    {
        this.ca_data = ca_data;
    }
    public String getCa_data()
    {
        return this.ca_data;
    }
    public void setTs_data(String ts_data)
    {
        this.ts_data = ts_data;
    }
    public String getTs_data()
    {
        return this.ts_data;
    }
    public void setCreata_time(String creata_time)
    {
        this.creata_time = creata_time;
    }
    public String getCreata_time()
    {
        return this.creata_time;
    }
    public void setSys_code(String sys_code)
    {
        this.sys_code = sys_code;
    }
    public String getSys_code()
    {
        return this.sys_code;
    }
    public void setCa_state(String ca_state)
    {
        this.ca_state = ca_state;
    }
    public String getCa_state()
    {
        return this.ca_state;
    }
}
