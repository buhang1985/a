package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDoctorAdviceExecutionRecord
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "SubmitID")
    private String SubmitID;
    @JsonProperty(value = "OrderID")
    private String OrderID;
    @JsonProperty(value = "OrderSubID")
    private String OrderSubID;
    @JsonProperty(value = "OrderContent")
    private String OrderContent;
    @JsonProperty(value = "OrderDosage")
    private String OrderDosage;
    @JsonProperty(value = "OrderPerformance")
    private String OrderPerformance;
    @JsonProperty(value = "ExecutorID")
    private String ExecutorID;
    @JsonProperty(value = "ExecuteTimePoint")
    private String ExecuteTimePoint;
    @JsonProperty(value = "ExecutorName")
    private String ExecutorName;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
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
    public void setSubmitID(String SubmitID)
    {
        this.SubmitID = SubmitID;
    }
    public String getSubmitID()
    {
        return this.SubmitID;
    }
    public void setOrderID(String OrderID)
    {
        this.OrderID = OrderID;
    }
    public String getOrderID()
    {
        return this.OrderID;
    }
    public void setOrderSubID(String OrderSubID)
    {
        this.OrderSubID = OrderSubID;
    }
    public String getOrderSubID()
    {
        return this.OrderSubID;
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
    public void setOrderPerformance(String OrderPerformance)
    {
        this.OrderPerformance = OrderPerformance;
    }
    public String getOrderPerformance()
    {
        return this.OrderPerformance;
    }
    public void setExecutorID(String ExecutorID)
    {
        this.ExecutorID = ExecutorID;
    }
    public String getExecutorID()
    {
        return this.ExecutorID;
    }
    public void setExecuteTimePoint(String ExecuteTimePoint)
    {
        this.ExecuteTimePoint = ExecuteTimePoint;
    }
    public String getExecuteTimePoint()
    {
        return this.ExecuteTimePoint;
    }
    public void setExecutorName(String ExecutorName)
    {
        this.ExecutorName = ExecutorName;
    }
    public String getExecutorName()
    {
        return this.ExecutorName;
    }
}
