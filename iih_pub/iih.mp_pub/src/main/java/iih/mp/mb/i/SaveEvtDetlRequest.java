package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveEvtDetlRequest
{
    @JsonProperty(value = "tour")
    private Evt_Detl tour;

    public void setTour(Evt_Detl tour)
    {
        this.tour = tour;
    }
    public Evt_Detl getTour()
    {
        return this.tour;
    }
}
