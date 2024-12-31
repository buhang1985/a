package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.DCUser;

public class ArrayOfDCUser
{
    @JsonProperty(value = "DCUser")
    private DCUser[] DCUser;

    public void setDCUser(DCUser[] DCUser)
    {
        this.DCUser = DCUser;
    }
    public DCUser[] getDCUser()
    {
        return this.DCUser;
    }
}
