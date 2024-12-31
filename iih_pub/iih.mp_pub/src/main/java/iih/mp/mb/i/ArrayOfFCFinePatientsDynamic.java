package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfFCFinePatientsDynamic
{
    @JsonProperty(value = "FCFinePatientsDynamic")
    private FCFinePatientsDynamic[] FCFinePatientsDynamic;

    public void setFCFinePatientsDynamic(FCFinePatientsDynamic[] FCFinePatientsDynamic)
    {
        this.FCFinePatientsDynamic = FCFinePatientsDynamic;
    }
    public FCFinePatientsDynamic[] getFCFinePatientsDynamic()
    {
        return this.FCFinePatientsDynamic;
    }
}
