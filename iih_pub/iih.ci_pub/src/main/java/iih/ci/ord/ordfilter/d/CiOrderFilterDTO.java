package iih.ci.ord.ordfilter.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱信息过滤 DTO数据 
 * 
 */
public class CiOrderFilterDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}
	/**
	 * 开始时间
	 * @param Dt_start
	 */
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 活动医嘱
	 * @return String
	 */
	public String getFg_live() {
		return ((String) getAttrVal("Fg_live"));
	}
	/**
	 * 活动医嘱
	 * @param Fg_live
	 */
	public void setFg_live(String Fg_live) {
		setAttrVal("Fg_live", Fg_live);
	}
	/**
	 * 长临
	 * @return String
	 */
	public String getFg_long() {
		return ((String) getAttrVal("Fg_long"));
	}
	/**
	 * 长临
	 * @param Fg_long
	 */
	public void setFg_long(String Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}
	/**
	 * 医嘱状态
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 医嘱开单类型编码
	 * @return String
	 */
	public String getSd_ord_type() {
		return ((String) getAttrVal("Sd_ord_type"));
	}
	/**
	 * 医嘱开单类型编码
	 * @param Sd_ord_type
	 */
	public void setSd_ord_type(String Sd_ord_type) {
		setAttrVal("Sd_ord_type", Sd_ord_type);
	}
	/**
	 * 医嘱开单类型名称
	 * @return String
	 */
	public String getName_ordtype() {
		return ((String) getAttrVal("Name_ordtype"));
	}
	/**
	 * 医嘱开单类型名称
	 * @param Name_ordtype
	 */
	public void setName_ordtype(String Name_ordtype) {
		setAttrVal("Name_ordtype", Name_ordtype);
	}
	/**
	 * 医嘱开单类型
	 * @return String
	 */
	public String getId_ord_type() {
		return ((String) getAttrVal("Id_ord_type"));
	}
	/**
	 * 医嘱开单类型
	 * @param Id_ord_type
	 */
	public void setId_ord_type(String Id_ord_type) {
		setAttrVal("Id_ord_type", Id_ord_type);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getOrder_name() {
		return ((String) getAttrVal("Order_name"));
	}
	/**
	 * 医嘱名称
	 * @param Order_name
	 */
	public void setOrder_name(String Order_name) {
		setAttrVal("Order_name", Order_name);
	}
	/**
	 * 服务类型字符串
	 * @return String
	 */
	public String getStr_code_srvtps() {
		return ((String) getAttrVal("Str_code_srvtps"));
	}
	/**
	 * 服务类型字符串
	 * @param Str_code_srvtps
	 */
	public void setStr_code_srvtps(String Str_code_srvtps) {
		setAttrVal("Str_code_srvtps", Str_code_srvtps);
	}
	/**
	 * 医嘱来源功能sd
	 * @return String
	 */
	public String getSd_orsrcfun() {
		return ((String) getAttrVal("Sd_orsrcfun"));
	}
	/**
	 * 医嘱来源功能sd
	 * @param Sd_orsrcfun
	 */
	public void setSd_orsrcfun(String Sd_orsrcfun) {
		setAttrVal("Sd_orsrcfun", Sd_orsrcfun);
	}
	/**
	 * 出院带药
	 * @return String
	 */
	public String getFg_pres_outp() {
		return ((String) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(String Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getStr_entp() {
		return ((String) getAttrVal("Str_entp"));
	}
	/**
	 * 就诊类型
	 * @param Str_entp
	 */
	public void setStr_entp(String Str_entp) {
		setAttrVal("Str_entp", Str_entp);
	}
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 患者就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
}