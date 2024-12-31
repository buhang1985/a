package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfTiWenDan_NewRequest
{
    @JsonProperty(value = "node")
    private NDCVitalSignNode node;

    public void setNode(NDCVitalSignNode node)
    {
        this.node = node;
    }
    public NDCVitalSignNode getNode()
    {
        return this.node;
    }
}
