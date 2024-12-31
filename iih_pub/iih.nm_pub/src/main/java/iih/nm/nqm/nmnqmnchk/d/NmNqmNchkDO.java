package iih.nm.nqm.nmnqmnchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmnchk.d.desc.NmNqmNchkDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_夜查房任务1 DO数据 
 * 
 */
public class NmNqmNchkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检查科室主键
	public static final String ID_NQM_NCHK= "Id_nqm_nchk";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//督导日期
	public static final String DT_SUPER= "Dt_super";
	//检查级别主键
	public static final String ID_CHK_LVL= "Id_chk_lvl";
	//检查级别编码
	public static final String SD_CHK_LVL= "Sd_chk_lvl";
	//督导者
	public static final String ID_SUPER_PSN= "Id_super_psn";
	//督导重点
	public static final String SUPER_KEY= "Super_key";
	//督导地点
	public static final String SUPER_ADRESS= "Super_adress";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String CHK_LVL_NAME= "Chk_lvl_name";
	//人员姓名
	public static final String SUPER_PSN_NAME= "Super_psn_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检查科室主键
	 * @return String
	 */
	public String getId_nqm_nchk() {
		return ((String) getAttrVal("Id_nqm_nchk"));
	}	
	/**
	 * 检查科室主键
	 * @param Id_nqm_nchk
	 */
	public void setId_nqm_nchk(String Id_nqm_nchk) {
		setAttrVal("Id_nqm_nchk", Id_nqm_nchk);
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
	 * 督导日期
	 * @return FDateTime
	 */
	public FDateTime getDt_super() {
		return ((FDateTime) getAttrVal("Dt_super"));
	}	
	/**
	 * 督导日期
	 * @param Dt_super
	 */
	public void setDt_super(FDateTime Dt_super) {
		setAttrVal("Dt_super", Dt_super);
	}
	/**
	 * 检查级别主键
	 * @return String
	 */
	public String getId_chk_lvl() {
		return ((String) getAttrVal("Id_chk_lvl"));
	}	
	/**
	 * 检查级别主键
	 * @param Id_chk_lvl
	 */
	public void setId_chk_lvl(String Id_chk_lvl) {
		setAttrVal("Id_chk_lvl", Id_chk_lvl);
	}
	/**
	 * 检查级别编码
	 * @return String
	 */
	public String getSd_chk_lvl() {
		return ((String) getAttrVal("Sd_chk_lvl"));
	}	
	/**
	 * 检查级别编码
	 * @param Sd_chk_lvl
	 */
	public void setSd_chk_lvl(String Sd_chk_lvl) {
		setAttrVal("Sd_chk_lvl", Sd_chk_lvl);
	}
	/**
	 * 督导者
	 * @return String
	 */
	public String getId_super_psn() {
		return ((String) getAttrVal("Id_super_psn"));
	}	
	/**
	 * 督导者
	 * @param Id_super_psn
	 */
	public void setId_super_psn(String Id_super_psn) {
		setAttrVal("Id_super_psn", Id_super_psn);
	}
	/**
	 * 督导重点
	 * @return String
	 */
	public String getSuper_key() {
		return ((String) getAttrVal("Super_key"));
	}	
	/**
	 * 督导重点
	 * @param Super_key
	 */
	public void setSuper_key(String Super_key) {
		setAttrVal("Super_key", Super_key);
	}
	/**
	 * 督导地点
	 * @return String
	 */
	public String getSuper_adress() {
		return ((String) getAttrVal("Super_adress"));
	}	
	/**
	 * 督导地点
	 * @param Super_adress
	 */
	public void setSuper_adress(String Super_adress) {
		setAttrVal("Super_adress", Super_adress);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getChk_lvl_name() {
		return ((String) getAttrVal("Chk_lvl_name"));
	}	
	/**
	 * 名称
	 * @param Chk_lvl_name
	 */
	public void setChk_lvl_name(String Chk_lvl_name) {
		setAttrVal("Chk_lvl_name", Chk_lvl_name);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getSuper_psn_name() {
		return ((String) getAttrVal("Super_psn_name"));
	}	
	/**
	 * 人员姓名
	 * @param Super_psn_name
	 */
	public void setSuper_psn_name(String Super_psn_name) {
		setAttrVal("Super_psn_name", Super_psn_name);
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
		return "Id_nqm_nchk";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_NCHK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmNchkDODesc.class);
	}
	
}