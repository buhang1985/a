package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Node_Template
{
    @JsonProperty(value = "TemplateID")
    private String TemplateID;
    @JsonProperty(value = "TemplateName")
    private String TemplateName;
    @JsonProperty(value = "TemplateContent")
    private String TemplateContent;
    @JsonProperty(value = "Fg_multy")
    private String Fg_multy;
    
    
    
    public String getFg_multy() {
		return Fg_multy;
	}
	public void setFg_multy(String fg_multy) {
		Fg_multy = fg_multy;
	}
	public void setTemplateID(String TemplateID)
    {
        this.TemplateID = TemplateID;
    }
    public String getTemplateID()
    {
        return this.TemplateID;
    }
    public void setTemplateName(String TemplateName)
    {
        this.TemplateName = TemplateName;
    }
    public String getTemplateName()
    {
        return this.TemplateName;
    }
    public void setTemplateContent(String TemplateContent)
    {
        this.TemplateContent = TemplateContent;
    }
    public String getTemplateContent()
    {
        return this.TemplateContent;
    }
}
