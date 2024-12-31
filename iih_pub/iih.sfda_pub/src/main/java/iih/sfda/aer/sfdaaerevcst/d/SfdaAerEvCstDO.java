package iih.sfda.aer.sfdaaerevcst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevcst.d.desc.SfdaAerEvCstDODesc;
import java.math.BigDecimal;

/**
 * 约束事件 DO数据 
 * 
 */
public class SfdaAerEvCstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//约束事件主键
	public static final String ID_AER_EV_CST= "Id_aer_ev_cst";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//约束事件类型id
	public static final String ID_CST_TP= "Id_cst_tp";
	//约束事件类型
	public static final String SD_CST_TP= "Sd_cst_tp";
	//其他约束事件类型
	public static final String OTH_CST_TP= "Oth_cst_tp";
	//约束部位id
	public static final String ID_CST_PTY= "Id_cst_pty";
	//约束部位
	public static final String SD_CST_PTY= "Sd_cst_pty";
	//其他约束部位
	public static final String OTH_CST_PTY= "Oth_cst_pty";
	//患者临床反映id
	public static final String ID_PAT_CNREF= "Id_pat_cnref";
	//患者临床反映
	public static final String SD_PAT_CNREF= "Sd_pat_cnref";
	//患者临床其他反映
	public static final String OTH_PAT_CNREF= "Oth_pat_cnref";
	//事件发生经过补充
	public static final String PRO_DES= "Pro_des";
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
	//名称
	public static final String NAME_CST_TP= "Name_cst_tp";
	//名称
	public static final String NAME_CST_PTY= "Name_cst_pty";
	//名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 约束事件主键
	 * @return String
	 */
	public String getId_aer_ev_cst() {
		return ((String) getAttrVal("Id_aer_ev_cst"));
	}	
	/**
	 * 约束事件主键
	 * @param Id_aer_ev_cst
	 */
	public void setId_aer_ev_cst(String Id_aer_ev_cst) {
		setAttrVal("Id_aer_ev_cst", Id_aer_ev_cst);
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
	 * 约束事件类型id
	 * @return String
	 */
	public String getId_cst_tp() {
		return ((String) getAttrVal("Id_cst_tp"));
	}	
	/**
	 * 约束事件类型id
	 * @param Id_cst_tp
	 */
	public void setId_cst_tp(String Id_cst_tp) {
		setAttrVal("Id_cst_tp", Id_cst_tp);
	}
	/**
	 * 约束事件类型
	 * @return String
	 */
	public String getSd_cst_tp() {
		return ((String) getAttrVal("Sd_cst_tp"));
	}	
	/**
	 * 约束事件类型
	 * @param Sd_cst_tp
	 */
	public void setSd_cst_tp(String Sd_cst_tp) {
		setAttrVal("Sd_cst_tp", Sd_cst_tp);
	}
	/**
	 * 其他约束事件类型
	 * @return String
	 */
	public String getOth_cst_tp() {
		return ((String) getAttrVal("Oth_cst_tp"));
	}	
	/**
	 * 其他约束事件类型
	 * @param Oth_cst_tp
	 */
	public void setOth_cst_tp(String Oth_cst_tp) {
		setAttrVal("Oth_cst_tp", Oth_cst_tp);
	}
	/**
	 * 约束部位id
	 * @return String
	 */
	public String getId_cst_pty() {
		return ((String) getAttrVal("Id_cst_pty"));
	}	
	/**
	 * 约束部位id
	 * @param Id_cst_pty
	 */
	public void setId_cst_pty(String Id_cst_pty) {
		setAttrVal("Id_cst_pty", Id_cst_pty);
	}
	/**
	 * 约束部位
	 * @return String
	 */
	public String getSd_cst_pty() {
		return ((String) getAttrVal("Sd_cst_pty"));
	}	
	/**
	 * 约束部位
	 * @param Sd_cst_pty
	 */
	public void setSd_cst_pty(String Sd_cst_pty) {
		setAttrVal("Sd_cst_pty", Sd_cst_pty);
	}
	/**
	 * 其他约束部位
	 * @return String
	 */
	public String getOth_cst_pty() {
		return ((String) getAttrVal("Oth_cst_pty"));
	}	
	/**
	 * 其他约束部位
	 * @param Oth_cst_pty
	 */
	public void setOth_cst_pty(String Oth_cst_pty) {
		setAttrVal("Oth_cst_pty", Oth_cst_pty);
	}
	/**
	 * 患者临床反映id
	 * @return String
	 */
	public String getId_pat_cnref() {
		return ((String) getAttrVal("Id_pat_cnref"));
	}	
	/**
	 * 患者临床反映id
	 * @param Id_pat_cnref
	 */
	public void setId_pat_cnref(String Id_pat_cnref) {
		setAttrVal("Id_pat_cnref", Id_pat_cnref);
	}
	/**
	 * 患者临床反映
	 * @return String
	 */
	public String getSd_pat_cnref() {
		return ((String) getAttrVal("Sd_pat_cnref"));
	}	
	/**
	 * 患者临床反映
	 * @param Sd_pat_cnref
	 */
	public void setSd_pat_cnref(String Sd_pat_cnref) {
		setAttrVal("Sd_pat_cnref", Sd_pat_cnref);
	}
	/**
	 * 患者临床其他反映
	 * @return String
	 */
	public String getOth_pat_cnref() {
		return ((String) getAttrVal("Oth_pat_cnref"));
	}	
	/**
	 * 患者临床其他反映
	 * @param Oth_pat_cnref
	 */
	public void setOth_pat_cnref(String Oth_pat_cnref) {
		setAttrVal("Oth_pat_cnref", Oth_pat_cnref);
	}
	/**
	 * 事件发生经过补充
	 * @return String
	 */
	public String getPro_des() {
		return ((String) getAttrVal("Pro_des"));
	}	
	/**
	 * 事件发生经过补充
	 * @param Pro_des
	 */
	public void setPro_des(String Pro_des) {
		setAttrVal("Pro_des", Pro_des);
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
	 * 名称
	 * @return String
	 */
	public String getName_cst_tp() {
		return ((String) getAttrVal("Name_cst_tp"));
	}	
	/**
	 * 名称
	 * @param Name_cst_tp
	 */
	public void setName_cst_tp(String Name_cst_tp) {
		setAttrVal("Name_cst_tp", Name_cst_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_cst_pty() {
		return ((String) getAttrVal("Name_cst_pty"));
	}	
	/**
	 * 名称
	 * @param Name_cst_pty
	 */
	public void setName_cst_pty(String Name_cst_pty) {
		setAttrVal("Name_cst_pty", Name_cst_pty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_aer_ev_cst";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_CST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvCstDODesc.class);
	}
	
}