package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class QueryInfusionPatrolRequest
{
    @JsonProperty(value = "encounterII")
    private String encounterII;

    public void setEncounterII(String encounterII)
    {
        this.encounterII = encounterII;
    }
    public String getEncounterII()
    {
        return this.encounterII;
    }
}
