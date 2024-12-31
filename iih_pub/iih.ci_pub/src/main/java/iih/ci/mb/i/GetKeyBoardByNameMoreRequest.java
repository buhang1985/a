package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetKeyBoardByNameMoreRequest
{
    @JsonProperty(value = "KBID")
    private String KBID;
    @JsonProperty(value = "TitleID")
    private String TitleID;
    @JsonProperty(value = "OrderCode")
    private String OrderCode;
    @JsonProperty(value = "DeptID")
    private String DeptID;
    @JsonProperty(value = "KBName")
    private String KBName;

    public void setKBID(String KBID)
    {
        this.KBID = KBID;
    }
    public String getKBID()
    {
        return this.KBID;
    }
    public void setTitleID(String TitleID)
    {
        this.TitleID = TitleID;
    }
    public String getTitleID()
    {
        return this.TitleID;
    }
    public void setOrderCode(String OrderCode)
    {
        this.OrderCode = OrderCode;
    }
    public String getOrderCode()
    {
        return this.OrderCode;
    }
    public void setDeptID(String DeptID)
    {
        this.DeptID = DeptID;
    }
    public String getDeptID()
    {
        return this.DeptID;
    }
    public void setKBName(String KBName)
    {
        this.KBName = KBName;
    }
    public String getKBName()
    {
        return this.KBName;
    }
}
