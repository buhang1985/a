package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 药品执行计划出参
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasStaticMatchBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String Pat_code;
	private String Amrip_code;
	private String Times_ip;
	private String Id_or_pr_srv;
	private String Code_or;
	private String Code_orsrv;
	private String Dt_mp_plan;
	private String Fg_delete;
	
	public void setPat_code(String pat_code) {
		this.Pat_code = pat_code;
	}
	
	public String getPat_code() {
		return this.Pat_code;
	}
	
	public void setAmrip_code(String amrip_code) {
		this.Amrip_code = amrip_code;
	}
	
	public String getAmrip_code() {
		return this.Amrip_code;
	}
	
	public void setTimes_ip(String times_ip) {
		this.Times_ip = times_ip;
	}
	
	public String getTimes_ip() {
		return this.Times_ip;
	}
	
	public void setId_or_pr_srv(String id_or_pr_srv) {
		this.Id_or_pr_srv = id_or_pr_srv;
	}
	
	public String getId_or_pr_srv() {
		return this.Id_or_pr_srv;
	}
	
	public void setCode_or(String code_or) {
		this.Code_or = code_or;
	}
	
	public String getCode_or() {
		return this.Code_or;
	}
	
	public void setCode_orsrv(String code_orsrv) {
		this.Code_orsrv = code_orsrv;
	}
	
	public String getCode_orsrv() {
		return this.Code_orsrv;
	}
	
	public void setDt_mp_plan(String dt_mp_plan) {
		this.Dt_mp_plan = dt_mp_plan;
	}
	
	public String getDt_mp_plan() {
		return this.Dt_mp_plan;
	}
	
	public void setFg_delete(String fg_delete) {
		this.Fg_delete = fg_delete;
	}
	
	public String getFg_delete() {
		return this.Fg_delete;
	}
}
