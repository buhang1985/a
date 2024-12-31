package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveAdviceTagCheckRequest
{
    @JsonProperty(value = "deptid")
    private String deptid;
    @JsonProperty(value = "nurseid")
    private String nurseid;
    @JsonProperty(value = "nursename")
    private String nursename;
    @JsonProperty(value = "adTagCheckArgsForTouchList")
    private ArrayOfDCAdviceTagCheckArgsForTouch adTagCheckArgsForTouchList;

    public void setDeptid(String deptid)
    {
        this.deptid = deptid;
    }
    public String getDeptid()
    {
        return this.deptid;
    }
    public void setNurseid(String nurseid)
    {
        this.nurseid = nurseid;
    }
    public String getNurseid()
    {
        return this.nurseid;
    }
    public void setNursename(String nursename)
    {
        this.nursename = nursename;
    }
    public String getNursename()
    {
        return this.nursename;
    }
    public void setAdTagCheckArgsForTouchList(ArrayOfDCAdviceTagCheckArgsForTouch adTagCheckArgsForTouchList)
    {
        this.adTagCheckArgsForTouchList = adTagCheckArgsForTouchList;
    }
    public ArrayOfDCAdviceTagCheckArgsForTouch getAdTagCheckArgsForTouchList()
    {
        return this.adTagCheckArgsForTouchList;
    }
}
