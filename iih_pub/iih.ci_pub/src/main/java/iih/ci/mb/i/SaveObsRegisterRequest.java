package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveObsRegisterRequest
{
    @JsonProperty(value = "model")
    private DCConsultRegister model;

    public void setModel(DCConsultRegister model)
    {
        this.model = model;
    }
    public DCConsultRegister getModel()
    {
        return this.model;
    }
}
