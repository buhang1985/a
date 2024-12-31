package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientTodayInfusionTourResponse
{
    @JsonProperty(value = "GetPatientTodayInfusionTourResult")
    private ArrayOfNursingInfusionTour GetPatientTodayInfusionTourResult;

    public void setGetPatientTodayInfusionTourResult(ArrayOfNursingInfusionTour GetPatientTodayInfusionTourResult)
    {
        this.GetPatientTodayInfusionTourResult = GetPatientTodayInfusionTourResult;
    }
    public ArrayOfNursingInfusionTour getGetPatientTodayInfusionTourResult()
    {
        return this.GetPatientTodayInfusionTourResult;
    }
}
