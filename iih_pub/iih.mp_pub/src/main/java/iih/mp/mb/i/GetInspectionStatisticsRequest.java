package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetInspectionStatisticsRequest
{
    @JsonProperty(value = "start")
    private String start;
    @JsonProperty(value = "end")
    private String end;

    public void setStart(String start)
    {
        this.start = start;
    }
    public String getStart()
    {
        return this.start;
    }
    public void setEnd(String end)
    {
        this.end = end;
    }
    public String getEnd()
    {
        return this.end;
    }
}
