package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDrugBox
{
    @JsonProperty(value = "boxcode")
    private String boxcode;
    @JsonProperty(value = "groupno")
    private String groupno;
    @JsonProperty(value = "pageno")
    private String pageno;
    @JsonProperty(value = "groupname")
    private String groupname;
    @JsonProperty(value = "wardname")
    private String wardname;
    @JsonProperty(value = "totalamount")
    private String totalamount;
    @JsonProperty(value = "sendedopera")
    private String sendedopera;
    @JsonProperty(value = "sendedtime")
    private String sendedtime;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "comment")
    private String comment;

    public void setBoxcode(String boxcode)
    {
        this.boxcode = boxcode;
    }
    public String getBoxcode()
    {
        return this.boxcode;
    }
    public void setGroupno(String groupno)
    {
        this.groupno = groupno;
    }
    public String getGroupno()
    {
        return this.groupno;
    }
    public void setPageno(String pageno)
    {
        this.pageno = pageno;
    }
    public String getPageno()
    {
        return this.pageno;
    }
    public void setGroupname(String groupname)
    {
        this.groupname = groupname;
    }
    public String getGroupname()
    {
        return this.groupname;
    }
    public void setWardname(String wardname)
    {
        this.wardname = wardname;
    }
    public String getWardname()
    {
        return this.wardname;
    }
    public void setTotalamount(String totalamount)
    {
        this.totalamount = totalamount;
    }
    public String getTotalamount()
    {
        return this.totalamount;
    }
    public void setSendedopera(String sendedopera)
    {
        this.sendedopera = sendedopera;
    }
    public String getSendedopera()
    {
        return this.sendedopera;
    }
    public void setSendedtime(String sendedtime)
    {
        this.sendedtime = sendedtime;
    }
    public String getSendedtime()
    {
        return this.sendedtime;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getStatus()
    {
        return this.status;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    public String getComment()
    {
        return this.comment;
    }
}
