package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCBarcodeResult
{
    @JsonProperty(value = "Flag")
    private String Flag;
    @JsonProperty(value = "Content")
    private String Content;

    public void setFlag(String Flag)
    {
        this.Flag = Flag;
    }
    public String getFlag()
    {
        return this.Flag;
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
