package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTSNurseWorkStatistics
{
    @JsonProperty(value = "TSNurseWorkStatistics")
    private TSNurseWorkStatistics[] TSNurseWorkStatistics;

    public void setTSNurseWorkStatistics(TSNurseWorkStatistics[] TSNurseWorkStatistics)
    {
        this.TSNurseWorkStatistics = TSNurseWorkStatistics;
    }
    public TSNurseWorkStatistics[] getTSNurseWorkStatistics()
    {
        return this.TSNurseWorkStatistics;
    }
}
