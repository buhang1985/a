package iih.mp.nr.hdvview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.hdvview.d.desc.HdvDODesc;
import java.math.BigDecimal;

/**
 * 交班报告 DO数据 
 * 
 */
public class HdvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//交班报告ID
	public static final String ID_HDV= "Id_hdv";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//班次
	public static final String ID_HDV_DEF= "Id_hdv_def";
	//交班科室
	public static final String ID_DEP_HDV= "Id_dep_hdv";
	//交班护士
	public static final String ID_EMP_HDV= "Id_emp_hdv";
	//班次时间
	public static final String DT_HDV= "Dt_hdv";
	//班次开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//班次截止时间
	public static final String DT_END= "Dt_end";
	//交班操作时间
	public static final String DT_OPER= "Dt_oper";
	//患者总数
	public static final String NUM_PAT= "Num_pat";
	//交班状态
	public static final String EU_HAV_STA= "Eu_hav_sta";
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
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//班次名称
	public static final String NAME_DHV_DEF= "Name_dhv_def";
	//交班科室
	public static final String NAME_DEP_HDV= "Name_dep_hdv";
	//交班护士
	public static final String NAME_EMP_DEV= "Name_emp_dev";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 交班报告ID
	 * @return String
	 */
	public String getId_hdv() {
		return ((String) getAttrVal("Id_hdv"));
	}	
	/**
	 * 交班报告ID
	 * @param Id_hdv
	 */
	public void setId_hdv(String Id_hdv) {
		setAttrVal("Id_hdv", Id_hdv);
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
	 * 班次
	 * @return String
	 */
	public String getId_hdv_def() {
		return ((String) getAttrVal("Id_hdv_def"));
	}	
	/**
	 * 班次
	 * @param Id_hdv_def
	 */
	public void setId_hdv_def(String Id_hdv_def) {
		setAttrVal("Id_hdv_def", Id_hdv_def);
	}
	/**
	 * 交班科室
	 * @return String
	 */
	public String getId_dep_hdv() {
		return ((String) getAttrVal("Id_dep_hdv"));
	}	
	/**
	 * 交班科室
	 * @param Id_dep_hdv
	 */
	public void setId_dep_hdv(String Id_dep_hdv) {
		setAttrVal("Id_dep_hdv", Id_dep_hdv);
	}
	/**
	 * 交班护士
	 * @return String
	 */
	public String getId_emp_hdv() {
		return ((String) getAttrVal("Id_emp_hdv"));
	}	
	/**
	 * 交班护士
	 * @param Id_emp_hdv
	 */
	public void setId_emp_hdv(String Id_emp_hdv) {
		setAttrVal("Id_emp_hdv", Id_emp_hdv);
	}
	/**
	 * 班次时间
	 * @return FDate
	 */
	public FDate getDt_hdv() {
		return ((FDate) getAttrVal("Dt_hdv"));
	}	
	/**
	 * 班次时间
	 * @param Dt_hdv
	 */
	public void setDt_hdv(FDate Dt_hdv) {
		setAttrVal("Dt_hdv", Dt_hdv);
	}
	/**
	 * 班次开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 班次开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 班次截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 班次截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 交班操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 交班操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 患者总数
	 * @return Integer
	 */
	public Integer getNum_pat() {
		return ((Integer) getAttrVal("Num_pat"));
	}	
	/**
	 * 患者总数
	 * @param Num_pat
	 */
	public void setNum_pat(Integer Num_pat) {
		setAttrVal("Num_pat", Num_pat);
	}
	/**
	 * 交班状态
	 * @return Integer
	 */
	public Integer getEu_hav_sta() {
		return ((Integer) getAttrVal("Eu_hav_sta"));
	}	
	/**
	 * 交班状态
	 * @param Eu_hav_sta
	 */
	public void setEu_hav_sta(Integer Eu_hav_sta) {
		setAttrVal("Eu_hav_sta", Eu_hav_sta);
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
	 * 班次名称
	 * @return String
	 */
	public String getName_dhv_def() {
		return ((String) getAttrVal("Name_dhv_def"));
	}	
	/**
	 * 班次名称
	 * @param Name_dhv_def
	 */
	public void setName_dhv_def(String Name_dhv_def) {
		setAttrVal("Name_dhv_def", Name_dhv_def);
	}
	/**
	 * 交班科室
	 * @return String
	 */
	public String getName_dep_hdv() {
		return ((String) getAttrVal("Name_dep_hdv"));
	}	
	/**
	 * 交班科室
	 * @param Name_dep_hdv
	 */
	public void setName_dep_hdv(String Name_dep_hdv) {
		setAttrVal("Name_dep_hdv", Name_dep_hdv);
	}
	/**
	 * 交班护士
	 * @return String
	 */
	public String getName_emp_dev() {
		return ((String) getAttrVal("Name_emp_dev"));
	}	
	/**
	 * 交班护士
	 * @param Name_emp_dev
	 */
	public void setName_emp_dev(String Name_emp_dev) {
		setAttrVal("Name_emp_dev", Name_emp_dev);
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
		return "Id_hdv";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_hdv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HdvDODesc.class);
	}
	
}