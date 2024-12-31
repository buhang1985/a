package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DelRequestTestItemsOfPatientHRRequest
{
    @JsonProperty(value = "testNo")
    private String testNo;

    public void setTestNo(String testNo)
    {
        this.testNo = testNo;
    }
    public String getTestNo()
    {
        return this.testNo;
    }
}
