package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCSchedule
{
    @JsonProperty(value = "StartDate")
    private Long StartDate;
    @JsonProperty(value = "Description")
    private String Description;
    @JsonProperty(value = "DutyArranges")
    private ArrayOfDCDutyArrangePerNurse DutyArranges;

    public void setStartDate(Long StartDate)
    {
        this.StartDate = StartDate;
    }
    public Long getStartDate()
    {
        return this.StartDate;
    }
    public void setDescription(String Description)
    {
        this.Description = Description;
    }
    public String getDescription()
    {
        return this.Description;
    }
    public void setDutyArranges(ArrayOfDCDutyArrangePerNurse DutyArranges)
    {
        this.DutyArranges = DutyArranges;
    }
    public ArrayOfDCDutyArrangePerNurse getDutyArranges()
    {
        return this.DutyArranges;
    }
}
