package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.DCUser;

public class PCAddUserRequest
{
    @JsonProperty(value = "user")
    private DCUser user;

    public void setUser(DCUser user)
    {
        this.user = user;
    }
    public DCUser getUser()
    {
        return this.user;
    }
}
