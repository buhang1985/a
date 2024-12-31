package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientTestTypeList
{
    @JsonProperty(value = "DCPatientTestTypeList")
    private DCPatientTestTypeList[] DCPatientTestTypeList;

    public void setDCPatientTestTypeList(DCPatientTestTypeList[] DCPatientTestTypeList)
    {
        this.DCPatientTestTypeList = DCPatientTestTypeList;
    }
    public DCPatientTestTypeList[] getDCPatientTestTypeList()
    {
        return this.DCPatientTestTypeList;
    }
}
