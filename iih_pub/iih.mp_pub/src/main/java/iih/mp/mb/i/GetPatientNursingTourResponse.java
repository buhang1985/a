package iih.mp.mb.i;


import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientNursingTourResponse
{
    @JsonProperty(value = "GetPatientNursingTourResult")
    private ArrayOfDCNursingTour GetPatientNursingTourResult;

    public void setGetPatientNursingTourResult(ArrayOfDCNursingTour GetPatientNursingTourResult)
    {
        this.GetPatientNursingTourResult = GetPatientNursingTourResult;
    }
    public ArrayOfDCNursingTour getGetPatientNursingTourResult()
    {
        return this.GetPatientNursingTourResult;
    }
}
