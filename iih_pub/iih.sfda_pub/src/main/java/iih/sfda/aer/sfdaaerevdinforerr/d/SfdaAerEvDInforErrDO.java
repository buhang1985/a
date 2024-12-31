package iih.sfda.aer.sfdaaerevdinforerr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevdinforerr.d.desc.SfdaAerEvDInforErrDODesc;
import java.math.BigDecimal;

/**
 * 信息流转错误 DO数据 
 * 
 */
public class SfdaAerEvDInforErrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//信息流转错误主键
	public static final String ID_AER_EV_DINFORERR= "Id_aer_ev_dinforerr";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//事件错误详情id
	public static final String ID_ERR_DETAIL= "Id_err_detail";
	//事件错误详情编码
	public static final String SD_ERR_DETAIL= "Sd_err_detail";
	//应给药物剂型id
	public static final String ID_DRUG_DOSA= "Id_drug_dosa";
	//应给药物剂型编码
	public static final String SD_DRUG_DOSA= "Sd_drug_dosa";
	//应给药物其他剂型
	public static final String OTH_DRUG_DOSA= "Oth_drug_dosa";
	//使用药物
	public static final String USE_DRUG= "Use_drug";
	//用法用量
	public static final String US_DOS_AGE= "Us_dos_age";
	//事件分析
	public static final String EVEN_ANALY= "Even_analy";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
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
	public static final String NAME_ERR_DETAIL= "Name_err_detail";
	//名称
	public static final String NAME_DRUG_DOSA= "Name_drug_dosa";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 信息流转错误主键
	 * @return String
	 */
	public String getId_aer_ev_dinforerr() {
		return ((String) getAttrVal("Id_aer_ev_dinforerr"));
	}	
	/**
	 * 信息流转错误主键
	 * @param Id_aer_ev_dinforerr
	 */
	public void setId_aer_ev_dinforerr(String Id_aer_ev_dinforerr) {
		setAttrVal("Id_aer_ev_dinforerr", Id_aer_ev_dinforerr);
	}
	/**
	 * 事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件外键
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
	 * 事件错误详情id
	 * @return String
	 */
	public String getId_err_detail() {
		return ((String) getAttrVal("Id_err_detail"));
	}	
	/**
	 * 事件错误详情id
	 * @param Id_err_detail
	 */
	public void setId_err_detail(String Id_err_detail) {
		setAttrVal("Id_err_detail", Id_err_detail);
	}
	/**
	 * 事件错误详情编码
	 * @return String
	 */
	public String getSd_err_detail() {
		return ((String) getAttrVal("Sd_err_detail"));
	}	
	/**
	 * 事件错误详情编码
	 * @param Sd_err_detail
	 */
	public void setSd_err_detail(String Sd_err_detail) {
		setAttrVal("Sd_err_detail", Sd_err_detail);
	}
	/**
	 * 应给药物剂型id
	 * @return String
	 */
	public String getId_drug_dosa() {
		return ((String) getAttrVal("Id_drug_dosa"));
	}	
	/**
	 * 应给药物剂型id
	 * @param Id_drug_dosa
	 */
	public void setId_drug_dosa(String Id_drug_dosa) {
		setAttrVal("Id_drug_dosa", Id_drug_dosa);
	}
	/**
	 * 应给药物剂型编码
	 * @return String
	 */
	public String getSd_drug_dosa() {
		return ((String) getAttrVal("Sd_drug_dosa"));
	}	
	/**
	 * 应给药物剂型编码
	 * @param Sd_drug_dosa
	 */
	public void setSd_drug_dosa(String Sd_drug_dosa) {
		setAttrVal("Sd_drug_dosa", Sd_drug_dosa);
	}
	/**
	 * 应给药物其他剂型
	 * @return String
	 */
	public String getOth_drug_dosa() {
		return ((String) getAttrVal("Oth_drug_dosa"));
	}	
	/**
	 * 应给药物其他剂型
	 * @param Oth_drug_dosa
	 */
	public void setOth_drug_dosa(String Oth_drug_dosa) {
		setAttrVal("Oth_drug_dosa", Oth_drug_dosa);
	}
	/**
	 * 使用药物
	 * @return String
	 */
	public String getUse_drug() {
		return ((String) getAttrVal("Use_drug"));
	}	
	/**
	 * 使用药物
	 * @param Use_drug
	 */
	public void setUse_drug(String Use_drug) {
		setAttrVal("Use_drug", Use_drug);
	}
	/**
	 * 用法用量
	 * @return String
	 */
	public String getUs_dos_age() {
		return ((String) getAttrVal("Us_dos_age"));
	}	
	/**
	 * 用法用量
	 * @param Us_dos_age
	 */
	public void setUs_dos_age(String Us_dos_age) {
		setAttrVal("Us_dos_age", Us_dos_age);
	}
	/**
	 * 事件分析
	 * @return String
	 */
	public String getEven_analy() {
		return ((String) getAttrVal("Even_analy"));
	}	
	/**
	 * 事件分析
	 * @param Even_analy
	 */
	public void setEven_analy(String Even_analy) {
		setAttrVal("Even_analy", Even_analy);
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
	public String getName_err_detail() {
		return ((String) getAttrVal("Name_err_detail"));
	}	
	/**
	 * 名称
	 * @param Name_err_detail
	 */
	public void setName_err_detail(String Name_err_detail) {
		setAttrVal("Name_err_detail", Name_err_detail);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_drug_dosa() {
		return ((String) getAttrVal("Name_drug_dosa"));
	}	
	/**
	 * 名称
	 * @param Name_drug_dosa
	 */
	public void setName_drug_dosa(String Name_drug_dosa) {
		setAttrVal("Name_drug_dosa", Name_drug_dosa);
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
		return "Id_aer_ev_dinforerr";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_DINFORERR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvDInforErrDODesc.class);
	}
	
}