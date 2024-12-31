package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfPatientHRNewRequest
{
    @JsonProperty(value = "fileID")
    private String fileID;
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "nursingRecordList")
    private ArrayOfDCNursingRecordItem nursingRecordList;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "nurseName")
    private String nurseName;
    @JsonProperty(value = "enterDate")
    private String enterDate;
    @JsonProperty(value = "paras")
    private String paras;

    public void setFileID(String fileID)
    {
        this.fileID = fileID;
    }
    public String getFileID()
    {
        return this.fileID;
    }
    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setNursingRecordList(ArrayOfDCNursingRecordItem nursingRecordList)
    {
        this.nursingRecordList = nursingRecordList;
    }
    public ArrayOfDCNursingRecordItem getNursingRecordList()
    {
        return this.nursingRecordList;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return this.userName;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setNurseName(String nurseName)
    {
        this.nurseName = nurseName;
    }
    public String getNurseName()
    {
        return this.nurseName;
    }
    public void setEnterDate(String enterDate)
    {
        this.enterDate = enterDate;
    }
    public String getEnterDate()
    {
        return this.enterDate;
    }
    public void setParas(String paras)
    {
        this.paras = paras;
    }
    public String getParas()
    {
        return this.paras;
    }
}