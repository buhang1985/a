package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNote_Patient_Picture
{
    @JsonProperty(value = "Note_Patient_Picture")
    private Note_Patient_Picture[] Note_Patient_Picture;

    public void setNote_Patient_Picture(Note_Patient_Picture[] Note_Patient_Picture)
    {
        this.Note_Patient_Picture = Note_Patient_Picture;
    }
    public Note_Patient_Picture[] getNote_Patient_Picture()
    {
        return this.Note_Patient_Picture;
    }
}
