package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateInfusionTourRequest
{
    @JsonProperty(value = "NursingTourID")
    private String NursingTourID;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "Note")
    private String Note;

    public void setNursingTourID(String NursingTourID)
    {
        this.NursingTourID = NursingTourID;
    }
    public String getNursingTourID()
    {
        return this.NursingTourID;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setNote(String Note)
    {
        this.Note = Note;
    }
    public String getNote()
    {
        return this.Note;
    }
}
