package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class SaveInsertNURSE_Blood_AcceptRequest
{
    @JsonProperty(value = "list")
    private ArrayOfString list;

    public void setList(ArrayOfString list)
    {
        this.list = list;
    }
    public ArrayOfString getList()
    {
        return this.list;
    }
}
