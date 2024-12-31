package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSQueryPatientCallRequest
{
    @JsonProperty(value = "startDateTime")
    private Long startDateTime;
    @JsonProperty(value = "endDateTime")
    private Long endDateTime;

    public void setStartDateTime(Long startDateTime)
    {
        this.startDateTime = startDateTime;
    }
    public Long getStartDateTime()
    {
        return this.startDateTime;
    }
    public void setEndDateTime(Long endDateTime)
    {
        this.endDateTime = endDateTime;
    }
    public Long getEndDateTime()
    {
        return this.endDateTime;
    }
}
