package iih.bd.fc.dto.orwf.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱流向配置 DTO数据 
 * 
 */
public class WfCfgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流向配置
	 * @return String
	 */
	public String getId_wf_cfg() {
		return ((String) getAttrVal("Id_wf_cfg"));
	}
	/**
	 * 流向配置
	 * @param Id_wf_cfg
	 */
	public void setId_wf_cfg(String Id_wf_cfg) {
		setAttrVal("Id_wf_cfg", Id_wf_cfg);
	}
	/**
	 * 流向
	 * @return String
	 */
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}
	/**
	 * 流向
	 * @param Id_wf
	 */
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}
	/**
	 * 流向类型
	 * @return Integer
	 */
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}
	/**
	 * 流向类型
	 * @param Eu_wftp
	 */
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 优先级
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 宏标记
	 * @return FBoolean
	 */
	public FBoolean getFg_macro() {
		return ((FBoolean) getAttrVal("Fg_macro"));
	}
	/**
	 * 宏标记
	 * @param Fg_macro
	 */
	public void setFg_macro(FBoolean Fg_macro) {
		setAttrVal("Fg_macro", Fg_macro);
	}
	/**
	 * 宏
	 * @return Integer
	 */
	public Integer getEu_macro() {
		return ((Integer) getAttrVal("Eu_macro"));
	}
	/**
	 * 宏
	 * @param Eu_macro
	 */
	public void setEu_macro(Integer Eu_macro) {
		setAttrVal("Eu_macro", Eu_macro);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 服务分类限制
	 * @return Integer
	 */
	public Integer getEu_srvca() {
		return ((Integer) getAttrVal("Eu_srvca"));
	}
	/**
	 * 服务分类限制
	 * @param Eu_srvca
	 */
	public void setEu_srvca(Integer Eu_srvca) {
		setAttrVal("Eu_srvca", Eu_srvca);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}
	/**
	 * 服务分类内码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 服务限制
	 * @return Integer
	 */
	public Integer getEu_srv() {
		return ((Integer) getAttrVal("Eu_srv"));
	}
	/**
	 * 服务限制
	 * @param Eu_srv
	 */
	public void setEu_srv(Integer Eu_srv) {
		setAttrVal("Eu_srv", Eu_srv);
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
	 * 剂型限制
	 * @return Integer
	 */
	public Integer getEu_dosage() {
		return ((Integer) getAttrVal("Eu_dosage"));
	}
	/**
	 * 剂型限制
	 * @param Eu_dosage
	 */
	public void setEu_dosage(Integer Eu_dosage) {
		setAttrVal("Eu_dosage", Eu_dosage);
	}
	/**
	 * 剂型编码
	 * @return String
	 */
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}
	/**
	 * 剂型编码
	 * @param Sd_dosage
	 */
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
	}
	/**
	 * 剂型ID
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 剂型ID
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 毒麻限制
	 * @return Integer
	 */
	public Integer getEu_pois() {
		return ((Integer) getAttrVal("Eu_pois"));
	}
	/**
	 * 毒麻限制
	 * @param Eu_pois
	 */
	public void setEu_pois(Integer Eu_pois) {
		setAttrVal("Eu_pois", Eu_pois);
	}
	/**
	 * 毒麻
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 物品限制
	 * @return Integer
	 */
	public Integer getEu_mm() {
		return ((Integer) getAttrVal("Eu_mm"));
	}
	/**
	 * 物品限制
	 * @param Eu_mm
	 */
	public void setEu_mm(Integer Eu_mm) {
		setAttrVal("Eu_mm", Eu_mm);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 草药制剂限制
	 * @return Integer
	 */
	public Integer getEu_herbperp() {
		return ((Integer) getAttrVal("Eu_herbperp"));
	}
	/**
	 * 草药制剂限制
	 * @param Eu_herbperp
	 */
	public void setEu_herbperp(Integer Eu_herbperp) {
		setAttrVal("Eu_herbperp", Eu_herbperp);
	}
	/**
	 * 草药制剂
	 * @return String
	 */
	public String getSd_herbperp() {
		return ((String) getAttrVal("Sd_herbperp"));
	}
	/**
	 * 草药制剂
	 * @param Sd_herbperp
	 */
	public void setSd_herbperp(String Sd_herbperp) {
		setAttrVal("Sd_herbperp", Sd_herbperp);
	}
	/**
	 * 开单科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_or() {
		return ((Integer) getAttrVal("Eu_dep_or"));
	}
	/**
	 * 开单科室限制
	 * @param Eu_dep_or
	 */
	public void setEu_dep_or(Integer Eu_dep_or) {
		setAttrVal("Eu_dep_or", Eu_dep_or);
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
	 * 就诊科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_phy() {
		return ((Integer) getAttrVal("Eu_dep_phy"));
	}
	/**
	 * 就诊科室限制
	 * @param Eu_dep_phy
	 */
	public void setEu_dep_phy(Integer Eu_dep_phy) {
		setAttrVal("Eu_dep_phy", Eu_dep_phy);
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
	 * 护理单元限制
	 * @return Integer
	 */
	public Integer getEu_dep_nur() {
		return ((Integer) getAttrVal("Eu_dep_nur"));
	}
	/**
	 * 护理单元限制
	 * @param Eu_dep_nur
	 */
	public void setEu_dep_nur(Integer Eu_dep_nur) {
		setAttrVal("Eu_dep_nur", Eu_dep_nur);
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
	/**
	 * 用法限制
	 * @return Integer
	 */
	public Integer getEu_route() {
		return ((Integer) getAttrVal("Eu_route"));
	}
	/**
	 * 用法限制
	 * @param Eu_route
	 */
	public void setEu_route(Integer Eu_route) {
		setAttrVal("Eu_route", Eu_route);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 星期限制
	 * @return Integer
	 */
	public Integer getEu_week() {
		return ((Integer) getAttrVal("Eu_week"));
	}
	/**
	 * 星期限制
	 * @param Eu_week
	 */
	public void setEu_week(Integer Eu_week) {
		setAttrVal("Eu_week", Eu_week);
	}
	/**
	 * 星期
	 * @return String
	 */
	public String getSd_week() {
		return ((String) getAttrVal("Sd_week"));
	}
	/**
	 * 星期
	 * @param Sd_week
	 */
	public void setSd_week(String Sd_week) {
		setAttrVal("Sd_week", Sd_week);
	}
	/**
	 * 停开限制
	 * @return FBoolean
	 */
	public FBoolean getFg_mmwh() {
		return ((FBoolean) getAttrVal("Fg_mmwh"));
	}
	/**
	 * 停开限制
	 * @param Fg_mmwh
	 */
	public void setFg_mmwh(FBoolean Fg_mmwh) {
		setAttrVal("Fg_mmwh", Fg_mmwh);
	}
	/**
	 * 库存限制
	 * @return FBoolean
	 */
	public FBoolean getFg_stock() {
		return ((FBoolean) getAttrVal("Fg_stock"));
	}
	/**
	 * 库存限制
	 * @param Fg_stock
	 */
	public void setFg_stock(FBoolean Fg_stock) {
		setAttrVal("Fg_stock", Fg_stock);
	}
	/**
	 * 长临限制
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}
	/**
	 * 长临限制
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 出院带药限制
	 * @return Integer
	 */
	public Integer getEu_pres_out() {
		return ((Integer) getAttrVal("Eu_pres_out"));
	}
	/**
	 * 出院带药限制
	 * @param Eu_pres_out
	 */
	public void setEu_pres_out(Integer Eu_pres_out) {
		setAttrVal("Eu_pres_out", Eu_pres_out);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}
	/**
	 * 开始时间
	 * @param Time_begin
	 */
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 截止时间
	 * @return FTime
	 */
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}
	/**
	 * 截止时间
	 * @param Time_end
	 */
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
	}
	/**
	 * 年龄等级限制
	 * @return Integer
	 */
	public Integer getEu_age() {
		return ((Integer) getAttrVal("Eu_age"));
	}
	/**
	 * 年龄等级限制
	 * @param Eu_age
	 */
	public void setEu_age(Integer Eu_age) {
		setAttrVal("Eu_age", Eu_age);
	}
	/**
	 * 年龄等级
	 * @return String
	 */
	public String getId_age_level() {
		return ((String) getAttrVal("Id_age_level"));
	}
	/**
	 * 年龄等级
	 * @param Id_age_level
	 */
	public void setId_age_level(String Id_age_level) {
		setAttrVal("Id_age_level", Id_age_level);
	}
	/**
	 * 录入科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_record() {
		return ((Integer) getAttrVal("Eu_dep_record"));
	}
	/**
	 * 录入科室限制
	 * @param Eu_dep_record
	 */
	public void setEu_dep_record(Integer Eu_dep_record) {
		setAttrVal("Eu_dep_record", Eu_dep_record);
	}
	/**
	 * 录入科室
	 * @return String
	 */
	public String getId_dep_record() {
		return ((String) getAttrVal("Id_dep_record"));
	}
	/**
	 * 录入科室
	 * @param Id_dep_record
	 */
	public void setId_dep_record(String Id_dep_record) {
		setAttrVal("Id_dep_record", Id_dep_record);
	}
}