package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class QueryNursingPatrolResponse
{
    @JsonProperty(value = "QueryNursingPatrolResult")
    private ArrayOfDCNursingPatrol QueryNursingPatrolResult;

    public void setQueryNursingPatrolResult(ArrayOfDCNursingPatrol QueryNursingPatrolResult)
    {
        this.QueryNursingPatrolResult = QueryNursingPatrolResult;
    }
    public ArrayOfDCNursingPatrol getQueryNursingPatrolResult()
    {
        return this.QueryNursingPatrolResult;
    }
}
