package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNote_Patient_Voice
{
    @JsonProperty(value = "Note_Patient_Voice")
    private Note_Patient_Voice[] Note_Patient_Voice;

    public void setNote_Patient_Voice(Note_Patient_Voice[] Note_Patient_Voice)
    {
        this.Note_Patient_Voice = Note_Patient_Voice;
    }
    public Note_Patient_Voice[] getNote_Patient_Voice()
    {
        return this.Note_Patient_Voice;
    }
}
