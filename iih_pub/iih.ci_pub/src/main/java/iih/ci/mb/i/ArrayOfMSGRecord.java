package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfMSGRecord
{
    @JsonProperty(value = "MSGRecord")
    private MSGRecord[] MSGRecord;

    public void setMSGRecord(MSGRecord[] MSGRecord)
    {
        this.MSGRecord = MSGRecord;
    }
    public MSGRecord[] getMSGRecord()
    {
        return this.MSGRecord;
    }
}
