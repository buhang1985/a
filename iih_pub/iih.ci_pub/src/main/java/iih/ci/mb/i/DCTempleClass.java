package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCTempleClass
{
    @JsonProperty(value = "TempletTitle")
    private String TempletTitle;
    @JsonProperty(value = "TempletDeptCode")
    private String TempletDeptCode;
    @JsonProperty(value = "TempletDeptName")
    private String TempletDeptName;
    @JsonProperty(value = "TempletGroupID")
    private String TempletGroupID;
    @JsonProperty(value = "Permission")
    private String Permission;
    @JsonProperty(value = "OrdersDetail")
    private ArrayOfDCDoctorAdvice OrdersDetail;

    public void setTempletTitle(String TempletTitle)
    {
        this.TempletTitle = TempletTitle;
    }
    public String getTempletTitle()
    {
        return this.TempletTitle;
    }
    public void setTempletDeptCode(String TempletDeptCode)
    {
        this.TempletDeptCode = TempletDeptCode;
    }
    public String getTempletDeptCode()
    {
        return this.TempletDeptCode;
    }
    public void setTempletDeptName(String TempletDeptName)
    {
        this.TempletDeptName = TempletDeptName;
    }
    public String getTempletDeptName()
    {
        return this.TempletDeptName;
    }
    public void setTempletGroupID(String TempletGroupID)
    {
        this.TempletGroupID = TempletGroupID;
    }
    public String getTempletGroupID()
    {
        return this.TempletGroupID;
    }
    public void setPermission(String Permission)
    {
        this.Permission = Permission;
    }
    public String getPermission()
    {
        return this.Permission;
    }
    public void setOrdersDetail(ArrayOfDCDoctorAdvice OrdersDetail)
    {
        this.OrdersDetail = OrdersDetail;
    }
    public ArrayOfDCDoctorAdvice getOrdersDetail()
    {
        return this.OrdersDetail;
    }
}
