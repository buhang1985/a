package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class FCFinePatientsDynamic
{
    @JsonProperty(value = "values")
    private ArrayOfFineValues values;
    @JsonProperty(value = "IndexName")
    private String IndexName;
    @JsonProperty(value = "Content")
    private String Content;

    public void setValues(ArrayOfFineValues values)
    {
        this.values = values;
    }
    public ArrayOfFineValues getValues()
    {
        return this.values;
    }
    public void setIndexName(String IndexName)
    {
        this.IndexName = IndexName;
    }
    public String getIndexName()
    {
        return this.IndexName;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
}
