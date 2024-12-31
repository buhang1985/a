package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YZDepartment
{
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "SpellCode")
    private String SpellCode;

    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
    public void setSpellCode(String SpellCode)
    {
        this.SpellCode = SpellCode;
    }
    public String getSpellCode()
    {
        return this.SpellCode;
    }
}
