package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientOperationSchedule
{
    @JsonProperty(value = "ScheduleID")
    private String ScheduleID;
    @JsonProperty(value = "patientID")
    private String patientID;
    @JsonProperty(value = "patientVisitID")
    private String patientVisitID;
    @JsonProperty(value = "patientBedNo")
    private String patientBedNo;
    @JsonProperty(value = "patientDepartmentCode")
    private String patientDepartmentCode;
    @JsonProperty(value = "ItemList")
    private ArrayOfDCPatientOperationScheduleItem ItemList;
    @JsonProperty(value = "InfectionList")
    private ArrayOfDCPatientOperationInfection InfectionList;
    @JsonProperty(value = "DiagBeforeOperation")
    private String DiagBeforeOperation;
    @JsonProperty(value = "PatientCondition")
    private String PatientCondition;
    @JsonProperty(value = "ScheduledDateTime")
    private String ScheduledDateTime;
    @JsonProperty(value = "OperatingRoomDeptCode")
    private String OperatingRoomDeptCode;
    @JsonProperty(value = "OperatingRoom")
    private String OperatingRoom;
    @JsonProperty(value = "AckIndicator")
    private String AckIndicator;
    @JsonProperty(value = "OperatingRoomNo")
    private String OperatingRoomNo;
    @JsonProperty(value = "Sequence")
    private String Sequence;
    @JsonProperty(value = "IsolationIndicator")
    private String IsolationIndicator;
    @JsonProperty(value = "OperationScale")
    private String OperationScale;
    @JsonProperty(value = "OperatingDept")
    private String OperatingDept;
    @JsonProperty(value = "OperatingDeptCode")
    private String OperatingDeptCode;
    @JsonProperty(value = "Surgeon")
    private String Surgeon;
    @JsonProperty(value = "EnteredBy")
    private String EnteredBy;
    @JsonProperty(value = "FirstAssistant")
    private String FirstAssistant;
    @JsonProperty(value = "SecondAssistant")
    private String SecondAssistant;
    @JsonProperty(value = "ThirdAssistant")
    private String ThirdAssistant;
    @JsonProperty(value = "FourthAssistant")
    private String FourthAssistant;
    @JsonProperty(value = "BloodTranDoctor")
    private String BloodTranDoctor;
    @JsonProperty(value = "AnesthesiaMethod")
    private String AnesthesiaMethod;
    @JsonProperty(value = "AnesthesiaDoctor")
    private String AnesthesiaDoctor;
    @JsonProperty(value = "AnesthesiaAssistant")
    private String AnesthesiaAssistant;
    @JsonProperty(value = "FirstOperationNurse")
    private String FirstOperationNurse;
    @JsonProperty(value = "SecondOperationNurse")
    private String SecondOperationNurse;
    @JsonProperty(value = "FirstSupplyNurse")
    private String FirstSupplyNurse;
    @JsonProperty(value = "SecondSupplyNurse")
    private String SecondSupplyNurse;
    @JsonProperty(value = "ReqDateTime")
    private String ReqDateTime;
    @JsonProperty(value = "NotesOnOperation")
    private String NotesOnOperation;

    public void setScheduleID(String ScheduleID)
    {
        this.ScheduleID = ScheduleID;
    }
    public String getScheduleID()
    {
        return this.ScheduleID;
    }
    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    public String getPatientID()
    {
        return this.patientID;
    }
    public void setPatientVisitID(String patientVisitID)
    {
        this.patientVisitID = patientVisitID;
    }
    public String getPatientVisitID()
    {
        return this.patientVisitID;
    }
    public void setPatientBedNo(String patientBedNo)
    {
        this.patientBedNo = patientBedNo;
    }
    public String getPatientBedNo()
    {
        return this.patientBedNo;
    }
    public void setPatientDepartmentCode(String patientDepartmentCode)
    {
        this.patientDepartmentCode = patientDepartmentCode;
    }
    public String getPatientDepartmentCode()
    {
        return this.patientDepartmentCode;
    }
    public void setItemList(ArrayOfDCPatientOperationScheduleItem ItemList)
    {
        this.ItemList = ItemList;
    }
    public ArrayOfDCPatientOperationScheduleItem getItemList()
    {
        return this.ItemList;
    }
    public void setInfectionList(ArrayOfDCPatientOperationInfection InfectionList)
    {
        this.InfectionList = InfectionList;
    }
    public ArrayOfDCPatientOperationInfection getInfectionList()
    {
        return this.InfectionList;
    }
    public void setDiagBeforeOperation(String DiagBeforeOperation)
    {
        this.DiagBeforeOperation = DiagBeforeOperation;
    }
    public String getDiagBeforeOperation()
    {
        return this.DiagBeforeOperation;
    }
    public void setPatientCondition(String PatientCondition)
    {
        this.PatientCondition = PatientCondition;
    }
    public String getPatientCondition()
    {
        return this.PatientCondition;
    }
    public void setScheduledDateTime(String ScheduledDateTime)
    {
        this.ScheduledDateTime = ScheduledDateTime;
    }
    public String getScheduledDateTime()
    {
        return this.ScheduledDateTime;
    }
    public void setOperatingRoomDeptCode(String OperatingRoomDeptCode)
    {
        this.OperatingRoomDeptCode = OperatingRoomDeptCode;
    }
    public String getOperatingRoomDeptCode()
    {
        return this.OperatingRoomDeptCode;
    }
    public void setOperatingRoom(String OperatingRoom)
    {
        this.OperatingRoom = OperatingRoom;
    }
    public String getOperatingRoom()
    {
        return this.OperatingRoom;
    }
    public void setAckIndicator(String AckIndicator)
    {
        this.AckIndicator = AckIndicator;
    }
    public String getAckIndicator()
    {
        return this.AckIndicator;
    }
    public void setOperatingRoomNo(String OperatingRoomNo)
    {
        this.OperatingRoomNo = OperatingRoomNo;
    }
    public String getOperatingRoomNo()
    {
        return this.OperatingRoomNo;
    }
    public void setSequence(String Sequence)
    {
        this.Sequence = Sequence;
    }
    public String getSequence()
    {
        return this.Sequence;
    }
    public void setIsolationIndicator(String IsolationIndicator)
    {
        this.IsolationIndicator = IsolationIndicator;
    }
    public String getIsolationIndicator()
    {
        return this.IsolationIndicator;
    }
    public void setOperationScale(String OperationScale)
    {
        this.OperationScale = OperationScale;
    }
    public String getOperationScale()
    {
        return this.OperationScale;
    }
    public void setOperatingDept(String OperatingDept)
    {
        this.OperatingDept = OperatingDept;
    }
    public String getOperatingDept()
    {
        return this.OperatingDept;
    }
    public void setOperatingDeptCode(String OperatingDeptCode)
    {
        this.OperatingDeptCode = OperatingDeptCode;
    }
    public String getOperatingDeptCode()
    {
        return this.OperatingDeptCode;
    }
    public void setSurgeon(String Surgeon)
    {
        this.Surgeon = Surgeon;
    }
    public String getSurgeon()
    {
        return this.Surgeon;
    }
    public void setEnteredBy(String EnteredBy)
    {
        this.EnteredBy = EnteredBy;
    }
    public String getEnteredBy()
    {
        return this.EnteredBy;
    }
    public void setFirstAssistant(String FirstAssistant)
    {
        this.FirstAssistant = FirstAssistant;
    }
    public String getFirstAssistant()
    {
        return this.FirstAssistant;
    }
    public void setSecondAssistant(String SecondAssistant)
    {
        this.SecondAssistant = SecondAssistant;
    }
    public String getSecondAssistant()
    {
        return this.SecondAssistant;
    }
    public void setThirdAssistant(String ThirdAssistant)
    {
        this.ThirdAssistant = ThirdAssistant;
    }
    public String getThirdAssistant()
    {
        return this.ThirdAssistant;
    }
    public void setFourthAssistant(String FourthAssistant)
    {
        this.FourthAssistant = FourthAssistant;
    }
    public String getFourthAssistant()
    {
        return this.FourthAssistant;
    }
    public void setBloodTranDoctor(String BloodTranDoctor)
    {
        this.BloodTranDoctor = BloodTranDoctor;
    }
    public String getBloodTranDoctor()
    {
        return this.BloodTranDoctor;
    }
    public void setAnesthesiaMethod(String AnesthesiaMethod)
    {
        this.AnesthesiaMethod = AnesthesiaMethod;
    }
    public String getAnesthesiaMethod()
    {
        return this.AnesthesiaMethod;
    }
    public void setAnesthesiaDoctor(String AnesthesiaDoctor)
    {
        this.AnesthesiaDoctor = AnesthesiaDoctor;
    }
    public String getAnesthesiaDoctor()
    {
        return this.AnesthesiaDoctor;
    }
    public void setAnesthesiaAssistant(String AnesthesiaAssistant)
    {
        this.AnesthesiaAssistant = AnesthesiaAssistant;
    }
    public String getAnesthesiaAssistant()
    {
        return this.AnesthesiaAssistant;
    }
    public void setFirstOperationNurse(String FirstOperationNurse)
    {
        this.FirstOperationNurse = FirstOperationNurse;
    }
    public String getFirstOperationNurse()
    {
        return this.FirstOperationNurse;
    }
    public void setSecondOperationNurse(String SecondOperationNurse)
    {
        this.SecondOperationNurse = SecondOperationNurse;
    }
    public String getSecondOperationNurse()
    {
        return this.SecondOperationNurse;
    }
    public void setFirstSupplyNurse(String FirstSupplyNurse)
    {
        this.FirstSupplyNurse = FirstSupplyNurse;
    }
    public String getFirstSupplyNurse()
    {
        return this.FirstSupplyNurse;
    }
    public void setSecondSupplyNurse(String SecondSupplyNurse)
    {
        this.SecondSupplyNurse = SecondSupplyNurse;
    }
    public String getSecondSupplyNurse()
    {
        return this.SecondSupplyNurse;
    }
    public void setReqDateTime(String ReqDateTime)
    {
        this.ReqDateTime = ReqDateTime;
    }
    public String getReqDateTime()
    {
        return this.ReqDateTime;
    }
    public void setNotesOnOperation(String NotesOnOperation)
    {
        this.NotesOnOperation = NotesOnOperation;
    }
    public String getNotesOnOperation()
    {
        return this.NotesOnOperation;
    }
}
