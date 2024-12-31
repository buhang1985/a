package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordFileRequest
{
    @JsonProperty(value = "fileID")
    private String fileID;

    public void setFileID(String fileID)
    {
        this.fileID = fileID;
    }
    public String getFileID()
    {
        return this.fileID;
    }
}
