package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊接诊队列 DTO数据 
 * 
 */
public class ReceptionQueDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊队列
	 * @return String
	 */
	public String getId_ent_que() {
		return ((String) getAttrVal("Id_ent_que"));
	}
	/**
	 * 患者就诊队列
	 * @param Id_ent_que
	 */
	public void setId_ent_que(String Id_ent_que) {
		setAttrVal("Id_ent_que", Id_ent_que);
	}
	/**
	 * 患者就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型ID
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型ID
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 就诊号
	 * @return String
	 */
	public String getTicketno() {
		return ((String) getAttrVal("Ticketno"));
	}
	/**
	 * 就诊号
	 * @param Ticketno
	 */
	public void setTicketno(String Ticketno) {
		setAttrVal("Ticketno", Ticketno);
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
	 * 挂号号段
	 * @return String
	 */
	public String getTicks() {
		return ((String) getAttrVal("Ticks"));
	}
	/**
	 * 挂号号段
	 * @param Ticks
	 */
	public void setTicks(String Ticks) {
		setAttrVal("Ticks", Ticks);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别ID
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
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
	 * 电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 医保计划ID
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划ID
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保计划
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 患者分类ID
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类ID
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
	 * 回诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needrtn() {
		return ((FBoolean) getAttrVal("Fg_needrtn"));
	}
	/**
	 * 回诊标志
	 * @param Fg_needrtn
	 */
	public void setFg_needrtn(FBoolean Fg_needrtn) {
		setAttrVal("Fg_needrtn", Fg_needrtn);
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
	 * 主诊断ID
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}
	/**
	 * 主诊断ID
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	/**
	 * 主诊断
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 主诊断
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 诊毕时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ent() {
		return ((FDateTime) getAttrVal("Dt_ent"));
	}
	/**
	 * 诊毕时间
	 * @param Dt_ent
	 */
	public void setDt_ent(FDateTime Dt_ent) {
		setAttrVal("Dt_ent", Dt_ent);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getEnt_status() {
		return ((String) getAttrVal("Ent_status"));
	}
	/**
	 * 状态
	 * @param Ent_status
	 */
	public void setEnt_status(String Ent_status) {
		setAttrVal("Ent_status", Ent_status);
	}
	/**
	 * 门诊医生ID
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 门诊医生ID
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 门诊医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 门诊科室ID
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 门诊科室ID
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 门诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 门诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 就诊时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
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
	 * 分诊签到时间
	 * @return FDateTime
	 */
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}
	/**
	 * 分诊签到时间
	 * @param Dt_in
	 */
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 预检分级
	 * @return String
	 */
	public String getName_lev() {
		return ((String) getAttrVal("Name_lev"));
	}
	/**
	 * 预检分级
	 * @param Name_lev
	 */
	public void setName_lev(String Name_lev) {
		setAttrVal("Name_lev", Name_lev);
	}
	/**
	 * 滞留时长
	 * @return String
	 */
	public String getTime_dura() {
		return ((String) getAttrVal("Time_dura"));
	}
	/**
	 * 滞留时长
	 * @param Time_dura
	 */
	public void setTime_dura(String Time_dura) {
		setAttrVal("Time_dura", Time_dura);
	}
	/**
	 * 到院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_er() {
		return ((FDateTime) getAttrVal("Dt_entry_er"));
	}
	/**
	 * 到院时间
	 * @param Dt_entry_er
	 */
	public void setDt_entry_er(FDateTime Dt_entry_er) {
		setAttrVal("Dt_entry_er", Dt_entry_er);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_er() {
		return ((FDateTime) getAttrVal("Dt_end_er"));
	}
	/**
	 * 出院时间
	 * @param Dt_end_er
	 */
	public void setDt_end_er(FDateTime Dt_end_er) {
		setAttrVal("Dt_end_er", Dt_end_er);
	}
	/**
	 * 预检分级编码
	 * @return String
	 */
	public String getSd_lev() {
		return ((String) getAttrVal("Sd_lev"));
	}
	/**
	 * 预检分级编码
	 * @param Sd_lev
	 */
	public void setSd_lev(String Sd_lev) {
		setAttrVal("Sd_lev", Sd_lev);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}
	/**
	 * 就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 站点id
	 * @return String
	 */
	public String getId_que_site() {
		return ((String) getAttrVal("Id_que_site"));
	}
	/**
	 * 站点id
	 * @param Id_que_site
	 */
	public void setId_que_site(String Id_que_site) {
		setAttrVal("Id_que_site", Id_que_site);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 地址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 身份证号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 患者拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 患者拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 患者条形码
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * 患者条形码
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 客开扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客开扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客开扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客开扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客开扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客开扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客开扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客开扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客开扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客开扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
}