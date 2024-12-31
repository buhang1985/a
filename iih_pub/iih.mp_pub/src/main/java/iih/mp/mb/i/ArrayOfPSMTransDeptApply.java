package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfPSMTransDeptApply
{
    @JsonProperty(value = "PSMTransDeptApply")
    private PSMTransDeptApply[] PSMTransDeptApply;

    public void setPSMTransDeptApply(PSMTransDeptApply[] PSMTransDeptApply)
    {
        this.PSMTransDeptApply = PSMTransDeptApply;
    }
    public PSMTransDeptApply[] getPSMTransDeptApply()
    {
        return this.PSMTransDeptApply;
    }
}
