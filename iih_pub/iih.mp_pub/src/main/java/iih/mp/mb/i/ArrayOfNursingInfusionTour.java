package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNursingInfusionTour
{
    @JsonProperty(value = "NursingInfusionTour")
    private NursingInfusionTour[] NursingInfusionTour;

    public void setNursingInfusionTour(NursingInfusionTour[] NursingInfusionTour)
    {
        this.NursingInfusionTour = NursingInfusionTour;
    }
    public NursingInfusionTour[] getNursingInfusionTour()
    {
        return this.NursingInfusionTour;
    }
}
