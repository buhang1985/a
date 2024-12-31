package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfYZDepartment
{
    @JsonProperty(value = "YZDepartment")
    private YZDepartment[] YZDepartment;

    public void setYZDepartment(YZDepartment[] YZDepartment)
    {
        this.YZDepartment = YZDepartment;
    }
    public YZDepartment[] getYZDepartment()
    {
        return this.YZDepartment;
    }
}
