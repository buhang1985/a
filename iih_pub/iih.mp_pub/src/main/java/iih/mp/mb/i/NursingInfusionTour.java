package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NursingInfusionTour
{
    @JsonProperty(value = "RecordId")
    private String RecordId;
    @JsonProperty(value = "NursingTourID")
    private String NursingTourID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "RecordNurseID")
    private String RecordNurseID;
    @JsonProperty(value = "RecordNurseName")
    private String RecordNurseName;
    @JsonProperty(value = "RecordDateTime")
    private String RecordDateTime;
    @JsonProperty(value = "RecordDeptID")
    private String RecordDeptID;
    @JsonProperty(value = "RecordDeptName")
    private String RecordDeptName;
    @JsonProperty(value = "Comment")
    private String Comment;
    @JsonProperty(value = "BedNo")
    private String BedNo;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "CaseID")
    private String CaseID;
    @JsonProperty(value = "OrderContent")
    private String OrderContent;
    @JsonProperty(value = "OrderDosage")
    private String OrderDosage;
    @JsonProperty(value = "OrderUnit")
    private String OrderUnit;
    @JsonProperty(value = "OrderUsage")
    private String OrderUsage;
    @JsonProperty(value = "OrderFre")
    private String OrderFre;
    @JsonProperty(value = "OrderExeFlag")
    private String OrderExeFlag;
    @JsonProperty(value = "OrderGroupID")
    private String OrderGroupID;
    @JsonProperty(value = "OrderUseTime")
    private String OrderUseTime;
    @JsonProperty(value = "OrderExeTime")
    private String OrderExeTime;
    @JsonProperty(value = "SpeedValue")
    private String SpeedValue;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "Evt_id")
    private String Evt_id;
    @JsonProperty(value = "Note")
    private String Note;
    @JsonProperty(value = "WasteAmt")
    private String WasteAmt;
    @JsonProperty(value = "multi_flag")
    private String multi_flag;

    public void setRecordId(String RecordId)
    {
        this.RecordId = RecordId;
    }
    public String getRecordId()
    {
        return this.RecordId;
    }
    public void setNursingTourID(String NursingTourID)
    {
        this.NursingTourID = NursingTourID;
    }
    public String getNursingTourID()
    {
        return this.NursingTourID;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setVisitID(String VisitID)
    {
        this.VisitID = VisitID;
    }
    public String getVisitID()
    {
        return this.VisitID;
    }
    public void setRecordNurseID(String RecordNurseID)
    {
        this.RecordNurseID = RecordNurseID;
    }
    public String getRecordNurseID()
    {
        return this.RecordNurseID;
    }
    public void setRecordNurseName(String RecordNurseName)
    {
        this.RecordNurseName = RecordNurseName;
    }
    public String getRecordNurseName()
    {
        return this.RecordNurseName;
    }
    public void setRecordDateTime(String RecordDateTime)
    {
        this.RecordDateTime = RecordDateTime;
    }
    public String getRecordDateTime()
    {
        return this.RecordDateTime;
    }
    public void setRecordDeptID(String RecordDeptID)
    {
        this.RecordDeptID = RecordDeptID;
    }
    public String getRecordDeptID()
    {
        return this.RecordDeptID;
    }
    public void setRecordDeptName(String RecordDeptName)
    {
        this.RecordDeptName = RecordDeptName;
    }
    public String getRecordDeptName()
    {
        return this.RecordDeptName;
    }
    public void setComment(String Comment)
    {
        this.Comment = Comment;
    }
    public String getComment()
    {
        return this.Comment;
    }
    public void setBedNo(String BedNo)
    {
        this.BedNo = BedNo;
    }
    public String getBedNo()
    {
        return this.BedNo;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setCaseID(String CaseID)
    {
        this.CaseID = CaseID;
    }
    public String getCaseID()
    {
        return this.CaseID;
    }
    public void setOrderContent(String OrderContent)
    {
        this.OrderContent = OrderContent;
    }
    public String getOrderContent()
    {
        return this.OrderContent;
    }
    public void setOrderDosage(String OrderDosage)
    {
        this.OrderDosage = OrderDosage;
    }
    public String getOrderDosage()
    {
        return this.OrderDosage;
    }
    public void setOrderUnit(String OrderUnit)
    {
        this.OrderUnit = OrderUnit;
    }
    public String getOrderUnit()
    {
        return this.OrderUnit;
    }
    public void setOrderUsage(String OrderUsage)
    {
        this.OrderUsage = OrderUsage;
    }
    public String getOrderUsage()
    {
        return this.OrderUsage;
    }
    public void setOrderFre(String OrderFre)
    {
        this.OrderFre = OrderFre;
    }
    public String getOrderFre()
    {
        return this.OrderFre;
    }
    public void setOrderExeFlag(String OrderExeFlag)
    {
        this.OrderExeFlag = OrderExeFlag;
    }
    public String getOrderExeFlag()
    {
        return this.OrderExeFlag;
    }
    public void setOrderGroupID(String OrderGroupID)
    {
        this.OrderGroupID = OrderGroupID;
    }
    public String getOrderGroupID()
    {
        return this.OrderGroupID;
    }
    public void setOrderUseTime(String OrderUseTime)
    {
        this.OrderUseTime = OrderUseTime;
    }
    public String getOrderUseTime()
    {
        return this.OrderUseTime;
    }
    public void setOrderExeTime(String OrderExeTime)
    {
        this.OrderExeTime = OrderExeTime;
    }
    public String getOrderExeTime()
    {
        return this.OrderExeTime;
    }
    public void setSpeedValue(String SpeedValue)
    {
        this.SpeedValue = SpeedValue;
    }
    public String getSpeedValue()
    {
        return this.SpeedValue;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setEvt_id(String Evt_id)
    {
        this.Evt_id = Evt_id;
    }
    public String getEvt_id()
    {
        return this.Evt_id;
    }
    public void setNote(String Note)
    {
        this.Note = Note;
    }
    public String getNote()
    {
        return this.Note;
    }
    public void setWasteAmt(String WasteAmt)
    {
        this.WasteAmt = WasteAmt;
    }
    public String getWasteAmt()
    {
        return this.WasteAmt;
    }
    public void setMulti_flag(String multi_flag)
    {
        this.multi_flag = multi_flag;
    }
    public String getMulti_flag()
    {
        return this.multi_flag;
    }
}
