package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.EnIppreDODesc;
import java.math.BigDecimal;

/**
 * 预住院实体 DO数据 
 * 
 */
public class EnIppreDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//IID
	public static final String ID_PREIP= "Id_preip";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//入院申请id
	public static final String ID_APTIP= "Id_aptip";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//门诊就诊id
	public static final String ID_ENT_OP= "Id_ent_op";
	//住院就诊id
	public static final String ID_ENT_IP= "Id_ent_ip";
	//状态
	public static final String SD_STATUS= "Sd_status";
	//有效标志
	public static final String FG_VALID= "Fg_valid";
	//入院科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//入院病区
	public static final String ID_DEP_WARD= "Id_dep_ward";
	//检查完成标志
	public static final String FG_DONE_MT= "Fg_done_mt";
	//完成麻醉评估
	public static final String FG_DONE_ANEST= "Fg_done_anest";
	//完成床位预约
	public static final String FG_DONE_BED= "Fg_done_bed";
	//入院审核通过
	public static final String FG_DONE_DEP= "Fg_done_dep";
	//随访完成
	public static final String FG_FP= "Fg_fp";
	//转科标志
	public static final String FG_TRANSDEP= "Fg_transdep";
	//接收预住院时间
	public static final String DT_ACPT_IPPRE= "Dt_acpt_ippre";
	//接收预住院操作员
	public static final String ID_EMP_ACPT= "Id_emp_acpt";
	//出预住院时间
	public static final String DT_END_IPPRE= "Dt_end_ippre";
	//备注
	public static final String NOTE= "Note";
	//停止入院说明
	public static final String NOTE_CANC= "Note_canc";
	//医疗组编码
	public static final String CODE_WG= "Code_wg";
	//医疗组id
	public static final String ID_WG= "Id_wg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//编码
	public static final String SD_DEP_PHY= "Sd_dep_phy";
	//编码
	public static final String SD_DEP_WARD= "Sd_dep_ward";
	//名称
	public static final String NAME_DEP_WARD= "Name_dep_ward";
	//业务组名称
	public static final String NAME_WG= "Name_wg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * IID
	 * @return String
	 */
	public String getId_preip() {
		return ((String) getAttrVal("Id_preip"));
	}	
	/**
	 * IID
	 * @param Id_preip
	 */
	public void setId_preip(String Id_preip) {
		setAttrVal("Id_preip", Id_preip);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 入院申请id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}	
	/**
	 * 入院申请id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
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
	 * 住院就诊id
	 * @return String
	 */
	public String getId_ent_ip() {
		return ((String) getAttrVal("Id_ent_ip"));
	}	
	/**
	 * 住院就诊id
	 * @param Id_ent_ip
	 */
	public void setId_ent_ip(String Id_ent_ip) {
		setAttrVal("Id_ent_ip", Id_ent_ip);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_valid() {
		return ((FBoolean) getAttrVal("Fg_valid"));
	}	
	/**
	 * 有效标志
	 * @param Fg_valid
	 */
	public void setFg_valid(FBoolean Fg_valid) {
		setAttrVal("Fg_valid", Fg_valid);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 入院科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getId_dep_ward() {
		return ((String) getAttrVal("Id_dep_ward"));
	}	
	/**
	 * 入院病区
	 * @param Id_dep_ward
	 */
	public void setId_dep_ward(String Id_dep_ward) {
		setAttrVal("Id_dep_ward", Id_dep_ward);
	}
	/**
	 * 检查完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_done_mt() {
		return ((FBoolean) getAttrVal("Fg_done_mt"));
	}	
	/**
	 * 检查完成标志
	 * @param Fg_done_mt
	 */
	public void setFg_done_mt(FBoolean Fg_done_mt) {
		setAttrVal("Fg_done_mt", Fg_done_mt);
	}
	/**
	 * 完成麻醉评估
	 * @return FBoolean
	 */
	public FBoolean getFg_done_anest() {
		return ((FBoolean) getAttrVal("Fg_done_anest"));
	}	
	/**
	 * 完成麻醉评估
	 * @param Fg_done_anest
	 */
	public void setFg_done_anest(FBoolean Fg_done_anest) {
		setAttrVal("Fg_done_anest", Fg_done_anest);
	}
	/**
	 * 完成床位预约
	 * @return FBoolean
	 */
	public FBoolean getFg_done_bed() {
		return ((FBoolean) getAttrVal("Fg_done_bed"));
	}	
	/**
	 * 完成床位预约
	 * @param Fg_done_bed
	 */
	public void setFg_done_bed(FBoolean Fg_done_bed) {
		setAttrVal("Fg_done_bed", Fg_done_bed);
	}
	/**
	 * 入院审核通过
	 * @return FBoolean
	 */
	public FBoolean getFg_done_dep() {
		return ((FBoolean) getAttrVal("Fg_done_dep"));
	}	
	/**
	 * 入院审核通过
	 * @param Fg_done_dep
	 */
	public void setFg_done_dep(FBoolean Fg_done_dep) {
		setAttrVal("Fg_done_dep", Fg_done_dep);
	}
	/**
	 * 随访完成
	 * @return FBoolean
	 */
	public FBoolean getFg_fp() {
		return ((FBoolean) getAttrVal("Fg_fp"));
	}	
	/**
	 * 随访完成
	 * @param Fg_fp
	 */
	public void setFg_fp(FBoolean Fg_fp) {
		setAttrVal("Fg_fp", Fg_fp);
	}
	/**
	 * 转科标志
	 * @return FBoolean
	 */
	public FBoolean getFg_transdep() {
		return ((FBoolean) getAttrVal("Fg_transdep"));
	}	
	/**
	 * 转科标志
	 * @param Fg_transdep
	 */
	public void setFg_transdep(FBoolean Fg_transdep) {
		setAttrVal("Fg_transdep", Fg_transdep);
	}
	/**
	 * 接收预住院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt_ippre() {
		return ((FDateTime) getAttrVal("Dt_acpt_ippre"));
	}	
	/**
	 * 接收预住院时间
	 * @param Dt_acpt_ippre
	 */
	public void setDt_acpt_ippre(FDateTime Dt_acpt_ippre) {
		setAttrVal("Dt_acpt_ippre", Dt_acpt_ippre);
	}
	/**
	 * 接收预住院操作员
	 * @return String
	 */
	public String getId_emp_acpt() {
		return ((String) getAttrVal("Id_emp_acpt"));
	}	
	/**
	 * 接收预住院操作员
	 * @param Id_emp_acpt
	 */
	public void setId_emp_acpt(String Id_emp_acpt) {
		setAttrVal("Id_emp_acpt", Id_emp_acpt);
	}
	/**
	 * 出预住院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_ippre() {
		return ((FDateTime) getAttrVal("Dt_end_ippre"));
	}	
	/**
	 * 出预住院时间
	 * @param Dt_end_ippre
	 */
	public void setDt_end_ippre(FDateTime Dt_end_ippre) {
		setAttrVal("Dt_end_ippre", Dt_end_ippre);
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
	 * 停止入院说明
	 * @return String
	 */
	public String getNote_canc() {
		return ((String) getAttrVal("Note_canc"));
	}	
	/**
	 * 停止入院说明
	 * @param Note_canc
	 */
	public void setNote_canc(String Note_canc) {
		setAttrVal("Note_canc", Note_canc);
	}
	/**
	 * 医疗组编码
	 * @return String
	 */
	public String getCode_wg() {
		return ((String) getAttrVal("Code_wg"));
	}	
	/**
	 * 医疗组编码
	 * @param Code_wg
	 */
	public void setCode_wg(String Code_wg) {
		setAttrVal("Code_wg", Code_wg);
	}
	/**
	 * 医疗组id
	 * @return String
	 */
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}	
	/**
	 * 医疗组id
	 * @param Id_wg
	 */
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
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
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
	 * 编码
	 * @return String
	 */
	public String getSd_dep_ward() {
		return ((String) getAttrVal("Sd_dep_ward"));
	}	
	/**
	 * 编码
	 * @param Sd_dep_ward
	 */
	public void setSd_dep_ward(String Sd_dep_ward) {
		setAttrVal("Sd_dep_ward", Sd_dep_ward);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_ward() {
		return ((String) getAttrVal("Name_dep_ward"));
	}	
	/**
	 * 名称
	 * @param Name_dep_ward
	 */
	public void setName_dep_ward(String Name_dep_ward) {
		setAttrVal("Name_dep_ward", Name_dep_ward);
	}
	/**
	 * 业务组名称
	 * @return String
	 */
	public String getName_wg() {
		return ((String) getAttrVal("Name_wg"));
	}	
	/**
	 * 业务组名称
	 * @param Name_wg
	 */
	public void setName_wg(String Name_wg) {
		setAttrVal("Name_wg", Name_wg);
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
		return "Id_preip";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ippre";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnIppreDODesc.class);
	}
	
}