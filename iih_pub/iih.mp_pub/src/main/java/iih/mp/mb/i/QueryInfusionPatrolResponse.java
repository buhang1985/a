package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class QueryInfusionPatrolResponse
{
    @JsonProperty(value = "QueryInfusionPatrolResult")
    private ArrayOfDCInfusionPatrol QueryInfusionPatrolResult;

    public void setQueryInfusionPatrolResult(ArrayOfDCInfusionPatrol QueryInfusionPatrolResult)
    {
        this.QueryInfusionPatrolResult = QueryInfusionPatrolResult;
    }
    public ArrayOfDCInfusionPatrol getQueryInfusionPatrolResult()
    {
        return this.QueryInfusionPatrolResult;
    }
}
