package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetFaShaoHighVitalSignResponse
{
    @JsonProperty(value = "GetFaShaoHighVitalSignResult")
    private ArrayOfDCUnExpectedItem GetFaShaoHighVitalSignResult;

    public void setGetFaShaoHighVitalSignResult(ArrayOfDCUnExpectedItem GetFaShaoHighVitalSignResult)
    {
        this.GetFaShaoHighVitalSignResult = GetFaShaoHighVitalSignResult;
    }
    public ArrayOfDCUnExpectedItem getGetFaShaoHighVitalSignResult()
    {
        return this.GetFaShaoHighVitalSignResult;
    }
}
