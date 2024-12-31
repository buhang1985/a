package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Evt_Detl
{
    @JsonProperty(value = "Evt_Time")
    private String Evt_Time;
    @JsonProperty(value = "Evt_From")
    private String Evt_From;
    @JsonProperty(value = "Evt_IP")
    private String Evt_IP;
    @JsonProperty(value = "Evt_Dept")
    private String Evt_Dept;
    @JsonProperty(value = "Evt_Oper")
    private String Evt_Oper;
    @JsonProperty(value = "Evt_Node_id")
    private String Evt_Node_id;

    public void setEvt_Time(String Evt_Time)
    {
        this.Evt_Time = Evt_Time;
    }
    public String getEvt_Time()
    {
        return this.Evt_Time;
    }
    public void setEvt_From(String Evt_From)
    {
        this.Evt_From = Evt_From;
    }
    public String getEvt_From()
    {
        return this.Evt_From;
    }
    public void setEvt_IP(String Evt_IP)
    {
        this.Evt_IP = Evt_IP;
    }
    public String getEvt_IP()
    {
        return this.Evt_IP;
    }
    public void setEvt_Dept(String Evt_Dept)
    {
        this.Evt_Dept = Evt_Dept;
    }
    public String getEvt_Dept()
    {
        return this.Evt_Dept;
    }
    public void setEvt_Oper(String Evt_Oper)
    {
        this.Evt_Oper = Evt_Oper;
    }
    public String getEvt_Oper()
    {
        return this.Evt_Oper;
    }
    public void setEvt_Node_id(String Evt_Node_id)
    {
        this.Evt_Node_id = Evt_Node_id;
    }
    public String getEvt_Node_id()
    {
        return this.Evt_Node_id;
    }
}
