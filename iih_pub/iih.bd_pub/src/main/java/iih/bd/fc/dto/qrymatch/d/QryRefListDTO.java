package iih.bd.fc.dto.qrymatch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 闭环类型列表 DTO数据 
 * 
 */
public class QryRefListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱闭环类型ID
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 医嘱闭环类型ID
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 医嘱闭环类型名称
	 * @return String
	 */
	public String getOrpltp_name() {
		return ((String) getAttrVal("Orpltp_name"));
	}
	/**
	 * 医嘱闭环类型名称
	 * @param Orpltp_name
	 */
	public void setOrpltp_name(String Orpltp_name) {
		setAttrVal("Orpltp_name", Orpltp_name);
	}
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getCode_entp_name() {
		return ((String) getAttrVal("Code_entp_name"));
	}
	/**
	 * 就诊类型名称
	 * @param Code_entp_name
	 */
	public void setCode_entp_name(String Code_entp_name) {
		setAttrVal("Code_entp_name", Code_entp_name);
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
	 * 服务类型名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}
	/**
	 * 服务类型名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
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
	 * 医疗服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * 医疗服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
	 * 开单科室名称
	 * @return String
	 */
	public String getDep_or_name() {
		return ((String) getAttrVal("Dep_or_name"));
	}
	/**
	 * 开单科室名称
	 * @param Dep_or_name
	 */
	public void setDep_or_name(String Dep_or_name) {
		setAttrVal("Dep_or_name", Dep_or_name);
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
	 * 领药方式名称
	 * @return String
	 */
	public String getDrugdeliverymethod_name() {
		return ((String) getAttrVal("Drugdeliverymethod_name"));
	}
	/**
	 * 领药方式名称
	 * @param Drugdeliverymethod_name
	 */
	public void setDrugdeliverymethod_name(String Drugdeliverymethod_name) {
		setAttrVal("Drugdeliverymethod_name", Drugdeliverymethod_name);
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
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 皮试标识
	 * @return String
	 */
	public String getFg_skintest() {
		return ((String) getAttrVal("Fg_skintest"));
	}
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(String Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 在院执行标记
	 * @return String
	 */
	public String getFg_mp_in() {
		return ((String) getAttrVal("Fg_mp_in"));
	}
	/**
	 * 在院执行标记
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(String Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
	}
	/**
	 * 出院带药标识
	 * @return String
	 */
	public String getFg_pres_outp() {
		return ((String) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(String Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 退药标识
	 * @return String
	 */
	public String getFg_back() {
		return ((String) getAttrVal("Fg_back"));
	}
	/**
	 * 退药标识
	 * @param Fg_back
	 */
	public void setFg_back(String Fg_back) {
		setAttrVal("Fg_back", Fg_back);
	}
	/**
	 * 在院整领标识
	 * @return String
	 */
	public String getFg_wholepack() {
		return ((String) getAttrVal("Fg_wholepack"));
	}
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(String Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 闭环描述
	 * @return String
	 */
	public String getOrpltp_des() {
		return ((String) getAttrVal("Orpltp_des"));
	}
	/**
	 * 闭环描述
	 * @param Orpltp_des
	 */
	public void setOrpltp_des(String Orpltp_des) {
		setAttrVal("Orpltp_des", Orpltp_des);
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
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
}