package iih.sfda.aer.sfdaaerevmorax.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmorax.d.desc.SfdaAerEvMoraxDODesc;
import java.math.BigDecimal;

/**
 * 医源性气胸事件 DO数据 
 * 
 */
public class SfdaAerEvMoraxDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//禁食禁水事件主键
	public static final String ID_AER_EV_MORAX= "Id_aer_ev_morax";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//患者大于18岁
	public static final String EU_LAR_EGHYEAR= "Eu_lar_eghyear";
	//入院时
	public static final String EU_DIAG_PAT= "Eu_diag_pat";
	//围产期的患者
	public static final String EU_PERINA_PAT= "Eu_perina_pat";
	//诊断编码为胸部创伤
	public static final String EU_HYD_PAT= "Eu_hyd_pat";
	//为膈肌修复手术的患者
	public static final String EU_DIAP_PAT= "Eu_diap_pat";
	//有任何能显示
	public static final String EU_ANYOPS_PAT= "Eu_anyops_pat";
	//是否为早产儿
	public static final String EU_PERMBIR_PAT= "Eu_permbir_pat";
	//是否为剖腹产
	public static final String EU_PAUNCH_PAT= "Eu_paunch_pat";
	//气胸类型id
	public static final String ID_ORAXTP= "Id_oraxtp";
	//气胸类型编码
	public static final String SD_ORAXTP= "Sd_oraxtp";
	//其他气胸类型
	public static final String OTH_ORAXTP= "Oth_oraxtp";
	//气胸位置id
	public static final String ID_ORAXLOC= "Id_oraxloc";
	//气胸位置编码
	public static final String SD_ORAXLOC= "Sd_oraxloc";
	//其他气胸位置
	public static final String OTH_ORAXLOC= "Oth_oraxloc";
	//发生在何种医疗行为之中（之后）id
	public static final String ID_MEDTREAT= "Id_medtreat";
	//发生在何种医疗行为之中（之后）编码
	public static final String SD_MEDTREAT= "Sd_medtreat";
	//其他治疗
	public static final String OTH_MEDTREAT= "Oth_medtreat";
	//患者反应id
	public static final String ID_PAT_REACT= "Id_pat_react";
	//患者反应编码
	public static final String SD_PAR_REACT= "Sd_par_react";
	//其他患者反应
	public static final String OTH_PAR_REACT= "Oth_par_react";
	//事发经过描述
	public static final String DES= "Des";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//扩展字段4
	public static final String EXT4= "Ext4";
	//扩展字段5
	public static final String EXT5= "Ext5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//气胸类型
	public static final String NAME_ORAXTP= "Name_oraxtp";
	//气胸位置
	public static final String NAME_ORAXLOC= "Name_oraxloc";
	//发生在何种医疗行为之中（之后）
	public static final String NAME_MEDTREAT= "Name_medtreat";
	//患者反应
	public static final String NAME_PAT_REACT= "Name_pat_react";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 禁食禁水事件主键
	 * @return String
	 */
	public String getId_aer_ev_morax() {
		return ((String) getAttrVal("Id_aer_ev_morax"));
	}	
	/**
	 * 禁食禁水事件主键
	 * @param Id_aer_ev_morax
	 */
	public void setId_aer_ev_morax(String Id_aer_ev_morax) {
		setAttrVal("Id_aer_ev_morax", Id_aer_ev_morax);
	}
	/**
	 * 护理安全事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 护理安全事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
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
	 * 患者大于18岁
	 * @return Integer
	 */
	public Integer getEu_lar_eghyear() {
		return ((Integer) getAttrVal("Eu_lar_eghyear"));
	}	
	/**
	 * 患者大于18岁
	 * @param Eu_lar_eghyear
	 */
	public void setEu_lar_eghyear(Integer Eu_lar_eghyear) {
		setAttrVal("Eu_lar_eghyear", Eu_lar_eghyear);
	}
	/**
	 * 入院时
	 * @return Integer
	 */
	public Integer getEu_diag_pat() {
		return ((Integer) getAttrVal("Eu_diag_pat"));
	}	
	/**
	 * 入院时
	 * @param Eu_diag_pat
	 */
	public void setEu_diag_pat(Integer Eu_diag_pat) {
		setAttrVal("Eu_diag_pat", Eu_diag_pat);
	}
	/**
	 * 围产期的患者
	 * @return Integer
	 */
	public Integer getEu_perina_pat() {
		return ((Integer) getAttrVal("Eu_perina_pat"));
	}	
	/**
	 * 围产期的患者
	 * @param Eu_perina_pat
	 */
	public void setEu_perina_pat(Integer Eu_perina_pat) {
		setAttrVal("Eu_perina_pat", Eu_perina_pat);
	}
	/**
	 * 诊断编码为胸部创伤
	 * @return Integer
	 */
	public Integer getEu_hyd_pat() {
		return ((Integer) getAttrVal("Eu_hyd_pat"));
	}	
	/**
	 * 诊断编码为胸部创伤
	 * @param Eu_hyd_pat
	 */
	public void setEu_hyd_pat(Integer Eu_hyd_pat) {
		setAttrVal("Eu_hyd_pat", Eu_hyd_pat);
	}
	/**
	 * 为膈肌修复手术的患者
	 * @return Integer
	 */
	public Integer getEu_diap_pat() {
		return ((Integer) getAttrVal("Eu_diap_pat"));
	}	
	/**
	 * 为膈肌修复手术的患者
	 * @param Eu_diap_pat
	 */
	public void setEu_diap_pat(Integer Eu_diap_pat) {
		setAttrVal("Eu_diap_pat", Eu_diap_pat);
	}
	/**
	 * 有任何能显示
	 * @return Integer
	 */
	public Integer getEu_anyops_pat() {
		return ((Integer) getAttrVal("Eu_anyops_pat"));
	}	
	/**
	 * 有任何能显示
	 * @param Eu_anyops_pat
	 */
	public void setEu_anyops_pat(Integer Eu_anyops_pat) {
		setAttrVal("Eu_anyops_pat", Eu_anyops_pat);
	}
	/**
	 * 是否为早产儿
	 * @return Integer
	 */
	public Integer getEu_permbir_pat() {
		return ((Integer) getAttrVal("Eu_permbir_pat"));
	}	
	/**
	 * 是否为早产儿
	 * @param Eu_permbir_pat
	 */
	public void setEu_permbir_pat(Integer Eu_permbir_pat) {
		setAttrVal("Eu_permbir_pat", Eu_permbir_pat);
	}
	/**
	 * 是否为剖腹产
	 * @return Integer
	 */
	public Integer getEu_paunch_pat() {
		return ((Integer) getAttrVal("Eu_paunch_pat"));
	}	
	/**
	 * 是否为剖腹产
	 * @param Eu_paunch_pat
	 */
	public void setEu_paunch_pat(Integer Eu_paunch_pat) {
		setAttrVal("Eu_paunch_pat", Eu_paunch_pat);
	}
	/**
	 * 气胸类型id
	 * @return String
	 */
	public String getId_oraxtp() {
		return ((String) getAttrVal("Id_oraxtp"));
	}	
	/**
	 * 气胸类型id
	 * @param Id_oraxtp
	 */
	public void setId_oraxtp(String Id_oraxtp) {
		setAttrVal("Id_oraxtp", Id_oraxtp);
	}
	/**
	 * 气胸类型编码
	 * @return String
	 */
	public String getSd_oraxtp() {
		return ((String) getAttrVal("Sd_oraxtp"));
	}	
	/**
	 * 气胸类型编码
	 * @param Sd_oraxtp
	 */
	public void setSd_oraxtp(String Sd_oraxtp) {
		setAttrVal("Sd_oraxtp", Sd_oraxtp);
	}
	/**
	 * 其他气胸类型
	 * @return String
	 */
	public String getOth_oraxtp() {
		return ((String) getAttrVal("Oth_oraxtp"));
	}	
	/**
	 * 其他气胸类型
	 * @param Oth_oraxtp
	 */
	public void setOth_oraxtp(String Oth_oraxtp) {
		setAttrVal("Oth_oraxtp", Oth_oraxtp);
	}
	/**
	 * 气胸位置id
	 * @return String
	 */
	public String getId_oraxloc() {
		return ((String) getAttrVal("Id_oraxloc"));
	}	
	/**
	 * 气胸位置id
	 * @param Id_oraxloc
	 */
	public void setId_oraxloc(String Id_oraxloc) {
		setAttrVal("Id_oraxloc", Id_oraxloc);
	}
	/**
	 * 气胸位置编码
	 * @return String
	 */
	public String getSd_oraxloc() {
		return ((String) getAttrVal("Sd_oraxloc"));
	}	
	/**
	 * 气胸位置编码
	 * @param Sd_oraxloc
	 */
	public void setSd_oraxloc(String Sd_oraxloc) {
		setAttrVal("Sd_oraxloc", Sd_oraxloc);
	}
	/**
	 * 其他气胸位置
	 * @return String
	 */
	public String getOth_oraxloc() {
		return ((String) getAttrVal("Oth_oraxloc"));
	}	
	/**
	 * 其他气胸位置
	 * @param Oth_oraxloc
	 */
	public void setOth_oraxloc(String Oth_oraxloc) {
		setAttrVal("Oth_oraxloc", Oth_oraxloc);
	}
	/**
	 * 发生在何种医疗行为之中（之后）id
	 * @return String
	 */
	public String getId_medtreat() {
		return ((String) getAttrVal("Id_medtreat"));
	}	
	/**
	 * 发生在何种医疗行为之中（之后）id
	 * @param Id_medtreat
	 */
	public void setId_medtreat(String Id_medtreat) {
		setAttrVal("Id_medtreat", Id_medtreat);
	}
	/**
	 * 发生在何种医疗行为之中（之后）编码
	 * @return String
	 */
	public String getSd_medtreat() {
		return ((String) getAttrVal("Sd_medtreat"));
	}	
	/**
	 * 发生在何种医疗行为之中（之后）编码
	 * @param Sd_medtreat
	 */
	public void setSd_medtreat(String Sd_medtreat) {
		setAttrVal("Sd_medtreat", Sd_medtreat);
	}
	/**
	 * 其他治疗
	 * @return String
	 */
	public String getOth_medtreat() {
		return ((String) getAttrVal("Oth_medtreat"));
	}	
	/**
	 * 其他治疗
	 * @param Oth_medtreat
	 */
	public void setOth_medtreat(String Oth_medtreat) {
		setAttrVal("Oth_medtreat", Oth_medtreat);
	}
	/**
	 * 患者反应id
	 * @return String
	 */
	public String getId_pat_react() {
		return ((String) getAttrVal("Id_pat_react"));
	}	
	/**
	 * 患者反应id
	 * @param Id_pat_react
	 */
	public void setId_pat_react(String Id_pat_react) {
		setAttrVal("Id_pat_react", Id_pat_react);
	}
	/**
	 * 患者反应编码
	 * @return String
	 */
	public String getSd_par_react() {
		return ((String) getAttrVal("Sd_par_react"));
	}	
	/**
	 * 患者反应编码
	 * @param Sd_par_react
	 */
	public void setSd_par_react(String Sd_par_react) {
		setAttrVal("Sd_par_react", Sd_par_react);
	}
	/**
	 * 其他患者反应
	 * @return String
	 */
	public String getOth_par_react() {
		return ((String) getAttrVal("Oth_par_react"));
	}	
	/**
	 * 其他患者反应
	 * @param Oth_par_react
	 */
	public void setOth_par_react(String Oth_par_react) {
		setAttrVal("Oth_par_react", Oth_par_react);
	}
	/**
	 * 事发经过描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 事发经过描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getExt1() {
		return ((String) getAttrVal("Ext1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ext1
	 */
	public void setExt1(String Ext1) {
		setAttrVal("Ext1", Ext1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getExt2() {
		return ((String) getAttrVal("Ext2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ext2
	 */
	public void setExt2(String Ext2) {
		setAttrVal("Ext2", Ext2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getExt3() {
		return ((String) getAttrVal("Ext3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ext3
	 */
	public void setExt3(String Ext3) {
		setAttrVal("Ext3", Ext3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getExt4() {
		return ((String) getAttrVal("Ext4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ext4
	 */
	public void setExt4(String Ext4) {
		setAttrVal("Ext4", Ext4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getExt5() {
		return ((String) getAttrVal("Ext5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ext5
	 */
	public void setExt5(String Ext5) {
		setAttrVal("Ext5", Ext5);
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
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
	 * 气胸类型
	 * @return String
	 */
	public String getName_oraxtp() {
		return ((String) getAttrVal("Name_oraxtp"));
	}	
	/**
	 * 气胸类型
	 * @param Name_oraxtp
	 */
	public void setName_oraxtp(String Name_oraxtp) {
		setAttrVal("Name_oraxtp", Name_oraxtp);
	}
	/**
	 * 气胸位置
	 * @return String
	 */
	public String getName_oraxloc() {
		return ((String) getAttrVal("Name_oraxloc"));
	}	
	/**
	 * 气胸位置
	 * @param Name_oraxloc
	 */
	public void setName_oraxloc(String Name_oraxloc) {
		setAttrVal("Name_oraxloc", Name_oraxloc);
	}
	/**
	 * 发生在何种医疗行为之中（之后）
	 * @return String
	 */
	public String getName_medtreat() {
		return ((String) getAttrVal("Name_medtreat"));
	}	
	/**
	 * 发生在何种医疗行为之中（之后）
	 * @param Name_medtreat
	 */
	public void setName_medtreat(String Name_medtreat) {
		setAttrVal("Name_medtreat", Name_medtreat);
	}
	/**
	 * 患者反应
	 * @return String
	 */
	public String getName_pat_react() {
		return ((String) getAttrVal("Name_pat_react"));
	}	
	/**
	 * 患者反应
	 * @param Name_pat_react
	 */
	public void setName_pat_react(String Name_pat_react) {
		setAttrVal("Name_pat_react", Name_pat_react);
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
		return "Id_aer_ev_morax";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MORAX";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMoraxDODesc.class);
	}
	
}