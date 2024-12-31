package iih.bl.itf.std.bean.input.cc.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 结账入参
 * @author shaokx 2020/05/13
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamCcParam implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//结账区间截止时间
    @XmlElement(name = "cctime")
	private String cctime;
    
    //是否跨天  Y:是(表示本次结账的结束时间为头一天的cctime时间）；N：否(表示本次结账的结束时间为当天的cctime时间）
    @XmlElement(name = "crossday")
	private String crossday;
    
    //终端类型编码 参见自定义档案“收付款终端类型”
    @XmlElement(name = "pttp")
	private String pttp;
    
    //结账类型编码 （00 门诊流程结账，01 门诊挂号结账，02 门诊收费结账，03 门诊预交金结账。10 住院流程结账  11住院预交金结账  12 住院收费结账）
    @XmlElement(name = "cctp")
	private String cctp;
    
    //组织id
    @XmlElement(name = "idorg")
	private String idorg;
    
    //集团id
    @XmlElement(name = "idgrp")
	private String idgrp;
    
    //若无实际业务数据时，是否产生结账数据   Y:是；N：否
    @XmlElement(name = "createblcc")
	private String createblcc;
    
    //结账人员编码
    @XmlElement(name = "blccpsn")
	private String blccpsn;

	public String getCctime() {
		return cctime;
	}

	public void setCctime(String cctime) {
		this.cctime = cctime;
	}

	public String getCrossday() {
		return crossday;
	}

	public void setCrossday(String crossday) {
		this.crossday = crossday;
	}

	public String getPttp() {
		return pttp;
	}

	public void setPttp(String pttp) {
		this.pttp = pttp;
	}

	public String getCctp() {
		return cctp;
	}

	public void setCctp(String cctp) {
		this.cctp = cctp;
	}

	public String getIdorg() {
		return idorg;
	}

	public void setIdorg(String idorg) {
		this.idorg = idorg;
	}

	public String getIdgrp() {
		return idgrp;
	}

	public void setIdgrp(String idgrp) {
		this.idgrp = idgrp;
	}

	public String getCreateblcc() {
		return createblcc;
	}

	public void setCreateblcc(String createblcc) {
		this.createblcc = createblcc;
	}

	public String getBlccpsn() {
		return blccpsn;
	}

	public void setBlccpsn(String blccpsn) {
		this.blccpsn = blccpsn;
	}
}
