package iih.nm.nqm.nmnqmcstmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmcstmpl.d.desc.NmnqmcstmplDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_检查标准模板 DO数据 
 * 
 */
public class NmnqmcstmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检查标准模板id
	public static final String ID_NQM_TMPL= "Id_nqm_tmpl";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//模板名称
	public static final String NAME= "Name";
	//模板组
	public static final String ID_NQM_TMPL_GRP= "Id_nqm_tmpl_grp";
	//检查标准
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//质控标准编码
	public static final String CODE_NQM_CS= "Code_nqm_cs";
	//年月
	public static final String DT_TMPL= "Dt_tmpl";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//护理单元编码
	public static final String SD_DEP_NUR= "Sd_dep_nur";
	//检查级别
	public static final String ID_CHK_LVL= "Id_chk_lvl";
	//检查级别编码
	public static final String SD_CHK_LVL= "Sd_chk_lvl";
	//模板总分
	public static final String SCORE_TOTAL= "Score_total";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//描述
	public static final String DES= "Des";
	//创建人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//创建时间
	public static final String DT_REG= "Dt_reg";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//扩展字段6
	public static final String DEF6= "Def6";
	//创建人1
	public static final String CREATEDBY= "Createdby";
	//创建时间1
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//检查标准名称
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	//版本
	public static final String VERSION_NQM_CS= "Version_nqm_cs";
	//部门名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//质控级别
	public static final String NAME_CHK_LVL= "Name_chk_lvl";
	//创建人
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检查标准模板id
	 * @return String
	 */
	public String getId_nqm_tmpl() {
		return ((String) getAttrVal("Id_nqm_tmpl"));
	}	
	/**
	 * 检查标准模板id
	 * @param Id_nqm_tmpl
	 */
	public void setId_nqm_tmpl(String Id_nqm_tmpl) {
		setAttrVal("Id_nqm_tmpl", Id_nqm_tmpl);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 模板组
	 * @return String
	 */
	public String getId_nqm_tmpl_grp() {
		return ((String) getAttrVal("Id_nqm_tmpl_grp"));
	}	
	/**
	 * 模板组
	 * @param Id_nqm_tmpl_grp
	 */
	public void setId_nqm_tmpl_grp(String Id_nqm_tmpl_grp) {
		setAttrVal("Id_nqm_tmpl_grp", Id_nqm_tmpl_grp);
	}
	/**
	 * 检查标准
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 检查标准
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 质控标准编码
	 * @return String
	 */
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}	
	/**
	 * 质控标准编码
	 * @param Code_nqm_cs
	 */
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
	}
	/**
	 * 年月
	 * @return FDate
	 */
	public FDate getDt_tmpl() {
		return ((FDate) getAttrVal("Dt_tmpl"));
	}	
	/**
	 * 年月
	 * @param Dt_tmpl
	 */
	public void setDt_tmpl(FDate Dt_tmpl) {
		setAttrVal("Dt_tmpl", Dt_tmpl);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 护理单元编码
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}	
	/**
	 * 护理单元编码
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 检查级别
	 * @return String
	 */
	public String getId_chk_lvl() {
		return ((String) getAttrVal("Id_chk_lvl"));
	}	
	/**
	 * 检查级别
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
	 * 模板总分
	 * @return String
	 */
	public String getScore_total() {
		return ((String) getAttrVal("Score_total"));
	}	
	/**
	 * 模板总分
	 * @param Score_total
	 */
	public void setScore_total(String Score_total) {
		setAttrVal("Score_total", Score_total);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 创建人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 创建时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 创建人1
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人1
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间1
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间1
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
	 * 检查标准名称
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	/**
	 * 检查标准名称
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	/**
	 * 版本
	 * @return String
	 */
	public String getVersion_nqm_cs() {
		return ((String) getAttrVal("Version_nqm_cs"));
	}	
	/**
	 * 版本
	 * @param Version_nqm_cs
	 */
	public void setVersion_nqm_cs(String Version_nqm_cs) {
		setAttrVal("Version_nqm_cs", Version_nqm_cs);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 质控级别
	 * @return String
	 */
	public String getName_chk_lvl() {
		return ((String) getAttrVal("Name_chk_lvl"));
	}	
	/**
	 * 质控级别
	 * @param Name_chk_lvl
	 */
	public void setName_chk_lvl(String Name_chk_lvl) {
		setAttrVal("Name_chk_lvl", Name_chk_lvl);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 创建人
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nqm_tmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_CSTMPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmnqmcstmplDODesc.class);
	}
	
}