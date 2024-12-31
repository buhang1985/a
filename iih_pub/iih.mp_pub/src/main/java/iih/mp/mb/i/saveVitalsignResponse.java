package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class saveVitalsignResponse
{
    @JsonProperty(value = "saveVitalsignResult")
    private Boolean saveVitalsignResult;

    public void setSaveVitalsignResult(Boolean saveVitalsignResult)
    {
        this.saveVitalsignResult = saveVitalsignResult;
    }
    public Boolean getSaveVitalsignResult()
    {
        return this.saveVitalsignResult;
    }
}
