package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNode_Template
{
    @JsonProperty(value = "Node_Template")
    private Node_Template[] Node_Template;

    public void setNode_Template(Node_Template[] Node_Template)
    {
        this.Node_Template = Node_Template;
    }
    public Node_Template[] getNode_Template()
    {
        return this.Node_Template;
    }
}
