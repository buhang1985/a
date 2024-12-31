package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCRecentlyVitalSignNode
{
    @JsonProperty(value = "ValueType")
    private String ValueType;
    @JsonProperty(value = "FvitalSignNode")
    private DCVitalSignNode FvitalSignNode;
    @JsonProperty(value = "SvitalSignNode")
    private DCVitalSignNode SvitalSignNode;
    @JsonProperty(value = "TvitalSignNode")
    private DCVitalSignNode TvitalSignNode;

    public void setValueType(String ValueType)
    {
        this.ValueType = ValueType;
    }
    public String getValueType()
    {
        return this.ValueType;
    }
    public void setFvitalSignNode(DCVitalSignNode FvitalSignNode)
    {
        this.FvitalSignNode = FvitalSignNode;
    }
    public DCVitalSignNode getFvitalSignNode()
    {
        return this.FvitalSignNode;
    }
    public void setSvitalSignNode(DCVitalSignNode SvitalSignNode)
    {
        this.SvitalSignNode = SvitalSignNode;
    }
    public DCVitalSignNode getSvitalSignNode()
    {
        return this.SvitalSignNode;
    }
    public void setTvitalSignNode(DCVitalSignNode TvitalSignNode)
    {
        this.TvitalSignNode = TvitalSignNode;
    }
    public DCVitalSignNode getTvitalSignNode()
    {
        return this.TvitalSignNode;
    }
}
