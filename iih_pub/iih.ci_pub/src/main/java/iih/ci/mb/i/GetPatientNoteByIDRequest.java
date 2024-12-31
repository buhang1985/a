package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientNoteByIDRequest
{
    @JsonProperty(value = "noteID")
    private String noteID;

    public void setNoteID(String noteID)
    {
        this.noteID = noteID;
    }
    public String getNoteID()
    {
        return this.noteID;
    }
}
