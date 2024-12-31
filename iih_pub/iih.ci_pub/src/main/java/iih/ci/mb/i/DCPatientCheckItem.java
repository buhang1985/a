package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientCheckItem
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "ExamID")
    private String ExamID;
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "Doctor")
    private String Doctor;
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "Project")
    private String Project;
    @JsonProperty(value = "ProjectItemCode")
    private String ProjectItemCode;
    @JsonProperty(value = "Price")
    private String Price;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setExamID(String ExamID)
    {
        this.ExamID = ExamID;
    }
    public String getExamID()
    {
        return this.ExamID;
    }
    public void setDeptCode(String DeptCode)
    {
        this.DeptCode = DeptCode;
    }
    public String getDeptCode()
    {
        return this.DeptCode;
    }
    public void setDoctor(String Doctor)
    {
        this.Doctor = Doctor;
    }
    public String getDoctor()
    {
        return this.Doctor;
    }
    public void setType(String Type)
    {
        this.Type = Type;
    }
    public String getType()
    {
        return this.Type;
    }
    public void setProject(String Project)
    {
        this.Project = Project;
    }
    public String getProject()
    {
        return this.Project;
    }
    public void setProjectItemCode(String ProjectItemCode)
    {
        this.ProjectItemCode = ProjectItemCode;
    }
    public String getProjectItemCode()
    {
        return this.ProjectItemCode;
    }
    public void setPrice(String Price)
    {
        this.Price = Price;
    }
    public String getPrice()
    {
        return this.Price;
    }
}
