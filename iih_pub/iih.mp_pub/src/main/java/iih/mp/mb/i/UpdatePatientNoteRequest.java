package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdatePatientNoteRequest
{
    @JsonProperty(value = "note")
    private DCPatientNote note;
    @JsonProperty(value = "updateMode")
    private Integer updateMode;

    public void setNote(DCPatientNote note)
    {
        this.note = note;
    }
    public DCPatientNote getNote()
    {
        return this.note;
    }
    public void setUpdateMode(Integer updateMode)
    {
        this.updateMode = updateMode;
    }
    public Integer getUpdateMode()
    {
        return this.updateMode;
    }
}
