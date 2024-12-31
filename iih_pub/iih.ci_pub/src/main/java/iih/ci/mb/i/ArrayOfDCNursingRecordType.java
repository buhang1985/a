package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNursingRecordType
{
    @JsonProperty(value = "DCNursingRecordType")
    private DCNursingRecordType[] DCNursingRecordType;

    public void setDCNursingRecordType(DCNursingRecordType[] DCNursingRecordType)
    {
        this.DCNursingRecordType = DCNursingRecordType;
    }
    public DCNursingRecordType[] getDCNursingRecordType()
    {
        return this.DCNursingRecordType;
    }
}
