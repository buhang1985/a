package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetRequestTestItemsOfPatientHRRequest
{
    @JsonProperty(value = "testID")
    private String testID;

    public void setTestID(String testID)
    {
        this.testID = testID;
    }
    public String getTestID()
    {
        return this.testID;
    }
}
