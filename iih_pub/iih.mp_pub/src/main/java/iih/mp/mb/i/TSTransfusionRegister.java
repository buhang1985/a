package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class TSTransfusionRegister
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "BarID")
    private String BarID;
    @JsonProperty(value = "QueueID")
    private Integer QueueID;
    @JsonProperty(value = "PrescriptionIDs")
    private ArrayOfString PrescriptionIDs;
    @JsonProperty(value = "State")
    private Integer State;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "PatientAge")
    private String PatientAge;
    @JsonProperty(value = "PatientSex")
    private String PatientSex;
    @JsonProperty(value = "PatientMedicalInsuranceID")
    private String PatientMedicalInsuranceID;
    @JsonProperty(value = "RegisterDateTime")
    private String RegisterDateTime;
    @JsonProperty(value = "RegisterNurseID")
    private String RegisterNurseID;
    @JsonProperty(value = "RegisterNurseName")
    private String RegisterNurseName;
    @JsonProperty(value = "RegisterDepartmentID")
    private String RegisterDepartmentID;
    @JsonProperty(value = "RegisterDepartmentName")
    private String RegisterDepartmentName;
    @JsonProperty(value = "AssignSeatID")
    private String AssignSeatID;
    @JsonProperty(value = "AssignSeatName")
    private String AssignSeatName;
    @JsonProperty(value = "CancelNurseID")
    private String CancelNurseID;
    @JsonProperty(value = "CancelNurseName")
    private String CancelNurseName;
    @JsonProperty(value = "CancelDateTime")
    private String CancelDateTime;
    @JsonProperty(value = "DispensdDateTime")
    private String DispensdDateTime;
    @JsonProperty(value = "StartDateTime")
    private String StartDateTime;
    @JsonProperty(value = "EndDateTime")
    private String EndDateTime;
    @JsonProperty(value = "PrescriptionNumber")
    private Integer PrescriptionNumber;
    @JsonProperty(value = "DragBagList")
    private ArrayOfTSDrugBag DragBagList;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setBarID(String BarID)
    {
        this.BarID = BarID;
    }
    public String getBarID()
    {
        return this.BarID;
    }
    public void setQueueID(Integer QueueID)
    {
        this.QueueID = QueueID;
    }
    public Integer getQueueID()
    {
        return this.QueueID;
    }
    public void setPrescriptionIDs(ArrayOfString PrescriptionIDs)
    {
        this.PrescriptionIDs = PrescriptionIDs;
    }
    public ArrayOfString getPrescriptionIDs()
    {
        return this.PrescriptionIDs;
    }
    public void setState(Integer State)
    {
        this.State = State;
    }
    public Integer getState()
    {
        return this.State;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setPatientAge(String PatientAge)
    {
        this.PatientAge = PatientAge;
    }
    public String getPatientAge()
    {
        return this.PatientAge;
    }
    public void setPatientSex(String PatientSex)
    {
        this.PatientSex = PatientSex;
    }
    public String getPatientSex()
    {
        return this.PatientSex;
    }
    public void setPatientMedicalInsuranceID(String PatientMedicalInsuranceID)
    {
        this.PatientMedicalInsuranceID = PatientMedicalInsuranceID;
    }
    public String getPatientMedicalInsuranceID()
    {
        return this.PatientMedicalInsuranceID;
    }
    public void setRegisterDateTime(String RegisterDateTime)
    {
        this.RegisterDateTime = RegisterDateTime;
    }
    public String getRegisterDateTime()
    {
        return this.RegisterDateTime;
    }
    public void setRegisterNurseID(String RegisterNurseID)
    {
        this.RegisterNurseID = RegisterNurseID;
    }
    public String getRegisterNurseID()
    {
        return this.RegisterNurseID;
    }
    public void setRegisterNurseName(String RegisterNurseName)
    {
        this.RegisterNurseName = RegisterNurseName;
    }
    public String getRegisterNurseName()
    {
        return this.RegisterNurseName;
    }
    public void setRegisterDepartmentID(String RegisterDepartmentID)
    {
        this.RegisterDepartmentID = RegisterDepartmentID;
    }
    public String getRegisterDepartmentID()
    {
        return this.RegisterDepartmentID;
    }
    public void setRegisterDepartmentName(String RegisterDepartmentName)
    {
        this.RegisterDepartmentName = RegisterDepartmentName;
    }
    public String getRegisterDepartmentName()
    {
        return this.RegisterDepartmentName;
    }
    public void setAssignSeatID(String AssignSeatID)
    {
        this.AssignSeatID = AssignSeatID;
    }
    public String getAssignSeatID()
    {
        return this.AssignSeatID;
    }
    public void setAssignSeatName(String AssignSeatName)
    {
        this.AssignSeatName = AssignSeatName;
    }
    public String getAssignSeatName()
    {
        return this.AssignSeatName;
    }
    public void setCancelNurseID(String CancelNurseID)
    {
        this.CancelNurseID = CancelNurseID;
    }
    public String getCancelNurseID()
    {
        return this.CancelNurseID;
    }
    public void setCancelNurseName(String CancelNurseName)
    {
        this.CancelNurseName = CancelNurseName;
    }
    public String getCancelNurseName()
    {
        return this.CancelNurseName;
    }
    public void setCancelDateTime(String CancelDateTime)
    {
        this.CancelDateTime = CancelDateTime;
    }
    public String getCancelDateTime()
    {
        return this.CancelDateTime;
    }
    public void setDispensdDateTime(String DispensdDateTime)
    {
        this.DispensdDateTime = DispensdDateTime;
    }
    public String getDispensdDateTime()
    {
        return this.DispensdDateTime;
    }
    public void setStartDateTime(String StartDateTime)
    {
        this.StartDateTime = StartDateTime;
    }
    public String getStartDateTime()
    {
        return this.StartDateTime;
    }
    public void setEndDateTime(String EndDateTime)
    {
        this.EndDateTime = EndDateTime;
    }
    public String getEndDateTime()
    {
        return this.EndDateTime;
    }
    public void setPrescriptionNumber(Integer PrescriptionNumber)
    {
        this.PrescriptionNumber = PrescriptionNumber;
    }
    public Integer getPrescriptionNumber()
    {
        return this.PrescriptionNumber;
    }
    public void setDragBagList(ArrayOfTSDrugBag DragBagList)
    {
        this.DragBagList = DragBagList;
    }
    public ArrayOfTSDrugBag getDragBagList()
    {
        return this.DragBagList;
    }
}
