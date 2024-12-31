package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDCDoctorAdviceExecutionRecordOfIDRequest
{
    @JsonProperty(value = "Id")
    private Long Id;

    public void setId(Long Id)
    {
        this.Id = Id;
    }
    public Long getId()
    {
        return this.Id;
    }
}
