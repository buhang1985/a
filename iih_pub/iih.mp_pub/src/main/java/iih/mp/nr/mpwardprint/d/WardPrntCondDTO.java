package iih.mp.nr.mpwardprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病区执行打印报表条件 DTO数据 
 * 
 */
public class WardPrntCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单据ID
	 * @return String
	 */
	public String getId_or_prntca() {
		return ((String) getAttrVal("Id_or_prntca"));
	}
	/**
	 * 单据ID
	 * @param Id_or_prntca
	 */
	public void setId_or_prntca(String Id_or_prntca) {
		setAttrVal("Id_or_prntca", Id_or_prntca);
	}
	/**
	 * 单据名称
	 * @return String
	 */
	public String getName_or_prntca() {
		return ((String) getAttrVal("Name_or_prntca"));
	}
	/**
	 * 单据名称
	 * @param Name_or_prntca
	 */
	public void setName_or_prntca(String Name_or_prntca) {
		setAttrVal("Name_or_prntca", Name_or_prntca);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 执行单据类型ID
	 * @return String
	 */
	public String getId_prntp() {
		return ((String) getAttrVal("Id_prntp"));
	}
	/**
	 * 执行单据类型ID
	 * @param Id_prntp
	 */
	public void setId_prntp(String Id_prntp) {
		setAttrVal("Id_prntp", Id_prntp);
	}
	/**
	 * 就诊ID串
	 * @return String
	 */
	public String getId_ents() {
		return ((String) getAttrVal("Id_ents"));
	}
	/**
	 * 就诊ID串
	 * @param Id_ents
	 */
	public void setId_ents(String Id_ents) {
		setAttrVal("Id_ents", Id_ents);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 长临
	 * @return String
	 */
	public String getEu_long() {
		return ((String) getAttrVal("Eu_long"));
	}
	/**
	 * 长临
	 * @param Eu_long
	 */
	public void setEu_long(String Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 服务类型串
	 * @return String
	 */
	public String getSd_srvtps() {
		return ((String) getAttrVal("Sd_srvtps"));
	}
	/**
	 * 服务类型串
	 * @param Sd_srvtps
	 */
	public void setSd_srvtps(String Sd_srvtps) {
		setAttrVal("Sd_srvtps", Sd_srvtps);
	}
	/**
	 * 用法串
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 用法串
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 特殊频次
	 * @return String
	 */
	public String getFg_spec_freq() {
		return ((String) getAttrVal("Fg_spec_freq"));
	}
	/**
	 * 特殊频次
	 * @param Fg_spec_freq
	 */
	public void setFg_spec_freq(String Fg_spec_freq) {
		setAttrVal("Fg_spec_freq", Fg_spec_freq);
	}
	/**
	 * 频次串
	 * @return String
	 */
	public String getId_freqs() {
		return ((String) getAttrVal("Id_freqs"));
	}
	/**
	 * 频次串
	 * @param Id_freqs
	 */
	public void setId_freqs(String Id_freqs) {
		setAttrVal("Id_freqs", Id_freqs);
	}
	/**
	 * 打印状态
	 * @return String
	 */
	public String getEu_print() {
		return ((String) getAttrVal("Eu_print"));
	}
	/**
	 * 打印状态
	 * @param Eu_print
	 */
	public void setEu_print(String Eu_print) {
		setAttrVal("Eu_print", Eu_print);
	}
	/**
	 * 计划折叠
	 * @return String
	 */
	public String getFg_plan_fold() {
		return ((String) getAttrVal("Fg_plan_fold"));
	}
	/**
	 * 计划折叠
	 * @param Fg_plan_fold
	 */
	public void setFg_plan_fold(String Fg_plan_fold) {
		setAttrVal("Fg_plan_fold", Fg_plan_fold);
	}
	/**
	 * 毒麻标记
	 * @return String
	 */
	public String getEu_pois() {
		return ((String) getAttrVal("Eu_pois"));
	}
	/**
	 * 毒麻标记
	 * @param Eu_pois
	 */
	public void setEu_pois(String Eu_pois) {
		setAttrVal("Eu_pois", Eu_pois);
	}
	/**
	 * 出院带药
	 * @return String
	 */
	public String getEu_outp() {
		return ((String) getAttrVal("Eu_outp"));
	}
	/**
	 * 出院带药
	 * @param Eu_outp
	 */
	public void setEu_outp(String Eu_outp) {
		setAttrVal("Eu_outp", Eu_outp);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_dep_whs() {
		return ((String) getAttrVal("Id_dep_whs"));
	}
	/**
	 * 仓库
	 * @param Id_dep_whs
	 */
	public void setId_dep_whs(String Id_dep_whs) {
		setAttrVal("Id_dep_whs", Id_dep_whs);
	}
	/**
	 * 标本类型串
	 * @return String
	 */
	public String getId_samtp() {
		return ((String) getAttrVal("Id_samtp"));
	}
	/**
	 * 标本类型串
	 * @param Id_samtp
	 */
	public void setId_samtp(String Id_samtp) {
		setAttrVal("Id_samtp", Id_samtp);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 医疗服务串
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 医疗服务串
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}
	/**
	 * 扩展字段2
	 * @param Ctrl2
	 */
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}
	/**
	 * 扩展字段3
	 * @param Ctrl3
	 */
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}
	/**
	 * 扩展字段4
	 * @param Ctrl4
	 */
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}
	/**
	 * 扩展字段5
	 * @param Ctrl5
	 */
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_exec() {
		return ((Integer) getAttrVal("Eu_exec"));
	}
	/**
	 * 执行状态
	 * @param Eu_exec
	 */
	public void setEu_exec(Integer Eu_exec) {
		setAttrVal("Eu_exec", Eu_exec);
	}
}