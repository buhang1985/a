package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetConsultPatientHROfDepartmentRequest
{
    @JsonProperty(value = "execUnit")
    private String execUnit;

    public void setExecUnit(String execUnit)
    {
        this.execUnit = execUnit;
    }
    public String getExecUnit()
    {
        return this.execUnit;
    }
}
