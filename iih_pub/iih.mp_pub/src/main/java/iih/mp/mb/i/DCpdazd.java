package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCpdazd
{
    @JsonProperty(value = "dept_sn")
    private String dept_sn;
    @JsonProperty(value = "ward_sn")
    private String ward_sn;
    @JsonProperty(value = "occ_page_type")
    private String occ_page_type;
    @JsonProperty(value = "occ_page_name")
    private String occ_page_name;
    @JsonProperty(value = "py_code")
    private String py_code;
    @JsonProperty(value = "d_code")
    private String d_code;
    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "isexec")
    private String isexec;
    @JsonProperty(value = "parentid")
    private String parentid;
    @JsonProperty(value = "mark")
    private String mark;

    public void setDept_sn(String dept_sn)
    {
        this.dept_sn = dept_sn;
    }
    public String getDept_sn()
    {
        return this.dept_sn;
    }
    public void setWard_sn(String ward_sn)
    {
        this.ward_sn = ward_sn;
    }
    public String getWard_sn()
    {
        return this.ward_sn;
    }
    public void setOcc_page_type(String occ_page_type)
    {
        this.occ_page_type = occ_page_type;
    }
    public String getOcc_page_type()
    {
        return this.occ_page_type;
    }
    public void setOcc_page_name(String occ_page_name)
    {
        this.occ_page_name = occ_page_name;
    }
    public String getOcc_page_name()
    {
        return this.occ_page_name;
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
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getCode()
    {
        return this.code;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setIsexec(String isexec)
    {
        this.isexec = isexec;
    }
    public String getIsexec()
    {
        return this.isexec;
    }
    public void setParentid(String parentid)
    {
        this.parentid = parentid;
    }
    public String getParentid()
    {
        return this.parentid;
    }
    public void setMark(String mark)
    {
        this.mark = mark;
    }
    public String getMark()
    {
        return this.mark;
    }
}
