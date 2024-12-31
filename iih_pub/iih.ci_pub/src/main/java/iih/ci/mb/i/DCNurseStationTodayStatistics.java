package iih.ci.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfInt;
import xap.sys.mb.i.ArrayOfString;

public class DCNurseStationTodayStatistics
{
    @JsonProperty(value = "PatientInHos")
    private Integer PatientInHos;
    @JsonProperty(value = "MyPatientInHos")
    private Integer MyPatientInHos;
    @JsonProperty(value = "PatientEnterHos")
    private Integer PatientEnterHos;
    @JsonProperty(value = "PatientExitHos")
    private Integer PatientExitHos;
    @JsonProperty(value = "PatientTransfer")
    private Integer PatientTransfer;
    @JsonProperty(value = "UseBedCount")
    private Integer UseBedCount;
    @JsonProperty(value = "UnuseBedCount")
    private Integer UnuseBedCount;
    @JsonProperty(value = "DoctorOrderCount")
    private Integer DoctorOrderCount;
    @JsonProperty(value = "DoctorOrderStateTitle")
    private ArrayOfString DoctorOrderStateTitle;
    @JsonProperty(value = "DoctorOrderStateCount")
    private ArrayOfInt DoctorOrderStateCount;
    @JsonProperty(value = "FinishDoctorOrderCount")
    private Integer FinishDoctorOrderCount;
    @JsonProperty(value = "UnFinishDoctorOrderCount")
    private Integer UnFinishDoctorOrderCount;
    @JsonProperty(value = "CareLevelAndStateTitle")
    private ArrayOfString CareLevelAndStateTitle;
    @JsonProperty(value = "CareLevelAndStateCount")
    private ArrayOfInt CareLevelAndStateCount;
    @JsonProperty(value = "NotificationList")
    private ArrayOfDCNurseStationNotification NotificationList;

    public void setPatientInHos(Integer PatientInHos)
    {
        this.PatientInHos = PatientInHos;
    }
    public Integer getPatientInHos()
    {
        return this.PatientInHos;
    }
    public void setMyPatientInHos(Integer MyPatientInHos)
    {
        this.MyPatientInHos = MyPatientInHos;
    }
    public Integer getMyPatientInHos()
    {
        return this.MyPatientInHos;
    }
    public void setPatientEnterHos(Integer PatientEnterHos)
    {
        this.PatientEnterHos = PatientEnterHos;
    }
    public Integer getPatientEnterHos()
    {
        return this.PatientEnterHos;
    }
    public void setPatientExitHos(Integer PatientExitHos)
    {
        this.PatientExitHos = PatientExitHos;
    }
    public Integer getPatientExitHos()
    {
        return this.PatientExitHos;
    }
    public void setPatientTransfer(Integer PatientTransfer)
    {
        this.PatientTransfer = PatientTransfer;
    }
    public Integer getPatientTransfer()
    {
        return this.PatientTransfer;
    }
    public void setUseBedCount(Integer UseBedCount)
    {
        this.UseBedCount = UseBedCount;
    }
    public Integer getUseBedCount()
    {
        return this.UseBedCount;
    }
    public void setUnuseBedCount(Integer UnuseBedCount)
    {
        this.UnuseBedCount = UnuseBedCount;
    }
    public Integer getUnuseBedCount()
    {
        return this.UnuseBedCount;
    }
    public void setDoctorOrderCount(Integer DoctorOrderCount)
    {
        this.DoctorOrderCount = DoctorOrderCount;
    }
    public Integer getDoctorOrderCount()
    {
        return this.DoctorOrderCount;
    }
    public void setDoctorOrderStateTitle(ArrayOfString DoctorOrderStateTitle)
    {
        this.DoctorOrderStateTitle = DoctorOrderStateTitle;
    }
    public ArrayOfString getDoctorOrderStateTitle()
    {
        return this.DoctorOrderStateTitle;
    }
    public void setDoctorOrderStateCount(ArrayOfInt DoctorOrderStateCount)
    {
        this.DoctorOrderStateCount = DoctorOrderStateCount;
    }
    public ArrayOfInt getDoctorOrderStateCount()
    {
        return this.DoctorOrderStateCount;
    }
    public void setFinishDoctorOrderCount(Integer FinishDoctorOrderCount)
    {
        this.FinishDoctorOrderCount = FinishDoctorOrderCount;
    }
    public Integer getFinishDoctorOrderCount()
    {
        return this.FinishDoctorOrderCount;
    }
    public void setUnFinishDoctorOrderCount(Integer UnFinishDoctorOrderCount)
    {
        this.UnFinishDoctorOrderCount = UnFinishDoctorOrderCount;
    }
    public Integer getUnFinishDoctorOrderCount()
    {
        return this.UnFinishDoctorOrderCount;
    }
    public void setCareLevelAndStateTitle(ArrayOfString CareLevelAndStateTitle)
    {
        this.CareLevelAndStateTitle = CareLevelAndStateTitle;
    }
    public ArrayOfString getCareLevelAndStateTitle()
    {
        return this.CareLevelAndStateTitle;
    }
    public void setCareLevelAndStateCount(ArrayOfInt CareLevelAndStateCount)
    {
        this.CareLevelAndStateCount = CareLevelAndStateCount;
    }
    public ArrayOfInt getCareLevelAndStateCount()
    {
        return this.CareLevelAndStateCount;
    }
    public void setNotificationList(ArrayOfDCNurseStationNotification NotificationList)
    {
        this.NotificationList = NotificationList;
    }
    public ArrayOfDCNurseStationNotification getNotificationList()
    {
        return this.NotificationList;
    }
}
