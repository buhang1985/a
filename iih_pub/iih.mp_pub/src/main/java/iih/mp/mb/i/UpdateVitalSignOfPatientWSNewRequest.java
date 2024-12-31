package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfPatientWSNewRequest
{
    @JsonProperty(value = "docnode")
    private ArrayOfDocNode docnode;
    @JsonProperty(value = "nid")
    private String nid;

    public void setDocnode(ArrayOfDocNode docnode)
    {
        this.docnode = docnode;
    }
    public ArrayOfDocNode getDocnode()
    {
        return this.docnode;
    }
    public void setNid(String nid)
    {
        this.nid = nid;
    }
    public String getNid()
    {
        return this.nid;
    }
}
