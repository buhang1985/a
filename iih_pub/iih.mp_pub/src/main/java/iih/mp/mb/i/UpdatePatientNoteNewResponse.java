package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdatePatientNoteNewResponse
{
    @JsonProperty(value = "UpdatePatientNoteNewResult")
    private Boolean UpdatePatientNoteNewResult;

    public void setUpdatePatientNoteNewResult(Boolean UpdatePatientNoteNewResult)
    {
        this.UpdatePatientNoteNewResult = UpdatePatientNoteNewResult;
    }
    public Boolean getUpdatePatientNoteNewResult()
    {
        return this.UpdatePatientNoteNewResult;
    }
}
