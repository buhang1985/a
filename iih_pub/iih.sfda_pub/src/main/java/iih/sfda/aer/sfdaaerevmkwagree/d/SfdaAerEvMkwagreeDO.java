package iih.sfda.aer.sfdaaerevmkwagree.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmkwagree.d.desc.SfdaAerEvMkwagreeDODesc;
import java.math.BigDecimal;

/**
 * 知情同意事件 DO数据 
 * 
 */
public class SfdaAerEvMkwagreeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//知情同意事件主键
	public static final String ID_AER_EV_MKWAGREE= "Id_aer_ev_mkwagree";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//临床常规知情同意错误id
	public static final String ID_RULE_ERR= "Id_rule_err";
	//临床常规知情同意错误编码
	public static final String SD_RULE_ERR= "Sd_rule_err";
	//临床常规知情同意其他错误
	public static final String RULE_ERR_OTH= "Rule_err_oth";
	//临床科研知情同意错误id
	public static final String ID_SCIENT_ERR= "Id_scient_err";
	//临床科研知情同意错误编码
	public static final String SD_SCIENT_ERR= "Sd_scient_err";
	//临床常规知情同意错误类型id
	public static final String ID_RULE_ERR_TP= "Id_rule_err_tp";
	//临床常规知情同意错误类型编码
	public static final String SD_RULE_ERR_TP= "Sd_rule_err_tp";
	//其他环节上告知详情描述
	public static final String RULE_ERR_TP_OTH= "Rule_err_tp_oth";
	//造成的后果
	public static final String LD_RES_DES= "Ld_res_des";
	//事发经过描述
	public static final String COURSE_DES= "Course_des";
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
	public static final String NAME_RULE_ERR= "Name_rule_err";
	//名称
	public static final String NAME_SCIENT_ERR= "Name_scient_err";
	//名称
	public static final String NAME_RULE_ERR_TP= "Name_rule_err_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 知情同意事件主键
	 * @return String
	 */
	public String getId_aer_ev_mkwagree() {
		return ((String) getAttrVal("Id_aer_ev_mkwagree"));
	}	
	/**
	 * 知情同意事件主键
	 * @param Id_aer_ev_mkwagree
	 */
	public void setId_aer_ev_mkwagree(String Id_aer_ev_mkwagree) {
		setAttrVal("Id_aer_ev_mkwagree", Id_aer_ev_mkwagree);
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
	 * 临床常规知情同意错误id
	 * @return String
	 */
	public String getId_rule_err() {
		return ((String) getAttrVal("Id_rule_err"));
	}	
	/**
	 * 临床常规知情同意错误id
	 * @param Id_rule_err
	 */
	public void setId_rule_err(String Id_rule_err) {
		setAttrVal("Id_rule_err", Id_rule_err);
	}
	/**
	 * 临床常规知情同意错误编码
	 * @return String
	 */
	public String getSd_rule_err() {
		return ((String) getAttrVal("Sd_rule_err"));
	}	
	/**
	 * 临床常规知情同意错误编码
	 * @param Sd_rule_err
	 */
	public void setSd_rule_err(String Sd_rule_err) {
		setAttrVal("Sd_rule_err", Sd_rule_err);
	}
	/**
	 * 临床常规知情同意其他错误
	 * @return String
	 */
	public String getRule_err_oth() {
		return ((String) getAttrVal("Rule_err_oth"));
	}	
	/**
	 * 临床常规知情同意其他错误
	 * @param Rule_err_oth
	 */
	public void setRule_err_oth(String Rule_err_oth) {
		setAttrVal("Rule_err_oth", Rule_err_oth);
	}
	/**
	 * 临床科研知情同意错误id
	 * @return String
	 */
	public String getId_scient_err() {
		return ((String) getAttrVal("Id_scient_err"));
	}	
	/**
	 * 临床科研知情同意错误id
	 * @param Id_scient_err
	 */
	public void setId_scient_err(String Id_scient_err) {
		setAttrVal("Id_scient_err", Id_scient_err);
	}
	/**
	 * 临床科研知情同意错误编码
	 * @return String
	 */
	public String getSd_scient_err() {
		return ((String) getAttrVal("Sd_scient_err"));
	}	
	/**
	 * 临床科研知情同意错误编码
	 * @param Sd_scient_err
	 */
	public void setSd_scient_err(String Sd_scient_err) {
		setAttrVal("Sd_scient_err", Sd_scient_err);
	}
	/**
	 * 临床常规知情同意错误类型id
	 * @return String
	 */
	public String getId_rule_err_tp() {
		return ((String) getAttrVal("Id_rule_err_tp"));
	}	
	/**
	 * 临床常规知情同意错误类型id
	 * @param Id_rule_err_tp
	 */
	public void setId_rule_err_tp(String Id_rule_err_tp) {
		setAttrVal("Id_rule_err_tp", Id_rule_err_tp);
	}
	/**
	 * 临床常规知情同意错误类型编码
	 * @return String
	 */
	public String getSd_rule_err_tp() {
		return ((String) getAttrVal("Sd_rule_err_tp"));
	}	
	/**
	 * 临床常规知情同意错误类型编码
	 * @param Sd_rule_err_tp
	 */
	public void setSd_rule_err_tp(String Sd_rule_err_tp) {
		setAttrVal("Sd_rule_err_tp", Sd_rule_err_tp);
	}
	/**
	 * 其他环节上告知详情描述
	 * @return String
	 */
	public String getRule_err_tp_oth() {
		return ((String) getAttrVal("Rule_err_tp_oth"));
	}	
	/**
	 * 其他环节上告知详情描述
	 * @param Rule_err_tp_oth
	 */
	public void setRule_err_tp_oth(String Rule_err_tp_oth) {
		setAttrVal("Rule_err_tp_oth", Rule_err_tp_oth);
	}
	/**
	 * 造成的后果
	 * @return String
	 */
	public String getLd_res_des() {
		return ((String) getAttrVal("Ld_res_des"));
	}	
	/**
	 * 造成的后果
	 * @param Ld_res_des
	 */
	public void setLd_res_des(String Ld_res_des) {
		setAttrVal("Ld_res_des", Ld_res_des);
	}
	/**
	 * 事发经过描述
	 * @return String
	 */
	public String getCourse_des() {
		return ((String) getAttrVal("Course_des"));
	}	
	/**
	 * 事发经过描述
	 * @param Course_des
	 */
	public void setCourse_des(String Course_des) {
		setAttrVal("Course_des", Course_des);
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
	public String getName_rule_err() {
		return ((String) getAttrVal("Name_rule_err"));
	}	
	/**
	 * 名称
	 * @param Name_rule_err
	 */
	public void setName_rule_err(String Name_rule_err) {
		setAttrVal("Name_rule_err", Name_rule_err);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_scient_err() {
		return ((String) getAttrVal("Name_scient_err"));
	}	
	/**
	 * 名称
	 * @param Name_scient_err
	 */
	public void setName_scient_err(String Name_scient_err) {
		setAttrVal("Name_scient_err", Name_scient_err);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rule_err_tp() {
		return ((String) getAttrVal("Name_rule_err_tp"));
	}	
	/**
	 * 名称
	 * @param Name_rule_err_tp
	 */
	public void setName_rule_err_tp(String Name_rule_err_tp) {
		setAttrVal("Name_rule_err_tp", Name_rule_err_tp);
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
		return "Id_aer_ev_mkwagree";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MKWAGREE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMkwagreeDODesc.class);
	}
	
}