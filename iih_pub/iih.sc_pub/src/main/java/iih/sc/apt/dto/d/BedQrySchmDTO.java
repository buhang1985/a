package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 床位查询模板DTO DTO数据 
 * 
 */
public class BedQrySchmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 病区id
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 病区
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 床位状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 床位状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 床位状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 床位状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 床位属性集合
	 * @return FArrayList
	 */
	public FArrayList getBedattrs() {
		return ((FArrayList) getAttrVal("Bedattrs"));
	}
	/**
	 * 床位属性集合
	 * @param Bedattrs
	 */
	public void setBedattrs(FArrayList Bedattrs) {
		setAttrVal("Bedattrs", Bedattrs);
	}
	/**
	 * 预约状态
	 * @return String
	 */
	public String getEu_appt() {
		return ((String) getAttrVal("Eu_appt"));
	}
	/**
	 * 预约状态
	 * @param Eu_appt
	 */
	public void setEu_appt(String Eu_appt) {
		setAttrVal("Eu_appt", Eu_appt);
	}
	/**
	 * 床位服务项目id
	 * @return String
	 */
	public String getId_bltpl() {
		return ((String) getAttrVal("Id_bltpl"));
	}
	/**
	 * 床位服务项目id
	 * @param Id_bltpl
	 */
	public void setId_bltpl(String Id_bltpl) {
		setAttrVal("Id_bltpl", Id_bltpl);
	}
	/**
	 * 床位服务项目sd
	 * @return String
	 */
	public String getSd_bltpl() {
		return ((String) getAttrVal("Sd_bltpl"));
	}
	/**
	 * 床位服务项目sd
	 * @param Sd_bltpl
	 */
	public void setSd_bltpl(String Sd_bltpl) {
		setAttrVal("Sd_bltpl", Sd_bltpl);
	}
	/**
	 * 床位服务项目名称
	 * @return String
	 */
	public String getName_bltpl() {
		return ((String) getAttrVal("Name_bltpl"));
	}
	/**
	 * 床位服务项目名称
	 * @param Name_bltpl
	 */
	public void setName_bltpl(String Name_bltpl) {
		setAttrVal("Name_bltpl", Name_bltpl);
	}
	/**
	 * 最小费用
	 * @return FDouble
	 */
	public FDouble getMin_bltpl() {
		return ((FDouble) getAttrVal("Min_bltpl"));
	}
	/**
	 * 最小费用
	 * @param Min_bltpl
	 */
	public void setMin_bltpl(FDouble Min_bltpl) {
		setAttrVal("Min_bltpl", Min_bltpl);
	}
	/**
	 * 最大费用
	 * @return FDouble
	 */
	public FDouble getMax_bltpl() {
		return ((FDouble) getAttrVal("Max_bltpl"));
	}
	/**
	 * 最大费用
	 * @param Max_bltpl
	 */
	public void setMax_bltpl(FDouble Max_bltpl) {
		setAttrVal("Max_bltpl", Max_bltpl);
	}
	/**
	 * 在院
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 待出院
	 * @return FBoolean
	 */
	public FBoolean getFg_ip_will() {
		return ((FBoolean) getAttrVal("Fg_ip_will"));
	}
	/**
	 * 待出院
	 * @param Fg_ip_will
	 */
	public void setFg_ip_will(FBoolean Fg_ip_will) {
		setAttrVal("Fg_ip_will", Fg_ip_will);
	}
}