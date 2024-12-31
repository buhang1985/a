package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddHivPatientRequest
{
    @JsonProperty(value = "hivPatientList")
    private ArrayOfDCHIVPatient hivPatientList;

    public void setHivPatientList(ArrayOfDCHIVPatient hivPatientList)
    {
        this.hivPatientList = hivPatientList;
    }
    public ArrayOfDCHIVPatient getHivPatientList()
    {
        return this.hivPatientList;
    }
}
