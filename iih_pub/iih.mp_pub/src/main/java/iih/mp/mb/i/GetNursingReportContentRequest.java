package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingReportContentRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "templateId")
    private String templateId;
    @JsonProperty(value = "docId")
    private String docId;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }
    public String getTemplateId()
    {
        return this.templateId;
    }
    public void setDocId(String docId)
    {
        this.docId = docId;
    }
    public String getDocId()
    {
        return this.docId;
    }
}
