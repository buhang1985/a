package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCInfusionPatrol
{
    @JsonProperty(value = "DCInfusionPatrol")
    private DCInfusionPatrol[] DCInfusionPatrol;

    public void setDCInfusionPatrol(DCInfusionPatrol[] DCInfusionPatrol)
    {
        this.DCInfusionPatrol = DCInfusionPatrol;
    }
    public DCInfusionPatrol[] getDCInfusionPatrol()
    {
        return this.DCInfusionPatrol;
    }
}
