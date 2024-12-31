package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCUnExpectedItem
{
    @JsonProperty(value = "patientHID")
    private String patientHID;
    @JsonProperty(value = "patientName")
    private String patientName;
    @JsonProperty(value = "patientSex")
    private String patientSex;
    @JsonProperty(value = "patientAge")
    private String patientAge;
    @JsonProperty(value = "patientBedNo")
    private String patientBedNo;
    @JsonProperty(value = "doctorOrder")
    private DCDoctorAdvice doctorOrder;
    @JsonProperty(value = "nursingRecordItem")
    private DCNursingRecordItem nursingRecordItem;
    @JsonProperty(value = "isSubOrder")
    private Boolean isSubOrder;

    public void setPatientHID(String patientHID)
    {
        this.patientHID = patientHID;
    }
    public String getPatientHID()
    {
        return this.patientHID;
    }
    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }
    public String getPatientName()
    {
        return this.patientName;
    }
    public void setPatientSex(String patientSex)
    {
        this.patientSex = patientSex;
    }
    public String getPatientSex()
    {
        return this.patientSex;
    }
    public void setPatientAge(String patientAge)
    {
        this.patientAge = patientAge;
    }
    public String getPatientAge()
    {
        return this.patientAge;
    }
    public void setPatientBedNo(String patientBedNo)
    {
        this.patientBedNo = patientBedNo;
    }
    public String getPatientBedNo()
    {
        return this.patientBedNo;
    }
    public void setDoctorOrder(DCDoctorAdvice doctorOrder)
    {
        this.doctorOrder = doctorOrder;
    }
    public DCDoctorAdvice getDoctorOrder()
    {
        return this.doctorOrder;
    }
    public void setNursingRecordItem(DCNursingRecordItem nursingRecordItem)
    {
        this.nursingRecordItem = nursingRecordItem;
    }
    public DCNursingRecordItem getNursingRecordItem()
    {
        return this.nursingRecordItem;
    }
    public void setIsSubOrder(Boolean isSubOrder)
    {
        this.isSubOrder = isSubOrder;
    }
    public Boolean getIsSubOrder()
    {
        return this.isSubOrder;
    }
}
