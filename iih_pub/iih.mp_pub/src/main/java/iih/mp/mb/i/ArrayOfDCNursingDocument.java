package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNursingDocument
{
    @JsonProperty(value = "DCNursingDocument")
    private DCNursingDocument[] DCNursingDocument;

    public void setDCNursingDocument(DCNursingDocument[] DCNursingDocument)
    {
        this.DCNursingDocument = DCNursingDocument;
    }
    public DCNursingDocument[] getDCNursingDocument()
    {
        return this.DCNursingDocument;
    }
}
