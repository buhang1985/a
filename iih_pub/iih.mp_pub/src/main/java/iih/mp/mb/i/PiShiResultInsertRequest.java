package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PiShiResultInsertRequest
{
    @JsonProperty(value = "encid")
    private String encid;
    @JsonProperty(value = "order_sn")
    private String order_sn;
    @JsonProperty(value = "test_result")
    private String test_result;
    @JsonProperty(value = "enter_opera")
    private String enter_opera;
    @JsonProperty(value = "dept_sn")
    private String dept_sn;
    @JsonProperty(value = "ward_sn")
    private String ward_sn;
    @JsonProperty(value = "check_opera")
    private String check_opera;
    
    @JsonProperty(value = "orderList")//执行时间和执行计划id
    private String orderList;
    @JsonProperty(value = "id_aldeg")//过敏严重程度ID
    private String id_aldeg;
    @JsonProperty(value = "sd_aldeg")//过敏严重程度编码
    private String sd_aldeg;
    
    @JsonProperty(value = "des_aldeg")//过敏描述
    private String des_aldeg;
    
    
    
    
    /**
	 * @return
	 */
	public String getDes_aldeg() {
		return des_aldeg;
	}
	/**
	 * @param 
	 */
	public void setDes_aldeg(String des_aldeg) {
		this.des_aldeg = des_aldeg;
	}
	/**
	 * @return 
	 */
	public String getOrderList() {
		return orderList;
	}
	/**
	 * @param 
	 */
	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}
	/**
	 * @return the id_aldeg
	 */
	public String getId_aldeg() {
		return id_aldeg;
	}
	/**
	 * @param 
	 */
	public void setId_aldeg(String id_aldeg) {
		this.id_aldeg = id_aldeg;
	}
	/**
	 * @return 
	 */
	public String getSd_aldeg() {
		return sd_aldeg;
	}
	/**
	 * @param sd_aldeg the sd_aldeg to set
	 */
	public void setSd_aldeg(String sd_aldeg) {
		this.sd_aldeg = sd_aldeg;
	}
	public void setEncid(String encid)
    {
        this.encid = encid;
    }
    public String getEncid()
    {
        return this.encid;
    }
    public void setOrder_sn(String order_sn)
    {
        this.order_sn = order_sn;
    }
    public String getOrder_sn()
    {
        return this.order_sn;
    }
    public void setTest_result(String test_result)
    {
        this.test_result = test_result;
    }
    public String getTest_result()
    {
        return this.test_result;
    }
    public void setEnter_opera(String enter_opera)
    {
        this.enter_opera = enter_opera;
    }
    public String getEnter_opera()
    {
        return this.enter_opera;
    }
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
    public void setCheck_opera(String check_opera)
    {
        this.check_opera = check_opera;
    }
    public String getCheck_opera()
    {
        return this.check_opera;
    }
}
