package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTSUser
{
    @JsonProperty(value = "TSUser")
    private TSUser[] TSUser;

    public void setTSUser(TSUser[] TSUser)
    {
        this.TSUser = TSUser;
    }
    public TSUser[] getTSUser()
    {
        return this.TSUser;
    }
}
