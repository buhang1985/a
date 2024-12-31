package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientRequestTestItem
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "ItemNo")
    private String ItemNo;
    @JsonProperty(value = "ItemName")
    private String ItemName;
    @JsonProperty(value = "ItemCode")
    private String ItemCode;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setItemNo(String ItemNo)
    {
        this.ItemNo = ItemNo;
    }
    public String getItemNo()
    {
        return this.ItemNo;
    }
    public void setItemName(String ItemName)
    {
        this.ItemName = ItemName;
    }
    public String getItemName()
    {
        return this.ItemName;
    }
    public void setItemCode(String ItemCode)
    {
        this.ItemCode = ItemCode;
    }
    public String getItemCode()
    {
        return this.ItemCode;
    }
}
