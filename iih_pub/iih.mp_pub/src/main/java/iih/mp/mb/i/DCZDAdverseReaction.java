package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCZDAdverseReaction
{
    @JsonProperty(value = "ar_code")
    private String ar_code;
    @JsonProperty(value = "ar_name")
    private String ar_name;
    @JsonProperty(value = "py_code")
    private String py_code;
    @JsonProperty(value = "d_code")
    private String d_code;
    @JsonProperty(value = "p_id")
    private String p_id;
    @JsonProperty(value = "p_name")
    private String p_name;
    @JsonProperty(value = "deleted_flag")
    private String deleted_flag;
    @JsonProperty(value = "comment")
    private String comment;
    @JsonProperty(value = "order_num")
    private String order_num;

    public void setAr_code(String ar_code)
    {
        this.ar_code = ar_code;
    }
    public String getAr_code()
    {
        return this.ar_code;
    }
    public void setAr_name(String ar_name)
    {
        this.ar_name = ar_name;
    }
    public String getAr_name()
    {
        return this.ar_name;
    }
    public void setPy_code(String py_code)
    {
        this.py_code = py_code;
    }
    public String getPy_code()
    {
        return this.py_code;
    }
    public void setD_code(String d_code)
    {
        this.d_code = d_code;
    }
    public String getD_code()
    {
        return this.d_code;
    }
    public void setP_id(String p_id)
    {
        this.p_id = p_id;
    }
    public String getP_id()
    {
        return this.p_id;
    }
    public void setP_name(String p_name)
    {
        this.p_name = p_name;
    }
    public String getP_name()
    {
        return this.p_name;
    }
    public void setDeleted_flag(String deleted_flag)
    {
        this.deleted_flag = deleted_flag;
    }
    public String getDeleted_flag()
    {
        return this.deleted_flag;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    public String getComment()
    {
        return this.comment;
    }
    public void setOrder_num(String order_num)
    {
        this.order_num = order_num;
    }
    public String getOrder_num()
    {
        return this.order_num;
    }
}
