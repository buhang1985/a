package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院预约查询模板 DTO数据 
 * 
 */
public class AptIpQrySchmDTO extends BaseDTO {
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
	 * 计划再入院
	 * @return FBoolean
	 */
	public FBoolean getFg_rehos() {
		return ((FBoolean) getAttrVal("Fg_rehos"));
	}
	/**
	 * 计划再入院
	 * @param Fg_rehos
	 */
	public void setFg_rehos(FBoolean Fg_rehos) {
		setAttrVal("Fg_rehos", Fg_rehos);
	}
	/**
	 * 病情等级id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情等级
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 时间过滤类型
	 * @return String
	 */
	public String getTimetp() {
		return ((String) getAttrVal("Timetp"));
	}
	/**
	 * 时间过滤类型
	 * @param Timetp
	 */
	public void setTimetp(String Timetp) {
		setAttrVal("Timetp", Timetp);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}
	/**
	 * 开始日期
	 * @param D_b
	 */
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}
	/**
	 * 结束日期
	 * @param D_e
	 */
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 未预约
	 * @return FBoolean
	 */
	public FBoolean getFg_apt_no() {
		return ((FBoolean) getAttrVal("Fg_apt_no"));
	}
	/**
	 * 未预约
	 * @param Fg_apt_no
	 */
	public void setFg_apt_no(FBoolean Fg_apt_no) {
		setAttrVal("Fg_apt_no", Fg_apt_no);
	}
	/**
	 * 已预约
	 * @return FBoolean
	 */
	public FBoolean getFg_apt_yes() {
		return ((FBoolean) getAttrVal("Fg_apt_yes"));
	}
	/**
	 * 已预约
	 * @param Fg_apt_yes
	 */
	public void setFg_apt_yes(FBoolean Fg_apt_yes) {
		setAttrVal("Fg_apt_yes", Fg_apt_yes);
	}
	/**
	 * 已确认
	 * @return FBoolean
	 */
	public FBoolean getFg_sure() {
		return ((FBoolean) getAttrVal("Fg_sure"));
	}
	/**
	 * 已确认
	 * @param Fg_sure
	 */
	public void setFg_sure(FBoolean Fg_sure) {
		setAttrVal("Fg_sure", Fg_sure);
	}
	/**
	 * 是否申请
	 * @return FBoolean
	 */
	public FBoolean getFg_app() {
		return ((FBoolean) getAttrVal("Fg_app"));
	}
	/**
	 * 是否申请
	 * @param Fg_app
	 */
	public void setFg_app(FBoolean Fg_app) {
		setAttrVal("Fg_app", Fg_app);
	}
	/**
	 * 是否安排
	 * @return FBoolean
	 */
	public FBoolean getFg_plan() {
		return ((FBoolean) getAttrVal("Fg_plan"));
	}
	/**
	 * 是否安排
	 * @param Fg_plan
	 */
	public void setFg_plan(FBoolean Fg_plan) {
		setAttrVal("Fg_plan", Fg_plan);
	}
	/**
	 * 是否入院
	 * @return FBoolean
	 */
	public FBoolean getFg_inhos() {
		return ((FBoolean) getAttrVal("Fg_inhos"));
	}
	/**
	 * 是否入院
	 * @param Fg_inhos
	 */
	public void setFg_inhos(FBoolean Fg_inhos) {
		setAttrVal("Fg_inhos", Fg_inhos);
	}
	/**
	 * 是否拒绝
	 * @return FBoolean
	 */
	public FBoolean getFg_refuse() {
		return ((FBoolean) getAttrVal("Fg_refuse"));
	}
	/**
	 * 是否拒绝
	 * @param Fg_refuse
	 */
	public void setFg_refuse(FBoolean Fg_refuse) {
		setAttrVal("Fg_refuse", Fg_refuse);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 开单医生
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 开单医生
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 开单医生名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 开单医生名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 节点编码
	 * @return String
	 */
	public String getLetparam() {
		return ((String) getAttrVal("Letparam"));
	}
	/**
	 * 节点编码
	 * @param Letparam
	 */
	public void setLetparam(String Letparam) {
		setAttrVal("Letparam", Letparam);
	}
}