package iih.bd.fc.dto.qrymatch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱闭环匹配查询条件 DTO数据 
 * 
 */
public class QryMatchCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}
	/**
	 * 领药方式编码
	 * @param Sd_drugdeliverymethod
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}
	/**
	 * 医嘱用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 医嘱用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 皮试标识
	 * @return Integer
	 */
	public Integer getFg_skintest() {
		return ((Integer) getAttrVal("Fg_skintest"));
	}
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(Integer Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 在院执行标记
	 * @return Integer
	 */
	public Integer getFg_mp_in() {
		return ((Integer) getAttrVal("Fg_mp_in"));
	}
	/**
	 * 在院执行标记
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(Integer Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 出院带药标识
	 * @return Integer
	 */
	public Integer getFg_pres_outp() {
		return ((Integer) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(Integer Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 退药标识
	 * @return Integer
	 */
	public Integer getFg_back() {
		return ((Integer) getAttrVal("Fg_back"));
	}
	/**
	 * 退药标识
	 * @param Fg_back
	 */
	public void setFg_back(Integer Fg_back) {
		setAttrVal("Fg_back", Fg_back);
	}
	/**
	 * 在院整领标识
	 * @return Integer
	 */
	public Integer getFg_wholepack() {
		return ((Integer) getAttrVal("Fg_wholepack"));
	}
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(Integer Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 护理病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
}