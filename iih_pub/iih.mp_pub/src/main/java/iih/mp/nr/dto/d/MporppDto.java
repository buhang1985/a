package iih.mp.nr.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱执行DTO DTO数据 
 * 
 */
public class MporppDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱执行记录ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行记录ID
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 对应关联医嘱ID
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 对应关联医嘱ID
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
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
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getId_freq_name() {
		return ((String) getAttrVal("Id_freq_name"));
	}
	/**
	 * 医嘱频次名称
	 * @param Id_freq_name
	 */
	public void setId_freq_name(String Id_freq_name) {
		setAttrVal("Id_freq_name", Id_freq_name);
	}
	/**
	 * 医嘱频次编码
	 * @return String
	 */
	public String getId_freq_code() {
		return ((String) getAttrVal("Id_freq_code"));
	}
	/**
	 * 医嘱频次编码
	 * @param Id_freq_code
	 */
	public void setId_freq_code(String Id_freq_code) {
		setAttrVal("Id_freq_code", Id_freq_code);
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
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 持续时间
	 * @return Integer
	 */
	public Integer getDurationsec() {
		return ((Integer) getAttrVal("Durationsec"));
	}
	/**
	 * 持续时间
	 * @param Durationsec
	 */
	public void setDurationsec(Integer Durationsec) {
		setAttrVal("Durationsec", Durationsec);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getOr_content() {
		return ((String) getAttrVal("Or_content"));
	}
	/**
	 * 医嘱内容
	 * @param Or_content
	 */
	public void setOr_content(String Or_content) {
		setAttrVal("Or_content", Or_content);
	}
	/**
	 * 医嘱名称
	 * @return String
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
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 需皮试的药嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skindrug() {
		return ((FBoolean) getAttrVal("Fg_skindrug"));
	}
	/**
	 * 需皮试的药嘱标识
	 * @param Fg_skindrug
	 */
	public void setFg_skindrug(FBoolean Fg_skindrug) {
		setAttrVal("Fg_skindrug", Fg_skindrug);
	}
	/**
	 * 皮试结果ID
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}
	/**
	 * 皮试结果ID
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 皮试结果名称
	 * @return String
	 */
	public String getName_skintest() {
		return ((String) getAttrVal("Name_skintest"));
	}
	/**
	 * 皮试结果名称
	 * @param Name_skintest
	 */
	public void setName_skintest(String Name_skintest) {
		setAttrVal("Name_skintest", Name_skintest);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 床旁执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}
	/**
	 * 床旁执行标识
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	/**
	 * 执行确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_confirm() {
		return ((FDateTime) getAttrVal("Dt_mp_confirm"));
	}
	/**
	 * 执行确认时间
	 * @param Dt_mp_confirm
	 */
	public void setDt_mp_confirm(FDateTime Dt_mp_confirm) {
		setAttrVal("Dt_mp_confirm", Dt_mp_confirm);
	}
	/**
	 * 执行确认人
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}
	/**
	 * 执行确认人
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 执行确认人名称
	 * @return String
	 */
	public String getId_emp_confirm_name() {
		return ((String) getAttrVal("Id_emp_confirm_name"));
	}
	/**
	 * 执行确认人名称
	 * @param Id_emp_confirm_name
	 */
	public void setId_emp_confirm_name(String Id_emp_confirm_name) {
		setAttrVal("Id_emp_confirm_name", Id_emp_confirm_name);
	}
	/**
	 * 执行确认人编码
	 * @return String
	 */
	public String getId_emp_confirm_code() {
		return ((String) getAttrVal("Id_emp_confirm_code"));
	}
	/**
	 * 执行确认人编码
	 * @param Id_emp_confirm_code
	 */
	public void setId_emp_confirm_code(String Id_emp_confirm_code) {
		setAttrVal("Id_emp_confirm_code", Id_emp_confirm_code);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_confirm() {
		return ((String) getAttrVal("Id_dep_confirm"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_confirm
	 */
	public void setId_dep_confirm(String Id_dep_confirm) {
		setAttrVal("Id_dep_confirm", Id_dep_confirm);
	}
	/**
	 * 不执行原因
	 * @return String
	 */
	public String getId_skip_reason() {
		return ((String) getAttrVal("Id_skip_reason"));
	}
	/**
	 * 不执行原因
	 * @param Id_skip_reason
	 */
	public void setId_skip_reason(String Id_skip_reason) {
		setAttrVal("Id_skip_reason", Id_skip_reason);
	}
	/**
	 * 不执行原因编码
	 * @return String
	 */
	public String getSd_skip_reason() {
		return ((String) getAttrVal("Sd_skip_reason"));
	}
	/**
	 * 不执行原因编码
	 * @param Sd_skip_reason
	 */
	public void setSd_skip_reason(String Sd_skip_reason) {
		setAttrVal("Sd_skip_reason", Sd_skip_reason);
	}
	/**
	 * 不执行原因描述
	 * @return String
	 */
	public String getSkip_reason() {
		return ((String) getAttrVal("Skip_reason"));
	}
	/**
	 * 不执行原因描述
	 * @param Skip_reason
	 */
	public void setSkip_reason(String Skip_reason) {
		setAttrVal("Skip_reason", Skip_reason);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 皮试明细
	 * @return FArrayList
	 */
	public FArrayList getSkindetail() {
		return ((FArrayList) getAttrVal("Skindetail"));
	}
	/**
	 * 皮试明细
	 * @param Skindetail
	 */
	public void setSkindetail(FArrayList Skindetail) {
		setAttrVal("Skindetail", Skindetail);
	}
	/**
	 * 取整模式
	 * @return String
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}
	/**
	 * 取整模式
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	/**
	 * 床旁余量
	 * @return String
	 */
	public String getQuan_bed_medu() {
		return ((String) getAttrVal("Quan_bed_medu"));
	}
	/**
	 * 床旁余量
	 * @param Quan_bed_medu
	 */
	public void setQuan_bed_medu(String Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	/**
	 * 余量单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 余量单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 余量
	 * @return String
	 */
	public String getName_quan() {
		return ((String) getAttrVal("Name_quan"));
	}
	/**
	 * 余量
	 * @param Name_quan
	 */
	public void setName_quan(String Name_quan) {
		setAttrVal("Name_quan", Name_quan);
	}
	/**
	 * 上一顿是否执行
	 * @return FBoolean
	 */
	public FBoolean getFg_mplast() {
		return ((FBoolean) getAttrVal("Fg_mplast"));
	}
	/**
	 * 上一顿是否执行
	 * @param Fg_mplast
	 */
	public void setFg_mplast(FBoolean Fg_mplast) {
		setAttrVal("Fg_mplast", Fg_mplast);
	}
	/**
	 * 可执行计划时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_lately() {
		return ((FDateTime) getAttrVal("Dt_mp_lately"));
	}
	/**
	 * 可执行计划时间
	 * @param Dt_mp_lately
	 */
	public void setDt_mp_lately(FDateTime Dt_mp_lately) {
		setAttrVal("Dt_mp_lately", Dt_mp_lately);
	}
	/**
	 * 操作时间
	 * @return String
	 */
	public String getDt_oper() {
		return ((String) getAttrVal("Dt_oper"));
	}
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(String Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}
	/**
	 * 记账时间
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 医嘱编码
	 * @return String
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
}