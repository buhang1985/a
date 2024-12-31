package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateDutyRequest
{
    @JsonProperty(value = "pid")
    private String pid;
    @JsonProperty(value = "create_date")
    private String create_date;
    @JsonProperty(value = "evid_value")
    private String evid_value;
    @JsonProperty(value = "operater")
    private String operater;

    public void setPid(String pid)
    {
        this.pid = pid;
    }
    public String getPid()
    {
        return this.pid;
    }
    public void setCreate_date(String create_date)
    {
        this.create_date = create_date;
    }
    public String getCreate_date()
    {
        return this.create_date;
    }
    public void setEvid_value(String evid_value)
    {
        this.evid_value = evid_value;
    }
    public String getEvid_value()
    {
        return this.evid_value;
    }
    public void setOperater(String operater)
    {
        this.operater = operater;
    }
    public String getOperater()
    {
        return this.operater;
    }
}
