package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTemplateNode
{
    @JsonProperty(value = "TemplateNode")
    private TemplateNode[] TemplateNode;

    public void setTemplateNode(TemplateNode[] TemplateNode)
    {
        this.TemplateNode = TemplateNode;
    }
    public TemplateNode[] getTemplateNode()
    {
        return this.TemplateNode;
    }
}
