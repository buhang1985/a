package iih.syn.sen.entin.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者就诊 DTO数据 
 * 
 */
public class VwEntDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者ID
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTime_cur() {
		return ((String) getAttrVal("Time_cur"));
	}
	/**
	 * 就诊次数
	 * @param Time_cur
	 */
	public void setTime_cur(String Time_cur) {
		setAttrVal("Time_cur", Time_cur);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
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
	 * 组织机构编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 组织机构编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案号
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 就诊状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 就诊状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 就诊状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 当前主诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}
	/**
	 * 当前主诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 当前主诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 当前主诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 就诊登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊登记时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 就诊登记人
	 * @return String
	 */
	public String getCode_emp_entry() {
		return ((String) getAttrVal("Code_emp_entry"));
	}
	/**
	 * 就诊登记人
	 * @param Code_emp_entry
	 */
	public void setCode_emp_entry(String Code_emp_entry) {
		setAttrVal("Code_emp_entry", Code_emp_entry);
	}
	/**
	 * 就诊登记科室
	 * @return String
	 */
	public String getCode_dep_entry() {
		return ((String) getAttrVal("Code_dep_entry"));
	}
	/**
	 * 就诊登记科室
	 * @param Code_dep_entry
	 */
	public void setCode_dep_entry(String Code_dep_entry) {
		setAttrVal("Code_dep_entry", Code_dep_entry);
	}
	/**
	 * 接诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rcv() {
		return ((FDateTime) getAttrVal("Dt_rcv"));
	}
	/**
	 * 接诊时间
	 * @param Dt_rcv
	 */
	public void setDt_rcv(FDateTime Dt_rcv) {
		setAttrVal("Dt_rcv", Dt_rcv);
	}
	/**
	 * 接诊医生
	 * @return String
	 */
	public String getCode_emp_rcv() {
		return ((String) getAttrVal("Code_emp_rcv"));
	}
	/**
	 * 接诊医生
	 * @param Code_emp_rcv
	 */
	public void setCode_emp_rcv(String Code_emp_rcv) {
		setAttrVal("Code_emp_rcv", Code_emp_rcv);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getCode_dep_rcv() {
		return ((String) getAttrVal("Code_dep_rcv"));
	}
	/**
	 * 就诊科室
	 * @param Code_dep_rcv
	 */
	public void setCode_dep_rcv(String Code_dep_rcv) {
		setAttrVal("Code_dep_rcv", Code_dep_rcv);
	}
	/**
	 * 病情登记编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情登记编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情登记名称
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情登记名称
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}
	/**
	 * 护理等级编码
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 护理等级名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 护理等级名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 入院科室编码
	 * @return String
	 */
	public String getCode_dep_phyadm() {
		return ((String) getAttrVal("Code_dep_phyadm"));
	}
	/**
	 * 入院科室编码
	 * @param Code_dep_phyadm
	 */
	public void setCode_dep_phyadm(String Code_dep_phyadm) {
		setAttrVal("Code_dep_phyadm", Code_dep_phyadm);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室名称
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院病区编码
	 * @return String
	 */
	public String getCode_dep_nuradm() {
		return ((String) getAttrVal("Code_dep_nuradm"));
	}
	/**
	 * 入院病区编码
	 * @param Code_dep_nuradm
	 */
	public void setCode_dep_nuradm(String Code_dep_nuradm) {
		setAttrVal("Code_dep_nuradm", Code_dep_nuradm);
	}
	/**
	 * 入院病区名称
	 * @return String
	 */
	public String getName_dep_nuradm() {
		return ((String) getAttrVal("Name_dep_nuradm"));
	}
	/**
	 * 入院病区名称
	 * @param Name_dep_nuradm
	 */
	public void setName_dep_nuradm(String Name_dep_nuradm) {
		setAttrVal("Name_dep_nuradm", Name_dep_nuradm);
	}
	/**
	 * 病区接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 病区接收时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入科操作人编码
	 * @return String
	 */
	public String getCode_emp_acpt() {
		return ((String) getAttrVal("Code_emp_acpt"));
	}
	/**
	 * 入科操作人编码
	 * @param Code_emp_acpt
	 */
	public void setCode_emp_acpt(String Code_emp_acpt) {
		setAttrVal("Code_emp_acpt", Code_emp_acpt);
	}
	/**
	 * 入科操作人名称
	 * @return String
	 */
	public String getName_emp_acpt() {
		return ((String) getAttrVal("Name_emp_acpt"));
	}
	/**
	 * 入科操作人名称
	 * @param Name_emp_acpt
	 */
	public void setName_emp_acpt(String Name_emp_acpt) {
		setAttrVal("Name_emp_acpt", Name_emp_acpt);
	}
	/**
	 * 医疗组编码
	 * @return String
	 */
	public String getCode_wg_phy() {
		return ((String) getAttrVal("Code_wg_phy"));
	}
	/**
	 * 医疗组编码
	 * @param Code_wg_phy
	 */
	public void setCode_wg_phy(String Code_wg_phy) {
		setAttrVal("Code_wg_phy", Code_wg_phy);
	}
	/**
	 * 医疗组名称
	 * @return String
	 */
	public String getName_wg_phy() {
		return ((String) getAttrVal("Name_wg_phy"));
	}
	/**
	 * 医疗组名称
	 * @param Name_wg_phy
	 */
	public void setName_wg_phy(String Name_wg_phy) {
		setAttrVal("Name_wg_phy", Name_wg_phy);
	}
	/**
	 * 主任医生编码
	 * @return String
	 */
	public String getCode_drc_emp() {
		return ((String) getAttrVal("Code_drc_emp"));
	}
	/**
	 * 主任医生编码
	 * @param Code_drc_emp
	 */
	public void setCode_drc_emp(String Code_drc_emp) {
		setAttrVal("Code_drc_emp", Code_drc_emp);
	}
	/**
	 * 主任医生名称
	 * @return String
	 */
	public String getName_drc_emp() {
		return ((String) getAttrVal("Name_drc_emp"));
	}
	/**
	 * 主任医生名称
	 * @param Name_drc_emp
	 */
	public void setName_drc_emp(String Name_drc_emp) {
		setAttrVal("Name_drc_emp", Name_drc_emp);
	}
	/**
	 * 主治医生编码
	 * @return String
	 */
	public String getCode_dcc_emp() {
		return ((String) getAttrVal("Code_dcc_emp"));
	}
	/**
	 * 主治医生编码
	 * @param Code_dcc_emp
	 */
	public void setCode_dcc_emp(String Code_dcc_emp) {
		setAttrVal("Code_dcc_emp", Code_dcc_emp);
	}
	/**
	 * 主治医生名称
	 * @return String
	 */
	public String getName_dcc_emp() {
		return ((String) getAttrVal("Name_dcc_emp"));
	}
	/**
	 * 主治医生名称
	 * @param Name_dcc_emp
	 */
	public void setName_dcc_emp(String Name_dcc_emp) {
		setAttrVal("Name_dcc_emp", Name_dcc_emp);
	}
	/**
	 * 住院医师编码
	 * @return String
	 */
	public String getCode_ip_emp() {
		return ((String) getAttrVal("Code_ip_emp"));
	}
	/**
	 * 住院医师编码
	 * @param Code_ip_emp
	 */
	public void setCode_ip_emp(String Code_ip_emp) {
		setAttrVal("Code_ip_emp", Code_ip_emp);
	}
	/**
	 * 住院医师名称
	 * @return String
	 */
	public String getName_ip_emp() {
		return ((String) getAttrVal("Name_ip_emp"));
	}
	/**
	 * 住院医师名称
	 * @param Name_ip_emp
	 */
	public void setName_ip_emp(String Name_ip_emp) {
		setAttrVal("Name_ip_emp", Name_ip_emp);
	}
	/**
	 * 责任医生编码
	 * @return String
	 */
	public String getCode_phy_emp() {
		return ((String) getAttrVal("Code_phy_emp"));
	}
	/**
	 * 责任医生编码
	 * @param Code_phy_emp
	 */
	public void setCode_phy_emp(String Code_phy_emp) {
		setAttrVal("Code_phy_emp", Code_phy_emp);
	}
	/**
	 * 责任医生名称
	 * @return String
	 */
	public String getName_phy_emp() {
		return ((String) getAttrVal("Name_phy_emp"));
	}
	/**
	 * 责任医生名称
	 * @param Name_phy_emp
	 */
	public void setName_phy_emp(String Name_phy_emp) {
		setAttrVal("Name_phy_emp", Name_phy_emp);
	}
	/**
	 * 责任护士编码
	 * @return String
	 */
	public String getCode_nur_emp() {
		return ((String) getAttrVal("Code_nur_emp"));
	}
	/**
	 * 责任护士编码
	 * @param Code_nur_emp
	 */
	public void setCode_nur_emp(String Code_nur_emp) {
		setAttrVal("Code_nur_emp", Code_nur_emp);
	}
	/**
	 * 责任护士名称
	 * @return String
	 */
	public String getName_nur_emp() {
		return ((String) getAttrVal("Name_nur_emp"));
	}
	/**
	 * 责任护士名称
	 * @param Name_nur_emp
	 */
	public void setName_nur_emp(String Name_nur_emp) {
		setAttrVal("Name_nur_emp", Name_nur_emp);
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
	 * 房间号
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}
	/**
	 * 房间号
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	/**
	 * 总预交金
	 * @return String
	 */
	public String getAmt_prepay() {
		return ((String) getAttrVal("Amt_prepay"));
	}
	/**
	 * 总预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(String Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 总费用
	 * @return String
	 */
	public String getAmt_pay() {
		return ((String) getAttrVal("Amt_pay"));
	}
	/**
	 * 总费用
	 * @param Amt_pay
	 */
	public void setAmt_pay(String Amt_pay) {
		setAttrVal("Amt_pay", Amt_pay);
	}
	/**
	 * 欠费金额
	 * @return String
	 */
	public String getAmt_overfee() {
		return ((String) getAttrVal("Amt_overfee"));
	}
	/**
	 * 欠费金额
	 * @param Amt_overfee
	 */
	public void setAmt_overfee(String Amt_overfee) {
		setAttrVal("Amt_overfee", Amt_overfee);
	}
	/**
	 * 临场路径在径标识
	 * @return String
	 */
	public String getFg_hp() {
		return ((String) getAttrVal("Fg_hp"));
	}
	/**
	 * 临场路径在径标识
	 * @param Fg_hp
	 */
	public void setFg_hp(String Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 手术标识
	 * @return String
	 */
	public String getFg_oper() {
		return ((String) getAttrVal("Fg_oper"));
	}
	/**
	 * 手术标识
	 * @param Fg_oper
	 */
	public void setFg_oper(String Fg_oper) {
		setAttrVal("Fg_oper", Fg_oper);
	}
	/**
	 * 随访标识
	 * @return String
	 */
	public String getFg_visit() {
		return ((String) getAttrVal("Fg_visit"));
	}
	/**
	 * 随访标识
	 * @param Fg_visit
	 */
	public void setFg_visit(String Fg_visit) {
		setAttrVal("Fg_visit", Fg_visit);
	}
	/**
	 * 召回标识
	 * @return String
	 */
	public String getFg_callback() {
		return ((String) getAttrVal("Fg_callback"));
	}
	/**
	 * 召回标识
	 * @param Fg_callback
	 */
	public void setFg_callback(String Fg_callback) {
		setAttrVal("Fg_callback", Fg_callback);
	}
	/**
	 * 死亡时间
	 * @return FDateTime
	 */
	public FDateTime getDt_death() {
		return ((FDateTime) getAttrVal("Dt_death"));
	}
	/**
	 * 死亡时间
	 * @param Dt_death
	 */
	public void setDt_death(FDateTime Dt_death) {
		setAttrVal("Dt_death", Dt_death);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 出院操作人编码
	 * @return String
	 */
	public String getCode_emp_end() {
		return ((String) getAttrVal("Code_emp_end"));
	}
	/**
	 * 出院操作人编码
	 * @param Code_emp_end
	 */
	public void setCode_emp_end(String Code_emp_end) {
		setAttrVal("Code_emp_end", Code_emp_end);
	}
	/**
	 * 出院操作人名称
	 * @return String
	 */
	public String getName_emp_end() {
		return ((String) getAttrVal("Name_emp_end"));
	}
	/**
	 * 出院操作人名称
	 * @param Name_emp_end
	 */
	public void setName_emp_end(String Name_emp_end) {
		setAttrVal("Name_emp_end", Name_emp_end);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后更新人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后更新人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后更新时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后更新时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 删除标识
	 * @return String
	 */
	public String getFg_del() {
		return ((String) getAttrVal("Fg_del"));
	}
	/**
	 * 删除标识
	 * @param Fg_del
	 */
	public void setFg_del(String Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
}