package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetContentDefinitionsOfNursingRecordFileRequest
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
