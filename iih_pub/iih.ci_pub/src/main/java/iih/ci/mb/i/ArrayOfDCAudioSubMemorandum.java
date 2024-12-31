package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCAudioSubMemorandum
{
    @JsonProperty(value = "DCAudioSubMemorandum")
    private DCAudioSubMemorandum[] DCAudioSubMemorandum;

    public void setDCAudioSubMemorandum(DCAudioSubMemorandum[] DCAudioSubMemorandum)
    {
        this.DCAudioSubMemorandum = DCAudioSubMemorandum;
    }
    public DCAudioSubMemorandum[] getDCAudioSubMemorandum()
    {
        return this.DCAudioSubMemorandum;
    }
}
