package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetTestItemsOfPatientHRRequest
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
