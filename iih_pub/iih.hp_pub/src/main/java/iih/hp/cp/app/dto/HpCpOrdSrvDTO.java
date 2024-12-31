package iih.hp.cp.app.dto;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床路径中定义的医嘱服务项目
 * @author HUMS
 *
 */
public class HpCpOrdSrvDTO extends HpCpEleDTO {
	
	private static final long serialVersionUID = 1L;
	
	public String getMatchKey(){
		String key = this.getId_srv()+ StringUtils.trimToEmpty(this.getId_mm()) + StringUtils.trimToEmpty(this.getId_drug_delivery_method());
		return key;
	}	

	/**
	 * 诊疗计划父元素Id
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}

	/**
	 * 诊疗计划父元素Id
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	
	/**
	 * 是否为成组医嘱服务项目
	 * @return FBoolean
	 */
	public FBoolean getFg_group() {
		return ((FBoolean) getAttrVal("Fg_group"));
	}
	
	/**
	 * 是否为成组医嘱服务项目
	 * @param Fg_group
	 */
	public void setFg_group(FBoolean Fg_group) {
		setAttrVal("Fg_group", Fg_group);
	}
	
	/**
	 * 服务Id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	
	/**
	 * 服务Id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}

	/**
	 * 服务类型编码 
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	
	/**
	 * 物品Id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	/**
	 * 物品Id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drug_delivery_method() {
		return ((String) getAttrVal("Id_drug_delivery_method"));
	}

	/**
	 * 领药方式ID
	 * @param Id_drug_delivery_method
	 */
	public void setId_drug_delivery_method(String Id_drug_delivery_method) {
		setAttrVal("Id_drug_delivery_method", Id_drug_delivery_method);
	}
	
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getCode_drug_delivery_method() {
		return ((String) getAttrVal("Code_drug_delivery_method"));
	}
	
	/**
	 * 领药方式编码
	 * @param Code_drug_delivery_method
	 */
	public void setCode_drug_delivery_method(String Code_drug_delivery_method) {
		setAttrVal("Code_drug_delivery_method", Code_drug_delivery_method);
	}
	
	/**
	 * 临床路径应用Id
	 * @return String
	 */
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}

	/**
	 * 临床路径应用Id
	 * @param Id_cpapp
	 */
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}

	/**
	 * 临床路径应用元素Id
	 * @return String
	 */
	public String getId_appele() {
		return ((String) getAttrVal("Id_appele"));
	}

	/**
	 * 临床路径应用元素Id
	 * @param Id_appele
	 */
	public void setId_appele(String Id_appele) {
		setAttrVal("Id_appele", Id_appele);
	}

	/**
	 * 元素执行状态
	 * @return Integer
	 */
	public Integer getEu_exe_status() {
		return ((Integer) getAttrVal("Eu_exe_status"));
	}

	/**
	 * 元素执行状态
	 * @param Eu_exe_status
	 */
	public void setEu_exe_status(Integer Eu_exe_status) {
		setAttrVal("Eu_exe_status", Eu_exe_status);
	}

	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exe() {
		return ((FDateTime) getAttrVal("Dt_exe"));
	}

	/**
	 * 执行时间
	 * @param Dt_exe
	 */
	public void setDt_exe(FDateTime Dt_exe) {
		setAttrVal("Dt_exe", Dt_exe);
	}
	
	/**
	 * 临床路径应用中的医嘱Id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	/**
	 * 临床路径应用中的医嘱Id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 临床路径应用中的服务Id
	 * @return String
	 */
	public String getId_srv_app() {
		return ((String) getAttrVal("Id_srv_app"));
	}

	/**
	 * 临床路径应用中的服务Id
	 * @param Id_srv_app
	 */
	public void setId_srv_app(String Id_srv_app) {
		setAttrVal("Id_srv_app", Id_srv_app);
	}
}
