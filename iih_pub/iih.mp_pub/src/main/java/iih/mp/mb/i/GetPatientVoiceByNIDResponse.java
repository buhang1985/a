package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientVoiceByNIDResponse
{
    @JsonProperty(value = "GetPatientVoiceByNIDResult")
    private ArrayOfNote_Patient_Voice GetPatientVoiceByNIDResult;

    public void setGetPatientVoiceByNIDResult(ArrayOfNote_Patient_Voice GetPatientVoiceByNIDResult)
    {
        this.GetPatientVoiceByNIDResult = GetPatientVoiceByNIDResult;
    }
    public ArrayOfNote_Patient_Voice getGetPatientVoiceByNIDResult()
    {
        return this.GetPatientVoiceByNIDResult;
    }
}
