package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YZPosition
{
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "Code")
    private String Code;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "Mark")
    private String Mark;
    @JsonProperty(value = "SpellCode")
    private String SpellCode;
    @JsonProperty(value = "WbCode")
    private String WbCode;
    @JsonProperty(value = "InputCode")
    private String InputCode;
    @JsonProperty(value = "SortId")
    private String SortId;
    @JsonProperty(value = "ValidState")
    private String ValidState;
    @JsonProperty(value = "OperCode")
    private String OperCode;
    @JsonProperty(value = "OperDate")
    private String OperDate;

    public void setType(String Type)
    {
        this.Type = Type;
    }
    public String getType()
    {
        return this.Type;
    }
    public void setCode(String Code)
    {
        this.Code = Code;
    }
    public String getCode()
    {
        return this.Code;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setMark(String Mark)
    {
        this.Mark = Mark;
    }
    public String getMark()
    {
        return this.Mark;
    }
    public void setSpellCode(String SpellCode)
    {
        this.SpellCode = SpellCode;
    }
    public String getSpellCode()
    {
        return this.SpellCode;
    }
    public void setWbCode(String WbCode)
    {
        this.WbCode = WbCode;
    }
    public String getWbCode()
    {
        return this.WbCode;
    }
    public void setInputCode(String InputCode)
    {
        this.InputCode = InputCode;
    }
    public String getInputCode()
    {
        return this.InputCode;
    }
    public void setSortId(String SortId)
    {
        this.SortId = SortId;
    }
    public String getSortId()
    {
        return this.SortId;
    }
    public void setValidState(String ValidState)
    {
        this.ValidState = ValidState;
    }
    public String getValidState()
    {
        return this.ValidState;
    }
    public void setOperCode(String OperCode)
    {
        this.OperCode = OperCode;
    }
    public String getOperCode()
    {
        return this.OperCode;
    }
    public void setOperDate(String OperDate)
    {
        this.OperDate = OperDate;
    }
    public String getOperDate()
    {
        return this.OperDate;
    }
}
