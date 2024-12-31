package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNurseDispensation
{
    @JsonProperty(value = "NurseDispensation")
    private NurseDispensation[] NurseDispensation;

    public void setNurseDispensation(NurseDispensation[] NurseDispensation)
    {
        this.NurseDispensation = NurseDispensation;
    }
    public NurseDispensation[] getNurseDispensation()
    {
        return this.NurseDispensation;
    }
}
