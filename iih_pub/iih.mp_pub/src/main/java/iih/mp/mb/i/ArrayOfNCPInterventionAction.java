package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfNCPInterventionAction
{
    @JsonProperty(value = "NCPInterventionAction")
    private NCPInterventionAction[] NCPInterventionAction;

    public void setNCPInterventionAction(NCPInterventionAction[] NCPInterventionAction)
    {
        this.NCPInterventionAction = NCPInterventionAction;
    }
    public NCPInterventionAction[] getNCPInterventionAction()
    {
        return this.NCPInterventionAction;
    }
}
