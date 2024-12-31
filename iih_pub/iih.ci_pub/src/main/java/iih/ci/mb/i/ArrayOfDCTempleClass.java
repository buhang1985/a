package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCTempleClass
{
    @JsonProperty(value = "DCTempleClass")
    private DCTempleClass[] DCTempleClass;

    public void setDCTempleClass(DCTempleClass[] DCTempleClass)
    {
        this.DCTempleClass = DCTempleClass;
    }
    public DCTempleClass[] getDCTempleClass()
    {
        return this.DCTempleClass;
    }
}
