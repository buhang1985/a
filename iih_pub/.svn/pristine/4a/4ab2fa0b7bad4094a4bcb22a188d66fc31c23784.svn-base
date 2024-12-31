package iih.hp.cp.app.dto;

import org.apache.commons.lang3.StringUtils;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱服务项目转为路径医嘱服务项目
 * @author HUMS
 *
 */
public class HpCpAppOrdSrvDTO extends HpCpAppEleDTO{

	public String getMatchKey(){
		String key = this.getId_srv()+ StringUtils.trimToEmpty(this.getId_mm()) + StringUtils.trimToEmpty(this.getId_drug_delivery_method());
		return key;
	}
	
	/**
	 * 医疗服务ID
	 * 
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	/**
	 * 医疗服务ID
	 * 
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医疗服务ID
	 * 
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}

	/**
	 * 医疗服务ID
	 * 
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 医疗服务名称
	 * 
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	/**
	 * 医疗服务名称
	 * 
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医疗物品ID
	 * 
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	/**
	 * 医疗物品ID
	 * 
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 医疗服务类型Id
	 * 
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}

	/**
	 * 医疗服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医疗服务类型
	 * 
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}

	/**
	 * 医疗服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}

	

	/**
	 * 单次剂量
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}

	/**
	 * 单次剂量
	 * 
	 * @param Dosage
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}

	/**
	 * 剂量单位
	 * 
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}

	/**
	 * 剂量单位
	 * 
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	

	/**
	 * 径内医嘱区分
	 * 
	 * @return Integer
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}

	/**
	 * 径内医嘱区分
	 * 
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}

	/**
	 * 径外医嘱使用原因
	 * 
	 * @return String
	 */
	public String getReason_uncporuse() {
		return ((String) getAttrVal("Reason_uncporuse"));
	}

	/**
	 * 径外医嘱使用原因
	 * 
	 * @param Reason_uncporuse
	 */
	public void setReason_uncporuse(String Reason_uncporuse) {
		setAttrVal("Reason_uncporuse", Reason_uncporuse);
	}

	/**
	 * 用法ID
	 * 
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}

	/**
	 * 用法ID
	 * 
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}

	/**
	 * 在院整领
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}

	/**
	 * 在院整领
	 * 
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}

	/**
	 * 出院带药
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}

	/**
	 * 出院带药
	 * 
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}

	/**
	 * 总量_当前包装
	 * 
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}

	/**
	 * 总量_当前包装
	 * 
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}

	/**
	 * 总量单位ID_当前包装
	 * 
	 * @return String
	 */
	public String getId_unit_cur() {
		return ((String) getAttrVal("Id_unit_cur"));
	}

	/**
	 * 总量单位ID_当前包装
	 * 
	 * @param Id_unit_cur
	 */
	public void setId_unit_cur(String Id_unit_cur) {
		setAttrVal("Id_unit_cur", Id_unit_cur);
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
	
	public String getId_nodispense() {
		return ((String) getAttrVal("Id_nodispense"));
	}

	public void setId_nodispense(String Id_nodispense) {
		setAttrVal("Id_nodispense", Id_nodispense);
	}

	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}

	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}

	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}

	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}

	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}

	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}

	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}

	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}

	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}

	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}

	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}

	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}

	public String getName_nodispense() {
		return ((String) getAttrVal("Name_nodispense"));
	}

	public void setName_nodispense(String Name_nodispense) {
		setAttrVal("Name_nodispense", Name_nodispense);
	}

	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}

	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}

	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}

	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	
	/**
	 * 是否为物品
	 * @return
	 */
	public FBoolean getFg_mm() {
		 if(StringUtils.isNotEmpty(this.getId_mm())){
			 return FBoolean.TRUE;
		 }
		 return FBoolean.FALSE;
	}
	
}
