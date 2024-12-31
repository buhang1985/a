package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNDCNursingRecordType
{
    @JsonProperty(value = "NDCNursingRecordType")
    private NDCNursingRecordType[] NDCNursingRecordType;

    public void setNDCNursingRecordType(NDCNursingRecordType[] NDCNursingRecordType)
    {
        this.NDCNursingRecordType = NDCNursingRecordType;
    }
    public NDCNursingRecordType[] getNDCNursingRecordType()
    {
        return this.NDCNursingRecordType;
    }
}
