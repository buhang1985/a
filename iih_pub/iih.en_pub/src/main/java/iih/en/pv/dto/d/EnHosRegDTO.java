package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记DTO DTO数据 
 * 
 */
public class EnHosRegDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 入院方式
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}
	/**
	 * 入院方式
	 * @param Id_referalsrc
	 */
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	/**
	 * 来院方式编码
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 来院方式编码
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}
	/**
	 * 病区
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 门诊主要诊断_西药
	 * @return String
	 */
	public String getId_diag() {
		return ((String) getAttrVal("Id_diag"));
	}
	/**
	 * 门诊主要诊断_西药
	 * @param Id_diag
	 */
	public void setId_diag(String Id_diag) {
		setAttrVal("Id_diag", Id_diag);
	}
	/**
	 * 就诊医保计划主键_主医保
	 * @return String
	 */
	public String getId_enthp_prim() {
		return ((String) getAttrVal("Id_enthp_prim"));
	}
	/**
	 * 就诊医保计划主键_主医保
	 * @param Id_enthp_prim
	 */
	public void setId_enthp_prim(String Id_enthp_prim) {
		setAttrVal("Id_enthp_prim", Id_enthp_prim);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getPrim_cplan() {
		return ((String) getAttrVal("Prim_cplan"));
	}
	/**
	 * 主医保计划
	 * @param Prim_cplan
	 */
	public void setPrim_cplan(String Prim_cplan) {
		setAttrVal("Prim_cplan", Prim_cplan);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 就诊医保计划主键_辅助医保
	 * @return String
	 */
	public String getId_enthp_auxi() {
		return ((String) getAttrVal("Id_enthp_auxi"));
	}
	/**
	 * 就诊医保计划主键_辅助医保
	 * @param Id_enthp_auxi
	 */
	public void setId_enthp_auxi(String Id_enthp_auxi) {
		setAttrVal("Id_enthp_auxi", Id_enthp_auxi);
	}
	/**
	 * 辅医保计划
	 * @return String
	 */
	public String getAuxi_cplan() {
		return ((String) getAttrVal("Auxi_cplan"));
	}
	/**
	 * 辅医保计划
	 * @param Auxi_cplan
	 */
	public void setAuxi_cplan(String Auxi_cplan) {
		setAttrVal("Auxi_cplan", Auxi_cplan);
	}
	/**
	 * 辅医保号
	 * @return String
	 */
	public String getCode_hp2() {
		return ((String) getAttrVal("Code_hp2"));
	}
	/**
	 * 辅医保号
	 * @param Code_hp2
	 */
	public void setCode_hp2(String Code_hp2) {
		setAttrVal("Code_hp2", Code_hp2);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getPri_name() {
		return ((String) getAttrVal("Pri_name"));
	}
	/**
	 * 价格分类名称
	 * @param Pri_name
	 */
	public void setPri_name(String Pri_name) {
		setAttrVal("Pri_name", Pri_name);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 信用分类
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 信用分类名称
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 信用分类名称
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_paticate() {
		return ((String) getAttrVal("Id_paticate"));
	}
	/**
	 * 患者分类
	 * @param Id_paticate
	 */
	public void setId_paticate(String Id_paticate) {
		setAttrVal("Id_paticate", Id_paticate);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_paticate() {
		return ((String) getAttrVal("Name_paticate"));
	}
	/**
	 * 患者分类名称
	 * @param Name_paticate
	 */
	public void setName_paticate(String Name_paticate) {
		setAttrVal("Name_paticate", Name_paticate);
	}
	/**
	 * 患者状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 患者状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	 * 入院通知单
	 * @return String
	 */
	public String getId_ent_ipnt() {
		return ((String) getAttrVal("Id_ent_ipnt"));
	}
	/**
	 * 入院通知单
	 * @param Id_ent_ipnt
	 */
	public void setId_ent_ipnt(String Id_ent_ipnt) {
		setAttrVal("Id_ent_ipnt", Id_ent_ipnt);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDesc_diag() {
		return ((String) getAttrVal("Desc_diag"));
	}
	/**
	 * 诊断描述
	 * @param Desc_diag
	 */
	public void setDesc_diag(String Desc_diag) {
		setAttrVal("Desc_diag", Desc_diag);
	}
	/**
	 * 患者联系人ID
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}
	/**
	 * 患者联系人ID
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 患者联系人参照
	 * @return String
	 */
	public String getName_patcontref() {
		return ((String) getAttrVal("Name_patcontref"));
	}
	/**
	 * 患者联系人参照
	 * @param Name_patcontref
	 */
	public void setName_patcontref(String Name_patcontref) {
		setAttrVal("Name_patcontref", Name_patcontref);
	}
	/**
	 * 联系人类型名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型sd
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型sd
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人名称
	 * @return String
	 */
	public String getCont_name() {
		return ((String) getAttrVal("Cont_name"));
	}
	/**
	 * 联系人名称
	 * @param Cont_name
	 */
	public void setCont_name(String Cont_name) {
		setAttrVal("Cont_name", Cont_name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getContaddr() {
		return ((String) getAttrVal("Contaddr"));
	}
	/**
	 * 联系人地址
	 * @param Contaddr
	 */
	public void setContaddr(String Contaddr) {
		setAttrVal("Contaddr", Contaddr);
	}
	/**
	 * 挂号员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 挂号员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 主医保计划名称
	 * @return String
	 */
	public String getPrim_name() {
		return ((String) getAttrVal("Prim_name"));
	}
	/**
	 * 主医保计划名称
	 * @param Prim_name
	 */
	public void setPrim_name(String Prim_name) {
		setAttrVal("Prim_name", Prim_name);
	}
	/**
	 * 辅医保计划名称
	 * @return String
	 */
	public String getAuxi_name() {
		return ((String) getAttrVal("Auxi_name"));
	}
	/**
	 * 辅医保计划名称
	 * @param Auxi_name
	 */
	public void setAuxi_name(String Auxi_name) {
		setAttrVal("Auxi_name", Auxi_name);
	}
	/**
	 * 床位名称
	 * @return String
	 */
	public String getBedname() {
		return ((String) getAttrVal("Bedname"));
	}
	/**
	 * 床位名称
	 * @param Bedname
	 */
	public void setBedname(String Bedname) {
		setAttrVal("Bedname", Bedname);
	}
	/**
	 * 住院来院方式
	 * @return String
	 */
	public String getReferalsrc_name() {
		return ((String) getAttrVal("Referalsrc_name"));
	}
	/**
	 * 住院来院方式
	 * @param Referalsrc_name
	 */
	public void setReferalsrc_name(String Referalsrc_name) {
		setAttrVal("Referalsrc_name", Referalsrc_name);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getPhy_name() {
		return ((String) getAttrVal("Phy_name"));
	}
	/**
	 * 科室名称
	 * @param Phy_name
	 */
	public void setPhy_name(String Phy_name) {
		setAttrVal("Phy_name", Phy_name);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getNur_name() {
		return ((String) getAttrVal("Nur_name"));
	}
	/**
	 * 病区名称
	 * @param Nur_name
	 */
	public void setNur_name(String Nur_name) {
		setAttrVal("Nur_name", Nur_name);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDia_name() {
		return ((String) getAttrVal("Dia_name"));
	}
	/**
	 * 诊断名称
	 * @param Dia_name
	 */
	public void setDia_name(String Dia_name) {
		setAttrVal("Dia_name", Dia_name);
	}
	/**
	 * 入院病情ID
	 * @return String
	 */
	public String getId_level_diseadm() {
		return ((String) getAttrVal("Id_level_diseadm"));
	}
	/**
	 * 入院病情ID
	 * @param Id_level_diseadm
	 */
	public void setId_level_diseadm(String Id_level_diseadm) {
		setAttrVal("Id_level_diseadm", Id_level_diseadm);
	}
	/**
	 * 入院病情sd
	 * @return String
	 */
	public String getSd_level_diseadm() {
		return ((String) getAttrVal("Sd_level_diseadm"));
	}
	/**
	 * 入院病情sd
	 * @param Sd_level_diseadm
	 */
	public void setSd_level_diseadm(String Sd_level_diseadm) {
		setAttrVal("Sd_level_diseadm", Sd_level_diseadm);
	}
	/**
	 * 入院病情name
	 * @return String
	 */
	public String getName_level_diseadm() {
		return ((String) getAttrVal("Name_level_diseadm"));
	}
	/**
	 * 入院病情name
	 * @param Name_level_diseadm
	 */
	public void setName_level_diseadm(String Name_level_diseadm) {
		setAttrVal("Name_level_diseadm", Name_level_diseadm);
	}
	/**
	 * 入院申请状态
	 * @return String
	 */
	public String getApt_status() {
		return ((String) getAttrVal("Apt_status"));
	}
	/**
	 * 入院申请状态
	 * @param Apt_status
	 */
	public void setApt_status(String Apt_status) {
		setAttrVal("Apt_status", Apt_status);
	}
	/**
	 * 预约标识
	 * @return String
	 */
	public String getFg_appt() {
		return ((String) getAttrVal("Fg_appt"));
	}
	/**
	 * 预约标识
	 * @param Fg_appt
	 */
	public void setFg_appt(String Fg_appt) {
		setAttrVal("Fg_appt", Fg_appt);
	}
	/**
	 * 入院次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 入院次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 是否有入院通知单
	 * @return FBoolean
	 */
	public FBoolean getFg_aptip() {
		return ((FBoolean) getAttrVal("Fg_aptip"));
	}
	/**
	 * 是否有入院通知单
	 * @param Fg_aptip
	 */
	public void setFg_aptip(FBoolean Fg_aptip) {
		setAttrVal("Fg_aptip", Fg_aptip);
	}
	/**
	 * 床位所属病区
	 * @return String
	 */
	public String getId_nur_bed() {
		return ((String) getAttrVal("Id_nur_bed"));
	}
	/**
	 * 床位所属病区
	 * @param Id_nur_bed
	 */
	public void setId_nur_bed(String Id_nur_bed) {
		setAttrVal("Id_nur_bed", Id_nur_bed);
	}
	/**
	 * 是否在院
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 是否在院
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 在院状态
	 * @return String
	 */
	public String getShow_ipstatus() {
		return ((String) getAttrVal("Show_ipstatus"));
	}
	/**
	 * 在院状态
	 * @param Show_ipstatus
	 */
	public void setShow_ipstatus(String Show_ipstatus) {
		setAttrVal("Show_ipstatus", Show_ipstatus);
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
	 * 诊断sd
	 * @return String
	 */
	public String getSd_diag() {
		return ((String) getAttrVal("Sd_diag"));
	}
	/**
	 * 诊断sd
	 * @param Sd_diag
	 */
	public void setSd_diag(String Sd_diag) {
		setAttrVal("Sd_diag", Sd_diag);
	}
	/**
	 * 申请单预交金额度
	 * @return FDouble
	 */
	public FDouble getAmt_deposit() {
		return ((FDouble) getAttrVal("Amt_deposit"));
	}
	/**
	 * 申请单预交金额度
	 * @param Amt_deposit
	 */
	public void setAmt_deposit(FDouble Amt_deposit) {
		setAttrVal("Amt_deposit", Amt_deposit);
	}
	/**
	 * 主医保险种编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}
	/**
	 * 主医保险种编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 主医保身份编码
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 主医保身份编码
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 主医保区域
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}
	/**
	 * 主医保区域
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}
	/**
	 * 医疗类别
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 医疗类别id
	 * @return String
	 */
	public String getId_hpmedkind() {
		return ((String) getAttrVal("Id_hpmedkind"));
	}
	/**
	 * 医疗类别id
	 * @param Id_hpmedkind
	 */
	public void setId_hpmedkind(String Id_hpmedkind) {
		setAttrVal("Id_hpmedkind", Id_hpmedkind);
	}
	/**
	 * 医疗类别名称
	 * @return String
	 */
	public String getName_hpmedkind() {
		return ((String) getAttrVal("Name_hpmedkind"));
	}
	/**
	 * 医疗类别名称
	 * @param Name_hpmedkind
	 */
	public void setName_hpmedkind(String Name_hpmedkind) {
		setAttrVal("Name_hpmedkind", Name_hpmedkind);
	}
	/**
	 * 医保卡账户余额
	 * @return FDouble
	 */
	public FDouble getAccamount() {
		return ((FDouble) getAttrVal("Accamount"));
	}
	/**
	 * 医保卡账户余额
	 * @param Accamount
	 */
	public void setAccamount(FDouble Accamount) {
		setAttrVal("Accamount", Accamount);
	}
	/**
	 * 入院医生id
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}
	/**
	 * 入院医生id
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 入院医生姓名
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}
	/**
	 * 入院医生姓名
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 入院医生code
	 * @return String
	 */
	public String getCode_emp_phy_op() {
		return ((String) getAttrVal("Code_emp_phy_op"));
	}
	/**
	 * 入院医生code
	 * @param Code_emp_phy_op
	 */
	public void setCode_emp_phy_op(String Code_emp_phy_op) {
		setAttrVal("Code_emp_phy_op", Code_emp_phy_op);
	}
	/**
	 * 床位性别编码
	 * @return String
	 */
	public String getSd_bedsex() {
		return ((String) getAttrVal("Sd_bedsex"));
	}
	/**
	 * 床位性别编码
	 * @param Sd_bedsex
	 */
	public void setSd_bedsex(String Sd_bedsex) {
		setAttrVal("Sd_bedsex", Sd_bedsex);
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
	 * 床位编码
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床位编码
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 医保产品编码
	 * @return String
	 */
	public String getHpcode() {
		return ((String) getAttrVal("Hpcode"));
	}
	/**
	 * 医保产品编码
	 * @param Hpcode
	 */
	public void setHpcode(String Hpcode) {
		setAttrVal("Hpcode", Hpcode);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 责任医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 责任医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任医生编码
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}
	/**
	 * 责任医生编码
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 责任医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 基金支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fundpay() {
		return ((FBoolean) getAttrVal("Fg_fundpay"));
	}
	/**
	 * 基金支付标志
	 * @param Fg_fundpay
	 */
	public void setFg_fundpay(FBoolean Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	/**
	 * 特病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}
	/**
	 * 特病标识
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 持卡标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}
	/**
	 * 持卡标识
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 生育证号
	 * @return String
	 */
	public String getBirthcerticode() {
		return ((String) getAttrVal("Birthcerticode"));
	}
	/**
	 * 生育证号
	 * @param Birthcerticode
	 */
	public void setBirthcerticode(String Birthcerticode) {
		setAttrVal("Birthcerticode", Birthcerticode);
	}
	/**
	 * 男职工配偶身份证号
	 * @return String
	 */
	public String getMalewife_idcard() {
		return ((String) getAttrVal("Malewife_idcard"));
	}
	/**
	 * 男职工配偶身份证号
	 * @param Malewife_idcard
	 */
	public void setMalewife_idcard(String Malewife_idcard) {
		setAttrVal("Malewife_idcard", Malewife_idcard);
	}
	/**
	 * 男职工配偶姓名
	 * @return String
	 */
	public String getMalewife_name() {
		return ((String) getAttrVal("Malewife_name"));
	}
	/**
	 * 男职工配偶姓名
	 * @param Malewife_name
	 */
	public void setMalewife_name(String Malewife_name) {
		setAttrVal("Malewife_name", Malewife_name);
	}
	/**
	 * 生育手术类型
	 * @return String
	 */
	public String getBearoper_type() {
		return ((String) getAttrVal("Bearoper_type"));
	}
	/**
	 * 生育手术类型
	 * @param Bearoper_type
	 */
	public void setBearoper_type(String Bearoper_type) {
		setAttrVal("Bearoper_type", Bearoper_type);
	}
	/**
	 * vip标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * vip标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 合同单位id
	 * @return String
	 */
	public String getId_cust_cmpy() {
		return ((String) getAttrVal("Id_cust_cmpy"));
	}
	/**
	 * 合同单位id
	 * @param Id_cust_cmpy
	 */
	public void setId_cust_cmpy(String Id_cust_cmpy) {
		setAttrVal("Id_cust_cmpy", Id_cust_cmpy);
	}
	/**
	 * 合同单位
	 * @return String
	 */
	public String getName_cust_cmpy() {
		return ((String) getAttrVal("Name_cust_cmpy"));
	}
	/**
	 * 合同单位
	 * @param Name_cust_cmpy
	 */
	public void setName_cust_cmpy(String Name_cust_cmpy) {
		setAttrVal("Name_cust_cmpy", Name_cust_cmpy);
	}
	/**
	 * 通知单预约床位id
	 * @return String
	 */
	public String getId_bed_sc() {
		return ((String) getAttrVal("Id_bed_sc"));
	}
	/**
	 * 通知单预约床位id
	 * @param Id_bed_sc
	 */
	public void setId_bed_sc(String Id_bed_sc) {
		setAttrVal("Id_bed_sc", Id_bed_sc);
	}
	/**
	 * 入院申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert_sc() {
		return ((FDateTime) getAttrVal("Dt_insert_sc"));
	}
	/**
	 * 入院申请时间
	 * @param Dt_insert_sc
	 */
	public void setDt_insert_sc(FDateTime Dt_insert_sc) {
		setAttrVal("Dt_insert_sc", Dt_insert_sc);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 门诊就诊id
	 * @return String
	 */
	public String getId_ent_op() {
		return ((String) getAttrVal("Id_ent_op"));
	}
	/**
	 * 门诊就诊id
	 * @param Id_ent_op
	 */
	public void setId_ent_op(String Id_ent_op) {
		setAttrVal("Id_ent_op", Id_ent_op);
	}
	/**
	 * 贫困标志
	 * @return FBoolean
	 */
	public FBoolean getFg_poor() {
		return ((FBoolean) getAttrVal("Fg_poor"));
	}
	/**
	 * 贫困标志
	 * @param Fg_poor
	 */
	public void setFg_poor(FBoolean Fg_poor) {
		setAttrVal("Fg_poor", Fg_poor);
	}
	/**
	 * 低保标志
	 * @return FBoolean
	 */
	public FBoolean getFg_minliving() {
		return ((FBoolean) getAttrVal("Fg_minliving"));
	}
	/**
	 * 低保标志
	 * @param Fg_minliving
	 */
	public void setFg_minliving(FBoolean Fg_minliving) {
		setAttrVal("Fg_minliving", Fg_minliving);
	}
	/**
	 * 五保标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fiveguar() {
		return ((FBoolean) getAttrVal("Fg_fiveguar"));
	}
	/**
	 * 五保标志
	 * @param Fg_fiveguar
	 */
	public void setFg_fiveguar(FBoolean Fg_fiveguar) {
		setAttrVal("Fg_fiveguar", Fg_fiveguar);
	}
	/**
	 * 就诊医保信息
	 * @return FArrayList
	 */
	public FArrayList getEnhpcard_flist() {
		return ((FArrayList) getAttrVal("Enhpcard_flist"));
	}
	/**
	 * 就诊医保信息
	 * @param Enhpcard_flist
	 */
	public void setEnhpcard_flist(FArrayList Enhpcard_flist) {
		setAttrVal("Enhpcard_flist", Enhpcard_flist);
	}
	/**
	 * 参保地市编码
	 * @return String
	 */
	public String getArea_insuredcode() {
		return ((String) getAttrVal("Area_insuredcode"));
	}
	/**
	 * 参保地市编码
	 * @param Area_insuredcode
	 */
	public void setArea_insuredcode(String Area_insuredcode) {
		setAttrVal("Area_insuredcode", Area_insuredcode);
	}
	/**
	 * 参保机构名称
	 * @return String
	 */
	public String getName_hp_org() {
		return ((String) getAttrVal("Name_hp_org"));
	}
	/**
	 * 参保机构名称
	 * @param Name_hp_org
	 */
	public void setName_hp_org(String Name_hp_org) {
		setAttrVal("Name_hp_org", Name_hp_org);
	}
	/**
	 * 拓展字段
	 * @return FArrayList
	 */
	public FArrayList getOthers() {
		return ((FArrayList) getAttrVal("Others"));
	}
	/**
	 * 拓展字段
	 * @param Others
	 */
	public void setOthers(FArrayList Others) {
		setAttrVal("Others", Others);
	}
	/**
	 * 卡识别码
	 * @return String
	 */
	public String getSocialcardid() {
		return ((String) getAttrVal("Socialcardid"));
	}
	/**
	 * 卡识别码
	 * @param Socialcardid
	 */
	public void setSocialcardid(String Socialcardid) {
		setAttrVal("Socialcardid", Socialcardid);
	}
	/**
	 * 特定类型id
	 * @return String
	 */
	public String getId_ip_spec() {
		return ((String) getAttrVal("Id_ip_spec"));
	}
	/**
	 * 特定类型id
	 * @param Id_ip_spec
	 */
	public void setId_ip_spec(String Id_ip_spec) {
		setAttrVal("Id_ip_spec", Id_ip_spec);
	}
	/**
	 * 特定类型编码
	 * @return String
	 */
	public String getSd_ip_spec() {
		return ((String) getAttrVal("Sd_ip_spec"));
	}
	/**
	 * 特定类型编码
	 * @param Sd_ip_spec
	 */
	public void setSd_ip_spec(String Sd_ip_spec) {
		setAttrVal("Sd_ip_spec", Sd_ip_spec);
	}
	/**
	 * 特定类型名称
	 * @return String
	 */
	public String getName_ip_spec() {
		return ((String) getAttrVal("Name_ip_spec"));
	}
	/**
	 * 特定类型名称
	 * @param Name_ip_spec
	 */
	public void setName_ip_spec(String Name_ip_spec) {
		setAttrVal("Name_ip_spec", Name_ip_spec);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 患者预住院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}
	/**
	 * 患者预住院标识
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
	}
	/**
	 * 目标病区id
	 * @return String
	 */
	public String getId_dep_nur_target() {
		return ((String) getAttrVal("Id_dep_nur_target"));
	}
	/**
	 * 目标病区id
	 * @param Id_dep_nur_target
	 */
	public void setId_dep_nur_target(String Id_dep_nur_target) {
		setAttrVal("Id_dep_nur_target", Id_dep_nur_target);
	}
	/**
	 * 目标病区名称
	 * @return String
	 */
	public String getName_dep_nur_target() {
		return ((String) getAttrVal("Name_dep_nur_target"));
	}
	/**
	 * 目标病区名称
	 * @param Name_dep_nur_target
	 */
	public void setName_dep_nur_target(String Name_dep_nur_target) {
		setAttrVal("Name_dep_nur_target", Name_dep_nur_target);
	}
	/**
	 * 目标科室id
	 * @return String
	 */
	public String getId_dep_phy_target() {
		return ((String) getAttrVal("Id_dep_phy_target"));
	}
	/**
	 * 目标科室id
	 * @param Id_dep_phy_target
	 */
	public void setId_dep_phy_target(String Id_dep_phy_target) {
		setAttrVal("Id_dep_phy_target", Id_dep_phy_target);
	}
	/**
	 * 目标科室名称
	 * @return String
	 */
	public String getName_dep_phy_target() {
		return ((String) getAttrVal("Name_dep_phy_target"));
	}
	/**
	 * 目标科室名称
	 * @param Name_dep_phy_target
	 */
	public void setName_dep_phy_target(String Name_dep_phy_target) {
		setAttrVal("Name_dep_phy_target", Name_dep_phy_target);
	}
	/**
	 * 介绍人
	 * @return String
	 */
	public String getName_pe_intr() {
		return ((String) getAttrVal("Name_pe_intr"));
	}
	/**
	 * 介绍人
	 * @param Name_pe_intr
	 */
	public void setName_pe_intr(String Name_pe_intr) {
		setAttrVal("Name_pe_intr", Name_pe_intr);
	}
}