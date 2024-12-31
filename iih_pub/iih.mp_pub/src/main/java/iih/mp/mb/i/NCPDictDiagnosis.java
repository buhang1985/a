package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NCPDictDiagnosis
{
    @JsonProperty(value = "DiagnosisId")
    private String DiagnosisId;
    @JsonProperty(value = "DiagnosisCode")
    private String DiagnosisCode;
    @JsonProperty(value = "DiagnosisName")
    private String DiagnosisName;
    @JsonProperty(value = "PyCode")
    private String PyCode;
    @JsonProperty(value = "WbCode")
    private String WbCode;
    @JsonProperty(value = "Priority")
    private String Priority;
    @JsonProperty(value = "DeleteFlag")
    private String DeleteFlag;
    @JsonProperty(value = "PlPk")
    private String PlPk;
    @JsonProperty(value = "factorList")
    private ArrayOfNCPDictFactor factorList;
    @JsonProperty(value = "goalList")
    private ArrayOfNCPDictGoal goalList;
    @JsonProperty(value = "interventionActionList")
    private ArrayOfNCPInterventionAction interventionActionList;

    public void setDiagnosisId(String DiagnosisId)
    {
        this.DiagnosisId = DiagnosisId;
    }
    public String getDiagnosisId()
    {
        return this.DiagnosisId;
    }
    public void setDiagnosisCode(String DiagnosisCode)
    {
        this.DiagnosisCode = DiagnosisCode;
    }
    public String getDiagnosisCode()
    {
        return this.DiagnosisCode;
    }
    public void setDiagnosisName(String DiagnosisName)
    {
        this.DiagnosisName = DiagnosisName;
    }
    public String getDiagnosisName()
    {
        return this.DiagnosisName;
    }
    public void setPyCode(String PyCode)
    {
        this.PyCode = PyCode;
    }
    public String getPyCode()
    {
        return this.PyCode;
    }
    public void setWbCode(String WbCode)
    {
        this.WbCode = WbCode;
    }
    public String getWbCode()
    {
        return this.WbCode;
    }
    public void setPriority(String Priority)
    {
        this.Priority = Priority;
    }
    public String getPriority()
    {
        return this.Priority;
    }
    public void setDeleteFlag(String DeleteFlag)
    {
        this.DeleteFlag = DeleteFlag;
    }
    public String getDeleteFlag()
    {
        return this.DeleteFlag;
    }
    public void setPlPk(String PlPk)
    {
        this.PlPk = PlPk;
    }
    public String getPlPk()
    {
        return this.PlPk;
    }
    public void setFactorList(ArrayOfNCPDictFactor factorList)
    {
        this.factorList = factorList;
    }
    public ArrayOfNCPDictFactor getFactorList()
    {
        return this.factorList;
    }
    public void setGoalList(ArrayOfNCPDictGoal goalList)
    {
        this.goalList = goalList;
    }
    public ArrayOfNCPDictGoal getGoalList()
    {
        return this.goalList;
    }
    public void setInterventionActionList(ArrayOfNCPInterventionAction interventionActionList)
    {
        this.interventionActionList = interventionActionList;
    }
    public ArrayOfNCPInterventionAction getInterventionActionList()
    {
        return this.interventionActionList;
    }
}
