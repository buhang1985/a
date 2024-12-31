package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家分诊_就诊队列DTO DTO数据 
 * 
 */
public class PisPhkTriageEntDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊队列id
	 * @return String
	 */
	public String getId_entque() {
		return ((String) getAttrVal("Id_entque"));
	}
	/**
	 * 就诊队列id
	 * @param Id_entque
	 */
	public void setId_entque(String Id_entque) {
		setAttrVal("Id_entque", Id_entque);
	}
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 队列
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}
	/**
	 * 队列
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
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
	 * 就诊号
	 * @return String
	 */
	public String getTickno() {
		return ((String) getAttrVal("Tickno"));
	}
	/**
	 * 就诊号
	 * @param Tickno
	 */
	public void setTickno(String Tickno) {
		setAttrVal("Tickno", Tickno);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 资源
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 资源
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getRes() {
		return ((String) getAttrVal("Res"));
	}
	/**
	 * 资源名称
	 * @param Res
	 */
	public void setRes(String Res) {
		setAttrVal("Res", Res);
	}
	/**
	 * 诊台id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 诊台id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 诊台
	 * @return String
	 */
	public String getName_quesite() {
		return ((String) getAttrVal("Name_quesite"));
	}
	/**
	 * 诊台
	 * @param Name_quesite
	 */
	public void setName_quesite(String Name_quesite) {
		setAttrVal("Name_quesite", Name_quesite);
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
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 资源服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 资源服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 号别
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 号别
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 就诊队列状态
	 * @return String
	 */
	public String getSd_status_acpt() {
		return ((String) getAttrVal("Sd_status_acpt"));
	}
	/**
	 * 就诊队列状态
	 * @param Sd_status_acpt
	 */
	public void setSd_status_acpt(String Sd_status_acpt) {
		setAttrVal("Sd_status_acpt", Sd_status_acpt);
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
	 * 病情级别
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情级别
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 优先级别
	 * @return String
	 */
	public String getLevel_pri() {
		return ((String) getAttrVal("Level_pri"));
	}
	/**
	 * 优先级别
	 * @param Level_pri
	 */
	public void setLevel_pri(String Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 优先原因
	 * @return String
	 */
	public String getLevel_pri_rsn() {
		return ((String) getAttrVal("Level_pri_rsn"));
	}
	/**
	 * 优先原因
	 * @param Level_pri_rsn
	 */
	public void setLevel_pri_rsn(String Level_pri_rsn) {
		setAttrVal("Level_pri_rsn", Level_pri_rsn);
	}
	/**
	 * 票号
	 * @return String
	 */
	public String getTicketno() {
		return ((String) getAttrVal("Ticketno"));
	}
	/**
	 * 票号
	 * @param Ticketno
	 */
	public void setTicketno(String Ticketno) {
		setAttrVal("Ticketno", Ticketno);
	}
	/**
	 * 初诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_first() {
		return ((FBoolean) getAttrVal("Fg_first"));
	}
	/**
	 * 初诊标志
	 * @param Fg_first
	 */
	public void setFg_first(FBoolean Fg_first) {
		setAttrVal("Fg_first", Fg_first);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getQuestatus() {
		return ((String) getAttrVal("Questatus"));
	}
	/**
	 * 状态
	 * @param Questatus
	 */
	public void setQuestatus(String Questatus) {
		setAttrVal("Questatus", Questatus);
	}
	/**
	 * 挂号时间
	 * @return FDate
	 */
	public FDate getDt_regist() {
		return ((FDate) getAttrVal("Dt_regist"));
	}
	/**
	 * 挂号时间
	 * @param Dt_regist
	 */
	public void setDt_regist(FDate Dt_regist) {
		setAttrVal("Dt_regist", Dt_regist);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 需回诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needrtn() {
		return ((FBoolean) getAttrVal("Fg_needrtn"));
	}
	/**
	 * 需回诊标志
	 * @param Fg_needrtn
	 */
	public void setFg_needrtn(FBoolean Fg_needrtn) {
		setAttrVal("Fg_needrtn", Fg_needrtn);
	}
	/**
	 * 手动分诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}
	/**
	 * 手动分诊标志
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
	}
	/**
	 * 叫号顺序号
	 * @return Integer
	 */
	public Integer getSortno_called() {
		return ((Integer) getAttrVal("Sortno_called"));
	}
	/**
	 * 叫号顺序号
	 * @param Sortno_called
	 */
	public void setSortno_called(Integer Sortno_called) {
		setAttrVal("Sortno_called", Sortno_called);
	}
	/**
	 * 排班计划ID
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班计划ID
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 排班计划名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 排班计划名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 上屏状态
	 * @return String
	 */
	public String getScreen_status() {
		return ((String) getAttrVal("Screen_status"));
	}
	/**
	 * 上屏状态
	 * @param Screen_status
	 */
	public void setScreen_status(String Screen_status) {
		setAttrVal("Screen_status", Screen_status);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
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
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 挂号医生id
	 * @return String
	 */
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}
	/**
	 * 挂号医生id
	 * @param Id_emp_reg
	 */
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 最后月经期
	 * @return FDate
	 */
	public FDate getD_last_menst() {
		return ((FDate) getAttrVal("D_last_menst"));
	}
	/**
	 * 最后月经期
	 * @param D_last_menst
	 */
	public void setD_last_menst(FDate D_last_menst) {
		setAttrVal("D_last_menst", D_last_menst);
	}
	/**
	 * 预检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_preobs() {
		return ((FBoolean) getAttrVal("Fg_preobs"));
	}
	/**
	 * 预检标志
	 * @param Fg_preobs
	 */
	public void setFg_preobs(FBoolean Fg_preobs) {
		setAttrVal("Fg_preobs", Fg_preobs);
	}
	/**
	 * 怀孕时间
	 * @return String
	 */
	public String getPreg_tiem() {
		return ((String) getAttrVal("Preg_tiem"));
	}
	/**
	 * 怀孕时间
	 * @param Preg_tiem
	 */
	public void setPreg_tiem(String Preg_tiem) {
		setAttrVal("Preg_tiem", Preg_tiem);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_mdsrv() {
		return ((String) getAttrVal("Id_mdsrv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_mdsrv
	 */
	public void setId_mdsrv(String Id_mdsrv) {
		setAttrVal("Id_mdsrv", Id_mdsrv);
	}
	/**
	 * 预检状态
	 * @return String
	 */
	public String getEu_preobs() {
		return ((String) getAttrVal("Eu_preobs"));
	}
	/**
	 * 预检状态
	 * @param Eu_preobs
	 */
	public void setEu_preobs(String Eu_preobs) {
		setAttrVal("Eu_preobs", Eu_preobs);
	}
	/**
	 * 号别id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 号别id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 号别编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
}