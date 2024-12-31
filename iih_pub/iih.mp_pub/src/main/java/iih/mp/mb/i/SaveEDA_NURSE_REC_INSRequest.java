package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveEDA_NURSE_REC_INSRequest
{
    @JsonProperty(value = "model")
    private DCNURSERECORD model;

    public void setModel(DCNURSERECORD model)
    {
        this.model = model;
    }
    public DCNURSERECORD getModel()
    {
        return this.model;
    }
}
