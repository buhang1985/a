package iih.cssd.dpp.dfpcln.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfpcln.d.desc.CssdDfpClnDODesc;
import java.math.BigDecimal;

/**
 * 包清洗 DO数据 
 * 
 */
public class CssdDfpClnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包清洗主键
	public static final String ID_DFP_CLN= "Id_dfp_cln";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//清洗类型ID
	public static final String ID_PKGCLEAN= "Id_pkgclean";
	//清洗类型编码
	public static final String SD_PKGCLEAN= "Sd_pkgclean";
	//清洗机
	public static final String ID_DFP_INSTR= "Id_dfp_instr";
	//清洗机关系ID
	public static final String ID_DFP_REL= "Id_dfp_rel";
	//清洗批次
	public static final String BATCH= "Batch";
	//扫码条码
	public static final String REC_NO_BAR= "Rec_no_bar";
	//清洗程序SD
	public static final String SD_CLNPRO= "Sd_clnpro";
	//清洗程序ID
	public static final String ID_CLNPRO= "Id_clnpro";
	//清洗时间
	public static final String DT_CLN= "Dt_cln";
	//清洗人
	public static final String ID_EMP= "Id_emp";
	//清洗科室
	public static final String ID_DEP= "Id_dep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//清洗类型名称
	public static final String NAME_PKGCLEAN= "Name_pkgclean";
	//清洗机
	public static final String NAME_DFP_INSTR= "Name_dfp_instr";
	//清洗程序名称
	public static final String NAME_CLNPRO= "Name_clnpro";
	//清洗人
	public static final String NAME_EMP= "Name_emp";
	//清洗科室
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包清洗主键
	 * @return String
	 */
	public String getId_dfp_cln() {
		return ((String) getAttrVal("Id_dfp_cln"));
	}	
	/**
	 * 消毒包清洗主键
	 * @param Id_dfp_cln
	 */
	public void setId_dfp_cln(String Id_dfp_cln) {
		setAttrVal("Id_dfp_cln", Id_dfp_cln);
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
	 * 清洗类型ID
	 * @return String
	 */
	public String getId_pkgclean() {
		return ((String) getAttrVal("Id_pkgclean"));
	}	
	/**
	 * 清洗类型ID
	 * @param Id_pkgclean
	 */
	public void setId_pkgclean(String Id_pkgclean) {
		setAttrVal("Id_pkgclean", Id_pkgclean);
	}
	/**
	 * 清洗类型编码
	 * @return String
	 */
	public String getSd_pkgclean() {
		return ((String) getAttrVal("Sd_pkgclean"));
	}	
	/**
	 * 清洗类型编码
	 * @param Sd_pkgclean
	 */
	public void setSd_pkgclean(String Sd_pkgclean) {
		setAttrVal("Sd_pkgclean", Sd_pkgclean);
	}
	/**
	 * 清洗机
	 * @return String
	 */
	public String getId_dfp_instr() {
		return ((String) getAttrVal("Id_dfp_instr"));
	}	
	/**
	 * 清洗机
	 * @param Id_dfp_instr
	 */
	public void setId_dfp_instr(String Id_dfp_instr) {
		setAttrVal("Id_dfp_instr", Id_dfp_instr);
	}
	/**
	 * 清洗机关系ID
	 * @return String
	 */
	public String getId_dfp_rel() {
		return ((String) getAttrVal("Id_dfp_rel"));
	}	
	/**
	 * 清洗机关系ID
	 * @param Id_dfp_rel
	 */
	public void setId_dfp_rel(String Id_dfp_rel) {
		setAttrVal("Id_dfp_rel", Id_dfp_rel);
	}
	/**
	 * 清洗批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 清洗批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 扫码条码
	 * @return String
	 */
	public String getRec_no_bar() {
		return ((String) getAttrVal("Rec_no_bar"));
	}	
	/**
	 * 扫码条码
	 * @param Rec_no_bar
	 */
	public void setRec_no_bar(String Rec_no_bar) {
		setAttrVal("Rec_no_bar", Rec_no_bar);
	}
	/**
	 * 清洗程序SD
	 * @return String
	 */
	public String getSd_clnpro() {
		return ((String) getAttrVal("Sd_clnpro"));
	}	
	/**
	 * 清洗程序SD
	 * @param Sd_clnpro
	 */
	public void setSd_clnpro(String Sd_clnpro) {
		setAttrVal("Sd_clnpro", Sd_clnpro);
	}
	/**
	 * 清洗程序ID
	 * @return String
	 */
	public String getId_clnpro() {
		return ((String) getAttrVal("Id_clnpro"));
	}	
	/**
	 * 清洗程序ID
	 * @param Id_clnpro
	 */
	public void setId_clnpro(String Id_clnpro) {
		setAttrVal("Id_clnpro", Id_clnpro);
	}
	/**
	 * 清洗时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cln() {
		return ((FDateTime) getAttrVal("Dt_cln"));
	}	
	/**
	 * 清洗时间
	 * @param Dt_cln
	 */
	public void setDt_cln(FDateTime Dt_cln) {
		setAttrVal("Dt_cln", Dt_cln);
	}
	/**
	 * 清洗人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 清洗人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 清洗科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 清洗科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 清洗类型名称
	 * @return String
	 */
	public String getName_pkgclean() {
		return ((String) getAttrVal("Name_pkgclean"));
	}	
	/**
	 * 清洗类型名称
	 * @param Name_pkgclean
	 */
	public void setName_pkgclean(String Name_pkgclean) {
		setAttrVal("Name_pkgclean", Name_pkgclean);
	}
	/**
	 * 清洗机
	 * @return String
	 */
	public String getName_dfp_instr() {
		return ((String) getAttrVal("Name_dfp_instr"));
	}	
	/**
	 * 清洗机
	 * @param Name_dfp_instr
	 */
	public void setName_dfp_instr(String Name_dfp_instr) {
		setAttrVal("Name_dfp_instr", Name_dfp_instr);
	}
	/**
	 * 清洗程序名称
	 * @return String
	 */
	public String getName_clnpro() {
		return ((String) getAttrVal("Name_clnpro"));
	}	
	/**
	 * 清洗程序名称
	 * @param Name_clnpro
	 */
	public void setName_clnpro(String Name_clnpro) {
		setAttrVal("Name_clnpro", Name_clnpro);
	}
	/**
	 * 清洗人
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 清洗人
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 清洗科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 清洗科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_dfp_cln";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_CLN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdDfpClnDODesc.class);
	}
	
}