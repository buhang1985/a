package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllKeyBoardRequest
{
    @JsonProperty(value = "TemplateID")
    private String TemplateID;

    public void setTemplateID(String TemplateID)
    {
        this.TemplateID = TemplateID;
    }
    public String getTemplateID()
    {
        return this.TemplateID;
    }
}
