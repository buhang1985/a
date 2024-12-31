package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveNurseDispensationRequest
{
    @JsonProperty(value = "dispenlist")
    private ArrayOfNurseDispensation dispenlist;

    public void setDispenlist(ArrayOfNurseDispensation dispenlist)
    {
        this.dispenlist = dispenlist;
    }
    public ArrayOfNurseDispensation getDispenlist()
    {
        return this.dispenlist;
    }
}
