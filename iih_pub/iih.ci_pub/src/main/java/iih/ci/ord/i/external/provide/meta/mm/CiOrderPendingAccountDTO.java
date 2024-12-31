package iih.ci.ord.i.external.provide.meta.mm;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 医嘱待记账集合
 * @author HUMS
 *
 */
public class CiOrderPendingAccountDTO extends BaseXapJsonSerialization{

private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊Id
	 * @return
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊Id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}

	/**
	 * 医嘱ID
	 * @return
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 医嘱编码
	 * @return
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	
	/**
	 * 医嘱名称
	 * @return
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	
	/**
	 * 医嘱表中服务id
	 * @return
	 */
	public String getOrd_id_srv() {
		return ((String) getAttrVal("Ord_id_srv"));
	}
	/**
	 * 医嘱表中服务id
	 * @param Name_or
	 */
	public void setOrd_id_srv(String Ord_id_srv) {
		setAttrVal("Ord_id_srv", Ord_id_srv);
	}
	
	/**
	 * 就诊类型
	 * @return
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
	 * 服务项目Id
	 * @return
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 服务项目Id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	
	/**
	 * 服务项目中id_srv
	 * @return
	 */
	public String getOrsrv_id_srv() {
		return ((String) getAttrVal("Orsrv_id_srv"));
	}
	/**
	 * 服务项目中id_srv
	 * @param Orsrv_id_srv
	 */
	public void setOrsrv_id_srv(String Orsrv_id_srv) {
		setAttrVal("Orsrv_id_srv", Orsrv_id_srv);
	}	
	
	/**
	 * 服务项目编码
	 * @return
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	
	/**
	 * 服务项目名称
	 * @return
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
	 * 频次id
	 * @return
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次id
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	
	/**
	 * 频次名称
	 * @return
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Id_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	
	/**
	 * 单价
	 * @return
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	
	/**
	 * 标准价
	 * @return
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}
	/**
	 * 标准价
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	
	/**
	 * 价格系数
	 * @return
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}
	/**
	 * 价格系数
	 * @param Pri_ratio
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}
	
	/**
	 * 服务项目总价
	 * @return
	 */
	public FDouble getTotal_pri() {
		return ((FDouble) getAttrVal("Total_pri"));
	}
	/**
	 * 服务项目总价
	 * @param Total_pri
	 */
	public void setTotal_pri(FDouble Total_pri) {
		setAttrVal("Total_pri", Total_pri);
	}
	
	/**
	 * 数值_医疗单位
	 * @return
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	
	/**
	 * 数值_医疗单位
	 * @return
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 数值_医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	
	/**
	 * 剂量单位名称
	 * @return
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}
	/**
	 * 剂量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
	
	/**
	 * 服务总量
	 * @return
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	
	
	/**
	 * 服务项目开立科室Id
	 * @return
	 */
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}
	/**
	 * 服务项目开立科室Id
	 * @param Id_medu
	 */
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	
	/**
	 * 服务项目开立科室名称
	 * @return
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}
	/**
	 * 服务项目开立科室名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	
	/**
	 * 服务项目开立医生Id
	 * @return
	 */
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}
	/**
	 * 服务项目开立医生Id
	 * @param Id_emp_srv
	 */
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
	}
	
	/**
	 * 服务项目开立医生名称
	 * @return
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}
	/**
	 * 服务项目开立医生名称
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	
	/**
	 * 医嘱记账状态Id
	 * @return
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 医嘱记账状态Id
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	
	/**
	 * 医嘱记账状态
	 * @return
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 医嘱记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 医嘱记账状态名称
	 * @return
	 */
	public String getSu_bl_name() {
		return ((String) getAttrVal("Su_bl_name"));
	}
	/**
	 * 医嘱记账状态名
	 * @param Sd_su_bl
	 */
	public void setSu_bl_name(String Su_bl_name) {
		setAttrVal("Su_bl_name", Su_bl_name);
	}	
	
	/**
	 * 医保目录类型
	 * @return
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	
	/**
	 * 医保目录类型编码
	 * @return
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型编码
	 * @param Id_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	
	/**
	 * 医保目录类型名称
	 * @return
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保目录类型名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	
	/**
	 * 物品标识
	 * @return
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	
	/**
	 * 医嘱签署时间
	 * @return
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}
	/**
	 * 医嘱签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}	
}
