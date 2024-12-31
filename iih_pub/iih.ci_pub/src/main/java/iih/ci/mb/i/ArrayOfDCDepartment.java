package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDepartment
{
    @JsonProperty(value = "DCDepartment")
    private DCDepartment[] DCDepartment;

    public void setDCDepartment(DCDepartment[] DCDepartment)
    {
        this.DCDepartment = DCDepartment;
    }
    public DCDepartment[] getDCDepartment()
    {
        return this.DCDepartment;
    }
}
