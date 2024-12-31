package iih.mp.nr.ordermpqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务执行记录DTO DTO数据 
 * 
 */
public class MpOrPrSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 数值_医学单位
	 * @return String
	 */
	public String getQuan_medu() {
		return ((String) getAttrVal("Quan_medu"));
	}
	/**
	 * 数值_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(String Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 医学单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 记账状态名称
	 * @return String
	 */
	public String getName_su_bl() {
		return ((String) getAttrVal("Name_su_bl"));
	}
	/**
	 * 记账状态名称
	 * @param Name_su_bl
	 */
	public void setName_su_bl(String Name_su_bl) {
		setAttrVal("Name_su_bl", Name_su_bl);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_bl() {
		return ((FDateTime) getAttrVal("Dt_mp_bl"));
	}
	/**
	 * 记账时间
	 * @param Dt_mp_bl
	 */
	public void setDt_mp_bl(FDateTime Dt_mp_bl) {
		setAttrVal("Dt_mp_bl", Dt_mp_bl);
	}
	/**
	 * 执行计划ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划ID
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
}