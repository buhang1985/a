package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import java.math.BigDecimal;

/**
 * 住院属性 DO数据 
 * 
 */
public class InpatientDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院属性主键
	public static final String ID_INPATIENT= "Id_inpatient";
	//患者就诊主键
	public static final String ID_ENT= "Id_ent";
	//住院档案号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//就诊状态
	public static final String SD_STATUS= "Sd_status";
	//入院科室
	public static final String ID_DEP_PHYADM= "Id_dep_phyadm";
	//入院病区
	public static final String ID_DEP_NURADM= "Id_dep_nuradm";
	//病床
	public static final String ID_BED= "Id_bed";
	//床号
	public static final String NAME_BED= "Name_bed";
	//是否手术标志
	public static final String FG_SURG= "Fg_surg";
	//护理等级
	public static final String ID_LEVEL_NUR= "Id_level_nur";
	//护理等级编码
	public static final String SD_LEVEL_NUR= "Sd_level_nur";
	//病情等级
	public static final String ID_LEVEL_DISE= "Id_level_dise";
	//病情等级编码
	public static final String SD_LEVEL_DISE= "Sd_level_dise";
	//营养等级
	public static final String ID_LEVEL_NUTR= "Id_level_nutr";
	//营养等级编码
	public static final String SD_LEVEL_NUTR= "Sd_level_nutr";
	//新生儿标志
	public static final String FG_NEWBORN= "Fg_newborn";
	//新生儿数量
	public static final String NUM_NEWBORN= "Num_newborn";
	//病情转归
	public static final String ID_OUTCOMES= "Id_outcomes";
	//病情转归编码
	public static final String SD_OUTCOMES= "Sd_outcomes";
	//来院方式
	public static final String ID_REFERALSRC= "Id_referalsrc";
	//来院方式编码
	public static final String SD_REFERALSRC= "Sd_referalsrc";
	//入院病情编码
	public static final String SD_LEVEL_DISEADM= "Sd_level_diseadm";
	//入院病情id
	public static final String ID_LEVEL_DISEADM= "Id_level_diseadm";
	//主要联系人
	public static final String ID_PATCONT= "Id_patcont";
	//主要联系人姓名
	public static final String CONT_NAME= "Cont_name";
	//主要联系人电话
	public static final String CONT_TEL= "Cont_tel";
	//离院转归
	public static final String ID_GOWHERE= "Id_gowhere";
	//离院转归编码
	public static final String SD_GOWHERE= "Sd_gowhere";
	//出院科室
	public static final String ID_DEP_PHYDISC= "Id_dep_phydisc";
	//出院病区
	public static final String ID_DEP_NURDISC= "Id_dep_nurdisc";
	//病案转归标志
	public static final String FG_DOC_COMMIT= "Fg_doc_commit";
	//病案转归日期
	public static final String DT_DOC_COMMIT= "Dt_doc_commit";
	//病案转归状态
	public static final String ID_DOC_STATUS= "Id_doc_status";
	//病案转归状态编码
	public static final String SD_DOC_STATUS= "Sd_doc_status";
	//门诊主要诊断
	public static final String ID_DIAG_OP= "Id_diag_op";
	//门诊主要诊断描述
	public static final String DESC_DIAG_OP= "Desc_diag_op";
	//住院次数
	public static final String TIMES_IP= "Times_ip";
	//死亡时间
	public static final String DT_DEATH= "Dt_death";
	//是否在临床路径中
	public static final String FG_INCP= "Fg_incp";
	//临床路径状态
	public static final String EU_INCP= "Eu_incp";
	//出院操作人
	public static final String ID_EMP_DISC= "Id_emp_disc";
	//出院操作时间
	public static final String DT_DISC= "Dt_disc";
	//打印次数
	public static final String TIMES_PRINT= "Times_print";
	//付款方式（首页）
	public static final String SD_PAY_MOTHOD= "Sd_pay_mothod";
	//入院医生
	public static final String ID_EMP_OPAPPLY= "Id_emp_opapply";
	//开通手机app标识
	public static final String FG_MOBAPP= "Fg_mobapp";
	//手机app电话号
	public static final String TELNO_MOBAPP= "Telno_mobapp";
	//VIP标志
	public static final String FG_VIP= "Fg_vip";
	//体检标志
	public static final String FG_PE= "Fg_pe";
	//体检身份类型
	public static final String SD_PE_PSNTP= "Sd_pe_psntp";
	//体检介绍人
	public static final String NAME_PE_INTR= "Name_pe_intr";
	//是否是费用召回
	public static final String FG_BLRECALL= "Fg_blrecall";
	//特定类型id
	public static final String ID_IP_SPEC= "Id_ip_spec";
	//特定类型编码
	public static final String SD_IP_SPEC= "Sd_ip_spec";
	//上次踢出院时间
	public static final String DT_END_LAST= "Dt_end_last";
	//预住院标志
	public static final String FG_IPPRE= "Fg_ippre";
	//编码
	public static final String SD_DEP_PHY= "Sd_dep_phy";
	//名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//编码
	public static final String SD_DEP_NUR= "Sd_dep_nur";
	//名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//名称
	public static final String NAME_LEVEL_NUR= "Name_level_nur";
	//名称
	public static final String NAME_LEVEL_DISE= "Name_level_dise";
	//名称
	public static final String NAME_LEVEL_NUTR= "Name_level_nutr";
	//名称
	public static final String NAME_REFERALSRC= "Name_referalsrc";
	//名称病情等级
	public static final String NAME_LEVEL_DISEADM= "Name_level_diseadm";
	//诊断编码
	public static final String SD_DIAG_OP= "Sd_diag_op";
	//诊断名称
	public static final String NAME_DIAG_OP= "Name_diag_op";
	//名称
	public static final String NAME_PAY_MOTHOD= "Name_pay_mothod";
	//姓名
	public static final String NAME_EMP_PHY_OP= "Name_emp_phy_op";
	//人员编码
	public static final String CODE_EMP_PHY_OP= "Code_emp_phy_op";
	//名称
	public static final String NAME_PE_PSNTP= "Name_pe_psntp";
	//名称
	public static final String NAME_IP_SPEC= "Name_ip_spec";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院属性主键
	 * @return String
	 */
	public String getId_inpatient() {
		return ((String) getAttrVal("Id_inpatient"));
	}	
	/**
	 * 住院属性主键
	 * @param Id_inpatient
	 */
	public void setId_inpatient(String Id_inpatient) {
		setAttrVal("Id_inpatient", Id_inpatient);
	}
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院档案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院档案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	 * 入院病区
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}	
	/**
	 * 入院病区
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 病床
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 病床
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
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
	 * 是否手术标志
	 * @return FBoolean
	 */
	public FBoolean getFg_surg() {
		return ((FBoolean) getAttrVal("Fg_surg"));
	}	
	/**
	 * 是否手术标志
	 * @param Fg_surg
	 */
	public void setFg_surg(FBoolean Fg_surg) {
		setAttrVal("Fg_surg", Fg_surg);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}	
	/**
	 * 护理等级
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
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
	 * 病情等级
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}	
	/**
	 * 病情等级
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
	 * 营养等级
	 * @return String
	 */
	public String getId_level_nutr() {
		return ((String) getAttrVal("Id_level_nutr"));
	}	
	/**
	 * 营养等级
	 * @param Id_level_nutr
	 */
	public void setId_level_nutr(String Id_level_nutr) {
		setAttrVal("Id_level_nutr", Id_level_nutr);
	}
	/**
	 * 营养等级编码
	 * @return String
	 */
	public String getSd_level_nutr() {
		return ((String) getAttrVal("Sd_level_nutr"));
	}	
	/**
	 * 营养等级编码
	 * @param Sd_level_nutr
	 */
	public void setSd_level_nutr(String Sd_level_nutr) {
		setAttrVal("Sd_level_nutr", Sd_level_nutr);
	}
	/**
	 * 新生儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}	
	/**
	 * 新生儿标志
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 新生儿数量
	 * @return Integer
	 */
	public Integer getNum_newborn() {
		return ((Integer) getAttrVal("Num_newborn"));
	}	
	/**
	 * 新生儿数量
	 * @param Num_newborn
	 */
	public void setNum_newborn(Integer Num_newborn) {
		setAttrVal("Num_newborn", Num_newborn);
	}
	/**
	 * 病情转归
	 * @return String
	 */
	public String getId_outcomes() {
		return ((String) getAttrVal("Id_outcomes"));
	}	
	/**
	 * 病情转归
	 * @param Id_outcomes
	 */
	public void setId_outcomes(String Id_outcomes) {
		setAttrVal("Id_outcomes", Id_outcomes);
	}
	/**
	 * 病情转归编码
	 * @return String
	 */
	public String getSd_outcomes() {
		return ((String) getAttrVal("Sd_outcomes"));
	}	
	/**
	 * 病情转归编码
	 * @param Sd_outcomes
	 */
	public void setSd_outcomes(String Sd_outcomes) {
		setAttrVal("Sd_outcomes", Sd_outcomes);
	}
	/**
	 * 来院方式
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}	
	/**
	 * 来院方式
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
	 * 入院病情编码
	 * @return String
	 */
	public String getSd_level_diseadm() {
		return ((String) getAttrVal("Sd_level_diseadm"));
	}	
	/**
	 * 入院病情编码
	 * @param Sd_level_diseadm
	 */
	public void setSd_level_diseadm(String Sd_level_diseadm) {
		setAttrVal("Sd_level_diseadm", Sd_level_diseadm);
	}
	/**
	 * 入院病情id
	 * @return String
	 */
	public String getId_level_diseadm() {
		return ((String) getAttrVal("Id_level_diseadm"));
	}	
	/**
	 * 入院病情id
	 * @param Id_level_diseadm
	 */
	public void setId_level_diseadm(String Id_level_diseadm) {
		setAttrVal("Id_level_diseadm", Id_level_diseadm);
	}
	/**
	 * 主要联系人
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}	
	/**
	 * 主要联系人
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 主要联系人姓名
	 * @return String
	 */
	public String getCont_name() {
		return ((String) getAttrVal("Cont_name"));
	}	
	/**
	 * 主要联系人姓名
	 * @param Cont_name
	 */
	public void setCont_name(String Cont_name) {
		setAttrVal("Cont_name", Cont_name);
	}
	/**
	 * 主要联系人电话
	 * @return String
	 */
	public String getCont_tel() {
		return ((String) getAttrVal("Cont_tel"));
	}	
	/**
	 * 主要联系人电话
	 * @param Cont_tel
	 */
	public void setCont_tel(String Cont_tel) {
		setAttrVal("Cont_tel", Cont_tel);
	}
	/**
	 * 离院转归
	 * @return String
	 */
	public String getId_gowhere() {
		return ((String) getAttrVal("Id_gowhere"));
	}	
	/**
	 * 离院转归
	 * @param Id_gowhere
	 */
	public void setId_gowhere(String Id_gowhere) {
		setAttrVal("Id_gowhere", Id_gowhere);
	}
	/**
	 * 离院转归编码
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}	
	/**
	 * 离院转归编码
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}	
	/**
	 * 出院科室
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getId_dep_nurdisc() {
		return ((String) getAttrVal("Id_dep_nurdisc"));
	}	
	/**
	 * 出院病区
	 * @param Id_dep_nurdisc
	 */
	public void setId_dep_nurdisc(String Id_dep_nurdisc) {
		setAttrVal("Id_dep_nurdisc", Id_dep_nurdisc);
	}
	/**
	 * 病案转归标志
	 * @return FBoolean
	 */
	public FBoolean getFg_doc_commit() {
		return ((FBoolean) getAttrVal("Fg_doc_commit"));
	}	
	/**
	 * 病案转归标志
	 * @param Fg_doc_commit
	 */
	public void setFg_doc_commit(FBoolean Fg_doc_commit) {
		setAttrVal("Fg_doc_commit", Fg_doc_commit);
	}
	/**
	 * 病案转归日期
	 * @return FDateTime
	 */
	public FDateTime getDt_doc_commit() {
		return ((FDateTime) getAttrVal("Dt_doc_commit"));
	}	
	/**
	 * 病案转归日期
	 * @param Dt_doc_commit
	 */
	public void setDt_doc_commit(FDateTime Dt_doc_commit) {
		setAttrVal("Dt_doc_commit", Dt_doc_commit);
	}
	/**
	 * 病案转归状态
	 * @return String
	 */
	public String getId_doc_status() {
		return ((String) getAttrVal("Id_doc_status"));
	}	
	/**
	 * 病案转归状态
	 * @param Id_doc_status
	 */
	public void setId_doc_status(String Id_doc_status) {
		setAttrVal("Id_doc_status", Id_doc_status);
	}
	/**
	 * 病案转归状态编码
	 * @return String
	 */
	public String getSd_doc_status() {
		return ((String) getAttrVal("Sd_doc_status"));
	}	
	/**
	 * 病案转归状态编码
	 * @param Sd_doc_status
	 */
	public void setSd_doc_status(String Sd_doc_status) {
		setAttrVal("Sd_doc_status", Sd_doc_status);
	}
	/**
	 * 门诊主要诊断
	 * @return String
	 */
	public String getId_diag_op() {
		return ((String) getAttrVal("Id_diag_op"));
	}	
	/**
	 * 门诊主要诊断
	 * @param Id_diag_op
	 */
	public void setId_diag_op(String Id_diag_op) {
		setAttrVal("Id_diag_op", Id_diag_op);
	}
	/**
	 * 门诊主要诊断描述
	 * @return String
	 */
	public String getDesc_diag_op() {
		return ((String) getAttrVal("Desc_diag_op"));
	}	
	/**
	 * 门诊主要诊断描述
	 * @param Desc_diag_op
	 */
	public void setDesc_diag_op(String Desc_diag_op) {
		setAttrVal("Desc_diag_op", Desc_diag_op);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}	
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
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
	 * 是否在临床路径中
	 * @return FBoolean
	 */
	public FBoolean getFg_incp() {
		return ((FBoolean) getAttrVal("Fg_incp"));
	}	
	/**
	 * 是否在临床路径中
	 * @param Fg_incp
	 */
	public void setFg_incp(FBoolean Fg_incp) {
		setAttrVal("Fg_incp", Fg_incp);
	}
	/**
	 * 临床路径状态
	 * @return String
	 */
	public String getEu_incp() {
		return ((String) getAttrVal("Eu_incp"));
	}	
	/**
	 * 临床路径状态
	 * @param Eu_incp
	 */
	public void setEu_incp(String Eu_incp) {
		setAttrVal("Eu_incp", Eu_incp);
	}
	/**
	 * 出院操作人
	 * @return String
	 */
	public String getId_emp_disc() {
		return ((String) getAttrVal("Id_emp_disc"));
	}	
	/**
	 * 出院操作人
	 * @param Id_emp_disc
	 */
	public void setId_emp_disc(String Id_emp_disc) {
		setAttrVal("Id_emp_disc", Id_emp_disc);
	}
	/**
	 * 出院操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disc() {
		return ((FDateTime) getAttrVal("Dt_disc"));
	}	
	/**
	 * 出院操作时间
	 * @param Dt_disc
	 */
	public void setDt_disc(FDateTime Dt_disc) {
		setAttrVal("Dt_disc", Dt_disc);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getTimes_print() {
		return ((Integer) getAttrVal("Times_print"));
	}	
	/**
	 * 打印次数
	 * @param Times_print
	 */
	public void setTimes_print(Integer Times_print) {
		setAttrVal("Times_print", Times_print);
	}
	/**
	 * 付款方式（首页）
	 * @return String
	 */
	public String getSd_pay_mothod() {
		return ((String) getAttrVal("Sd_pay_mothod"));
	}	
	/**
	 * 付款方式（首页）
	 * @param Sd_pay_mothod
	 */
	public void setSd_pay_mothod(String Sd_pay_mothod) {
		setAttrVal("Sd_pay_mothod", Sd_pay_mothod);
	}
	/**
	 * 入院医生
	 * @return String
	 */
	public String getId_emp_opapply() {
		return ((String) getAttrVal("Id_emp_opapply"));
	}	
	/**
	 * 入院医生
	 * @param Id_emp_opapply
	 */
	public void setId_emp_opapply(String Id_emp_opapply) {
		setAttrVal("Id_emp_opapply", Id_emp_opapply);
	}
	/**
	 * 开通手机app标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mobapp() {
		return ((FBoolean) getAttrVal("Fg_mobapp"));
	}	
	/**
	 * 开通手机app标识
	 * @param Fg_mobapp
	 */
	public void setFg_mobapp(FBoolean Fg_mobapp) {
		setAttrVal("Fg_mobapp", Fg_mobapp);
	}
	/**
	 * 手机app电话号
	 * @return String
	 */
	public String getTelno_mobapp() {
		return ((String) getAttrVal("Telno_mobapp"));
	}	
	/**
	 * 手机app电话号
	 * @param Telno_mobapp
	 */
	public void setTelno_mobapp(String Telno_mobapp) {
		setAttrVal("Telno_mobapp", Telno_mobapp);
	}
	/**
	 * VIP标志
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标志
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 体检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pe() {
		return ((FBoolean) getAttrVal("Fg_pe"));
	}	
	/**
	 * 体检标志
	 * @param Fg_pe
	 */
	public void setFg_pe(FBoolean Fg_pe) {
		setAttrVal("Fg_pe", Fg_pe);
	}
	/**
	 * 体检身份类型
	 * @return String
	 */
	public String getSd_pe_psntp() {
		return ((String) getAttrVal("Sd_pe_psntp"));
	}	
	/**
	 * 体检身份类型
	 * @param Sd_pe_psntp
	 */
	public void setSd_pe_psntp(String Sd_pe_psntp) {
		setAttrVal("Sd_pe_psntp", Sd_pe_psntp);
	}
	/**
	 * 体检介绍人
	 * @return String
	 */
	public String getName_pe_intr() {
		return ((String) getAttrVal("Name_pe_intr"));
	}	
	/**
	 * 体检介绍人
	 * @param Name_pe_intr
	 */
	public void setName_pe_intr(String Name_pe_intr) {
		setAttrVal("Name_pe_intr", Name_pe_intr);
	}
	/**
	 * 是否是费用召回
	 * @return FBoolean
	 */
	public FBoolean getFg_blrecall() {
		return ((FBoolean) getAttrVal("Fg_blrecall"));
	}	
	/**
	 * 是否是费用召回
	 * @param Fg_blrecall
	 */
	public void setFg_blrecall(FBoolean Fg_blrecall) {
		setAttrVal("Fg_blrecall", Fg_blrecall);
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
	 * 上次踢出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_last() {
		return ((FDateTime) getAttrVal("Dt_end_last"));
	}	
	/**
	 * 上次踢出院时间
	 * @param Dt_end_last
	 */
	public void setDt_end_last(FDateTime Dt_end_last) {
		setAttrVal("Dt_end_last", Dt_end_last);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}	
	/**
	 * 预住院标志
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}	
	/**
	 * 编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}	
	/**
	 * 编码
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}	
	/**
	 * 名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}	
	/**
	 * 名称
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_level_nutr() {
		return ((String) getAttrVal("Name_level_nutr"));
	}	
	/**
	 * 名称
	 * @param Name_level_nutr
	 */
	public void setName_level_nutr(String Name_level_nutr) {
		setAttrVal("Name_level_nutr", Name_level_nutr);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}	
	/**
	 * 名称
	 * @param Name_referalsrc
	 */
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	/**
	 * 名称病情等级
	 * @return String
	 */
	public String getName_level_diseadm() {
		return ((String) getAttrVal("Name_level_diseadm"));
	}	
	/**
	 * 名称病情等级
	 * @param Name_level_diseadm
	 */
	public void setName_level_diseadm(String Name_level_diseadm) {
		setAttrVal("Name_level_diseadm", Name_level_diseadm);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getSd_diag_op() {
		return ((String) getAttrVal("Sd_diag_op"));
	}	
	/**
	 * 诊断编码
	 * @param Sd_diag_op
	 */
	public void setSd_diag_op(String Sd_diag_op) {
		setAttrVal("Sd_diag_op", Sd_diag_op);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag_op() {
		return ((String) getAttrVal("Name_diag_op"));
	}	
	/**
	 * 诊断名称
	 * @param Name_diag_op
	 */
	public void setName_diag_op(String Name_diag_op) {
		setAttrVal("Name_diag_op", Name_diag_op);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pay_mothod() {
		return ((String) getAttrVal("Name_pay_mothod"));
	}	
	/**
	 * 名称
	 * @param Name_pay_mothod
	 */
	public void setName_pay_mothod(String Name_pay_mothod) {
		setAttrVal("Name_pay_mothod", Name_pay_mothod);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp_phy_op() {
		return ((String) getAttrVal("Code_emp_phy_op"));
	}	
	/**
	 * 人员编码
	 * @param Code_emp_phy_op
	 */
	public void setCode_emp_phy_op(String Code_emp_phy_op) {
		setAttrVal("Code_emp_phy_op", Code_emp_phy_op);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pe_psntp() {
		return ((String) getAttrVal("Name_pe_psntp"));
	}	
	/**
	 * 名称
	 * @param Name_pe_psntp
	 */
	public void setName_pe_psntp(String Name_pe_psntp) {
		setAttrVal("Name_pe_psntp", Name_pe_psntp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ip_spec() {
		return ((String) getAttrVal("Name_ip_spec"));
	}	
	/**
	 * 名称
	 * @param Name_ip_spec
	 */
	public void setName_ip_spec(String Name_ip_spec) {
		setAttrVal("Name_ip_spec", Name_ip_spec);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_inpatient";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InpatientDODesc.class);
	}
	
}