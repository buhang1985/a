package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingDocumentsOfPatientHRResponse
{
    @JsonProperty(value = "GetNursingDocumentsOfPatientHRResult")
    private ArrayOfDCNursingDocument GetNursingDocumentsOfPatientHRResult;

    public void setGetNursingDocumentsOfPatientHRResult(ArrayOfDCNursingDocument GetNursingDocumentsOfPatientHRResult)
    {
        this.GetNursingDocumentsOfPatientHRResult = GetNursingDocumentsOfPatientHRResult;
    }
    public ArrayOfDCNursingDocument getGetNursingDocumentsOfPatientHRResult()
    {
        return this.GetNursingDocumentsOfPatientHRResult;
    }
}
