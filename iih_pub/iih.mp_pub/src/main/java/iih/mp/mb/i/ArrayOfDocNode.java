package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDocNode
{
    @JsonProperty(value = "DocNode")
    private DocNode[] DocNode;

    public void setDocNode(DocNode[] DocNode)
    {
        this.DocNode = DocNode;
    }
    public DocNode[] getDocNode()
    {
        return this.DocNode;
    }
}
