package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InsertIntoDoctorAdviceExecBackupResponse
{
    @JsonProperty(value = "InsertIntoDoctorAdviceExecBackupResult")
    private Boolean InsertIntoDoctorAdviceExecBackupResult;

    public void setInsertIntoDoctorAdviceExecBackupResult(Boolean InsertIntoDoctorAdviceExecBackupResult)
    {
        this.InsertIntoDoctorAdviceExecBackupResult = InsertIntoDoctorAdviceExecBackupResult;
    }
    public Boolean getInsertIntoDoctorAdviceExecBackupResult()
    {
        return this.InsertIntoDoctorAdviceExecBackupResult;
    }
}
