package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NurseExcutePatientDoctorAdviceRequest
{
    @JsonProperty(value = "orderList")
    private String orderList;
    @JsonProperty(value = "nurseID")
    private String nurseID;
    @JsonProperty(value = "nurseName")
    private String nurseName;
    @JsonProperty(value = "deptID")
    private String deptID;
    @JsonProperty(value = "excuteTime")
    private String excuteTime;
    @JsonProperty(value = "multi_flag")
    private String multi_flag;
    @JsonProperty(value = "speedvalue")
    private String speedvalue;
    @JsonProperty(value = "exectp") //执行类别 
    private String exectp;
    @JsonProperty(value = "id_skip_reason")
    private String id_skip_reason;
    @JsonProperty(value = "sd_skip_reason")
    private String sd_skip_reason;
    
    @JsonProperty(value = "fg_skin")//是否皮试
    private String fg_skin;
    
    
    
    /**
	 * @return the fg_skin
	 */
	public String getFg_skin() {
		return fg_skin;
	}
	/**
	 * @param fg_skin the fg_skin to set
	 */
	public void setFg_skin(String fg_skin) {
		this.fg_skin = fg_skin;
	}
	/**
	 * @return 
	 */
	public String getExectp() {
		return exectp;
	}
	/**
	 * @param 
	 */
	public void setExectp(String exectp) {
		this.exectp = exectp;
	}
	/**
	 * @return 
	 */
	public String getId_skip_reason() {
		return id_skip_reason;
	}
	/**
	 * @param 
	 */
	public void setId_skip_reason(String id_skip_reason) {
		this.id_skip_reason = id_skip_reason;
	}
	/**
	 * @return 
	 */
	public String getSd_skip_reason() {
		return sd_skip_reason;
	}
	/**
	 * @param 
	 */
	public void setSd_skip_reason(String sd_skip_reason) {
		this.sd_skip_reason = sd_skip_reason;
	}
	
	public void setOrderList(String orderList)
    {
        this.orderList = orderList;
    }
    public String getOrderList()
    {
        return this.orderList;
    }
    public void setNurseID(String nurseID)
    {
        this.nurseID = nurseID;
    }
    public String getNurseID()
    {
        return this.nurseID;
    }
    public void setNurseName(String nurseName)
    {
        this.nurseName = nurseName;
    }
    public String getNurseName()
    {
        return this.nurseName;
    }
    public void setDeptID(String deptID)
    {
        this.deptID = deptID;
    }
    public String getDeptID()
    {
        return this.deptID;
    }
    public void setExcuteTime(String excuteTime)
    {
        this.excuteTime = excuteTime;
    }
    public String getExcuteTime()
    {
        return this.excuteTime;
    }
    public void setMulti_flag(String multi_flag)
    {
        this.multi_flag = multi_flag;
    }
    public String getMulti_flag()
    {
        return this.multi_flag;
    }
    public void setSpeedvalue(String speedvalue)
    {
        this.speedvalue = speedvalue;
    }
    public String getSpeedvalue()
    {
        return this.speedvalue;
    }
}
