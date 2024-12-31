package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCAdviceTagCheckArgsForTouch
{
    @JsonProperty(value = "AdviceID")
    private String AdviceID;
    @JsonProperty(value = "CombNo")
    private String CombNo;
    @JsonProperty(value = "TagPage")
    private String TagPage;
    @JsonProperty(value = "NurseID")
    private String NurseID;
    @JsonProperty(value = "NurseName")
    private String NurseName;
    @JsonProperty(value = "Undetermined")
    private String Undetermined;

    public void setAdviceID(String AdviceID)
    {
        this.AdviceID = AdviceID;
    }
    public String getAdviceID()
    {
        return this.AdviceID;
    }
    public void setCombNo(String CombNo)
    {
        this.CombNo = CombNo;
    }
    public String getCombNo()
    {
        return this.CombNo;
    }
    public void setTagPage(String TagPage)
    {
        this.TagPage = TagPage;
    }
    public String getTagPage()
    {
        return this.TagPage;
    }
    public void setNurseID(String NurseID)
    {
        this.NurseID = NurseID;
    }
    public String getNurseID()
    {
        return this.NurseID;
    }
    public void setNurseName(String NurseName)
    {
        this.NurseName = NurseName;
    }
    public String getNurseName()
    {
        return this.NurseName;
    }
    public void setUndetermined(String Undetermined)
    {
        this.Undetermined = Undetermined;
    }
    public String getUndetermined()
    {
        return this.Undetermined;
    }
}
