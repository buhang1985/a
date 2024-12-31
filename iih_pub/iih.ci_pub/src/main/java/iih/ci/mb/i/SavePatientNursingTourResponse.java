package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SavePatientNursingTourResponse
{
    @JsonProperty(value = "SavePatientNursingTourResult")
    private Boolean SavePatientNursingTourResult;

    public void setSavePatientNursingTourResult(Boolean SavePatientNursingTourResult)
    {
        this.SavePatientNursingTourResult = SavePatientNursingTourResult;
    }
    public Boolean getSavePatientNursingTourResult()
    {
        return this.SavePatientNursingTourResult;
    }
}
