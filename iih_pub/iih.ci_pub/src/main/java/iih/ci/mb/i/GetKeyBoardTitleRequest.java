package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetKeyBoardTitleRequest
{
    @JsonProperty(value = "KBID")
    private String KBID;

    public void setKBID(String KBID)
    {
        this.KBID = KBID;
    }
    public String getKBID()
    {
        return this.KBID;
    }
}
