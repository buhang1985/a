package iih.sfda.aer.sfdaaerevissu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevissu.d.desc.SfdaAerEvIssuDODesc;
import java.math.BigDecimal;

/**
 * 整改问题 DO数据 
 * 
 */
public class SfdaAerEvIssuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//事件整改问题主键
	public static final String ID_AER_EV_ISSU= "Id_aer_ev_issu";
	//不良事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//整改问题描述
	public static final String ISSU_DES= "Issu_des";
	//整改应达到的预期目标
	public static final String EXP_GOAL= "Exp_goal";
	//整改备注
	public static final String REMARK= "Remark";
	//是否完成
	public static final String FG_FINISH= "Fg_finish";
	//登记人
	public static final String ID_PSN_REG= "Id_psn_reg";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//集团
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//姓名
	public static final String NAME_PSN_REG= "Name_psn_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 事件整改问题主键
	 * @return String
	 */
	public String getId_aer_ev_issu() {
		return ((String) getAttrVal("Id_aer_ev_issu"));
	}	
	/**
	 * 事件整改问题主键
	 * @param Id_aer_ev_issu
	 */
	public void setId_aer_ev_issu(String Id_aer_ev_issu) {
		setAttrVal("Id_aer_ev_issu", Id_aer_ev_issu);
	}
	/**
	 * 不良事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 不良事件外键
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
	 * 整改问题描述
	 * @return String
	 */
	public String getIssu_des() {
		return ((String) getAttrVal("Issu_des"));
	}	
	/**
	 * 整改问题描述
	 * @param Issu_des
	 */
	public void setIssu_des(String Issu_des) {
		setAttrVal("Issu_des", Issu_des);
	}
	/**
	 * 整改应达到的预期目标
	 * @return String
	 */
	public String getExp_goal() {
		return ((String) getAttrVal("Exp_goal"));
	}	
	/**
	 * 整改应达到的预期目标
	 * @param Exp_goal
	 */
	public void setExp_goal(String Exp_goal) {
		setAttrVal("Exp_goal", Exp_goal);
	}
	/**
	 * 整改备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 整改备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 是否完成
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}	
	/**
	 * 是否完成
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_psn_reg() {
		return ((String) getAttrVal("Id_psn_reg"));
	}	
	/**
	 * 登记人
	 * @param Id_psn_reg
	 */
	public void setId_psn_reg(String Id_psn_reg) {
		setAttrVal("Id_psn_reg", Id_psn_reg);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 集团
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团
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
	 * 姓名
	 * @return String
	 */
	public String getName_psn_reg() {
		return ((String) getAttrVal("Name_psn_reg"));
	}	
	/**
	 * 姓名
	 * @param Name_psn_reg
	 */
	public void setName_psn_reg(String Name_psn_reg) {
		setAttrVal("Name_psn_reg", Name_psn_reg);
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
		return "Id_aer_ev_issu";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_ISSU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvIssuDODesc.class);
	}
	
}