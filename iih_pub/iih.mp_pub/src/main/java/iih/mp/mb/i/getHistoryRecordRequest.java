package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class getHistoryRecordRequest
{
    @JsonProperty(value = "time")
    private String time;
    @JsonProperty(value = "wardno")
    private String wardno;

    public void setTime(String time)
    {
        this.time = time;
    }
    public String getTime()
    {
        return this.time;
    }
    public void setWardno(String wardno)
    {
        this.wardno = wardno;
    }
    public String getWardno()
    {
        return this.wardno;
    }
}
