package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DeletePatientNoteNewResponse
{
    @JsonProperty(value = "DeletePatientNoteNewResult")
    private Boolean DeletePatientNoteNewResult;

    public void setDeletePatientNoteNewResult(Boolean DeletePatientNoteNewResult)
    {
        this.DeletePatientNoteNewResult = DeletePatientNoteNewResult;
    }
    public Boolean getDeletePatientNoteNewResult()
    {
        return this.DeletePatientNoteNewResult;
    }
}
