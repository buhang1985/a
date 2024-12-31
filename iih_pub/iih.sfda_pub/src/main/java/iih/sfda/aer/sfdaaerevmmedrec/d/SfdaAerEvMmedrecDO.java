package iih.sfda.aer.sfdaaerevmmedrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmmedrec.d.desc.SfdaAerEvMmedrecDODesc;
import java.math.BigDecimal;

/**
 * 诊疗记录事件 DO数据 
 * 
 */
public class SfdaAerEvMmedrecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊疗记录事件主键
	public static final String ID_AER_EV_MEDREC= "Id_aer_ev_medrec";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//诊疗记录错误类型id
	public static final String ID_MED_ERR_TP= "Id_med_err_tp";
	//诊疗记录错误类型编码
	public static final String SD_MED_ERR_TP= "Sd_med_err_tp";
	//诊疗记录其他错误类型
	public static final String MED_ERR_TP_OTH= "Med_err_tp_oth";
	//造成的后果
	public static final String EU_LD_RES= "Eu_ld_res";
	//造成的后果具体描述
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
	public static final String NAME_MED_ERR_TP= "Name_med_err_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 诊疗记录事件主键
	 * @return String
	 */
	public String getId_aer_ev_medrec() {
		return ((String) getAttrVal("Id_aer_ev_medrec"));
	}	
	/**
	 * 诊疗记录事件主键
	 * @param Id_aer_ev_medrec
	 */
	public void setId_aer_ev_medrec(String Id_aer_ev_medrec) {
		setAttrVal("Id_aer_ev_medrec", Id_aer_ev_medrec);
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
	 * 诊疗记录错误类型id
	 * @return String
	 */
	public String getId_med_err_tp() {
		return ((String) getAttrVal("Id_med_err_tp"));
	}	
	/**
	 * 诊疗记录错误类型id
	 * @param Id_med_err_tp
	 */
	public void setId_med_err_tp(String Id_med_err_tp) {
		setAttrVal("Id_med_err_tp", Id_med_err_tp);
	}
	/**
	 * 诊疗记录错误类型编码
	 * @return String
	 */
	public String getSd_med_err_tp() {
		return ((String) getAttrVal("Sd_med_err_tp"));
	}	
	/**
	 * 诊疗记录错误类型编码
	 * @param Sd_med_err_tp
	 */
	public void setSd_med_err_tp(String Sd_med_err_tp) {
		setAttrVal("Sd_med_err_tp", Sd_med_err_tp);
	}
	/**
	 * 诊疗记录其他错误类型
	 * @return String
	 */
	public String getMed_err_tp_oth() {
		return ((String) getAttrVal("Med_err_tp_oth"));
	}	
	/**
	 * 诊疗记录其他错误类型
	 * @param Med_err_tp_oth
	 */
	public void setMed_err_tp_oth(String Med_err_tp_oth) {
		setAttrVal("Med_err_tp_oth", Med_err_tp_oth);
	}
	/**
	 * 造成的后果
	 * @return Integer
	 */
	public Integer getEu_ld_res() {
		return ((Integer) getAttrVal("Eu_ld_res"));
	}	
	/**
	 * 造成的后果
	 * @param Eu_ld_res
	 */
	public void setEu_ld_res(Integer Eu_ld_res) {
		setAttrVal("Eu_ld_res", Eu_ld_res);
	}
	/**
	 * 造成的后果具体描述
	 * @return String
	 */
	public String getLd_res_des() {
		return ((String) getAttrVal("Ld_res_des"));
	}	
	/**
	 * 造成的后果具体描述
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
	public String getName_med_err_tp() {
		return ((String) getAttrVal("Name_med_err_tp"));
	}	
	/**
	 * 名称
	 * @param Name_med_err_tp
	 */
	public void setName_med_err_tp(String Name_med_err_tp) {
		setAttrVal("Name_med_err_tp", Name_med_err_tp);
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
		return "Id_aer_ev_medrec";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MMEDREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMmedrecDODesc.class);
	}
	
}