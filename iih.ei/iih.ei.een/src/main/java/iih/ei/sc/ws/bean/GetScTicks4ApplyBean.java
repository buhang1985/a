package iih.ei.sc.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import iih.bd.webservice.BaseWsParam;

/**
 * 号位信息
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetScTicks4ApplyBean  extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 号位id
	 */
	private String id_tick;
	/**
	 * 组织id
	 */
	private String id_org;
	/**
	 * 排班id
	 */
	private String id_sch;
	/**
	 * 票号
	 */
	private String queno;
	/**
	 * 号段id
	 */
	private String id_ticks;
	/**
	 * 号位开始时间
	 */
	private String t_b;
	/**
	 * 号位结束时间
	 */
	private String t_e;
	public String getId_tick() {
		return id_tick;
	}
	public void setId_tick(String id_tick) {
		this.id_tick = id_tick;
	}
	public String getId_org() {
		return id_org;
	}
	public void setId_org(String id_org) {
		this.id_org = id_org;
	}
	public String getId_sch() {
		return id_sch;
	}
	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}
	public String getQueno() {
		return queno;
	}
	public void setQueno(String queno) {
		this.queno = queno;
	}
	public String getId_ticks() {
		return id_ticks;
	}
	public void setId_ticks(String id_ticks) {
		this.id_ticks = id_ticks;
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
	
	
}
