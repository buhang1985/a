package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 获取排班对应的号位-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class SchTickInfoResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 号位ID
	 */
	private String tickId;
	
	/**
	 * 排班ID
	 */
	private String schId;
	/**
	 * 号位开始时间
	 */
	private String t_b;
	/**
	 * 号位结束时间
	 */
	private String t_e;
	/**
	 * 号位编码
	 */
	private String code;
	/**
	 * 可预约标准
	 */
	private String fg_apptable;
	/***
	 * 号段id
	 */
	private String ticksId;
	
	public String getTickId() {
		return tickId;
	}
	public void setTickId(String tickId) {
		this.tickId = tickId;
	}
	public String getSchId() {
		return schId;
	}
	public void setSchId(String schId) {
		this.schId = schId;
	}
	public String getT_b() {
		return t_b;
	}
	public void setT_b(String t_b) {
		this.t_b = t_b;
	}
	public String getT_e() {
		return t_e;
	}
	public void setT_e(String t_e) {
		this.t_e = t_e;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFg_apptable() {
		return fg_apptable;
	}
	public void setFg_apptable(String fg_apptable) {
		this.fg_apptable = fg_apptable;
	}
	public String getTicksId() {
		return ticksId;
	}
	public void setTicksId(String ticksId) {
		this.ticksId = ticksId;
	}

}
