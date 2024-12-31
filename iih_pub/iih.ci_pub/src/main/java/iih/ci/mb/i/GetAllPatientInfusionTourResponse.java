package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllPatientInfusionTourResponse
{
    @JsonProperty(value = "GetAllPatientInfusionTourResult")
    private ArrayOfNursingInfusionTour GetAllPatientInfusionTourResult;

    public void setGetAllPatientInfusionTourResult(ArrayOfNursingInfusionTour GetAllPatientInfusionTourResult)
    {
        this.GetAllPatientInfusionTourResult = GetAllPatientInfusionTourResult;
    }
    public ArrayOfNursingInfusionTour getGetAllPatientInfusionTourResult()
    {
        return this.GetAllPatientInfusionTourResult;
    }
}
