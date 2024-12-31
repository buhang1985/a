package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SavePatientNursingTourCommentResponse
{
    @JsonProperty(value = "SavePatientNursingTourCommentResult")
    private Boolean SavePatientNursingTourCommentResult;

    public void setSavePatientNursingTourCommentResult(Boolean SavePatientNursingTourCommentResult)
    {
        this.SavePatientNursingTourCommentResult = SavePatientNursingTourCommentResult;
    }
    public Boolean getSavePatientNursingTourCommentResult()
    {
        return this.SavePatientNursingTourCommentResult;
    }
}
