package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class SaveINT_EDA_BLOOD_HANDOVERRequest
{
    @JsonProperty(value = "list")
    private ArrayOfString list;
    @JsonProperty(value = "flag")
    private String flag;

    public void setList(ArrayOfString list)
    {
        this.list = list;
    }
    public ArrayOfString getList()
    {
        return this.list;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    public String getFlag()
    {
        return this.flag;
    }
}
