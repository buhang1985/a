package iih.mp.mpbd.tcstyle.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.tcstyle.d.desc.TcstyDepDODesc;
import java.math.BigDecimal;

/**
 * 体温单适应科室 DO数据 
 * 
 */
public class TcstyDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体温单适应科室ID
	public static final String ID_TC_STY_DEP= "Id_tc_sty_dep";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//体温单样式ID
	public static final String ID_TC_STY= "Id_tc_sty";
	//序号
	public static final String SORTNO= "Sortno";
	//所属科室
	public static final String ID_DEP= "Id_dep";
	//患者分类编码
	public static final String SD_PATCA= "Sd_patca";
	//患者分类ID
	public static final String ID_PATCA= "Id_patca";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//样式名称
	public static final String NAME_TC_STY= "Name_tc_sty";
	//科室
	public static final String NAME_DEP= "Name_dep";
	//分类名称
	public static final String NAME_PATCA= "Name_patca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体温单适应科室ID
	 * @return String
	 */
	public String getId_tc_sty_dep() {
		return ((String) getAttrVal("Id_tc_sty_dep"));
	}	
	/**
	 * 体温单适应科室ID
	 * @param Id_tc_sty_dep
	 */
	public void setId_tc_sty_dep(String Id_tc_sty_dep) {
		setAttrVal("Id_tc_sty_dep", Id_tc_sty_dep);
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
	 * 体温单样式ID
	 * @return String
	 */
	public String getId_tc_sty() {
		return ((String) getAttrVal("Id_tc_sty"));
	}	
	/**
	 * 体温单样式ID
	 * @param Id_tc_sty
	 */
	public void setId_tc_sty(String Id_tc_sty) {
		setAttrVal("Id_tc_sty", Id_tc_sty);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 所属科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getSd_patca() {
		return ((String) getAttrVal("Sd_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Sd_patca
	 */
	public void setSd_patca(String Sd_patca) {
		setAttrVal("Sd_patca", Sd_patca);
	}
	/**
	 * 患者分类ID
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 患者分类ID
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
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
	 * 样式名称
	 * @return String
	 */
	public String getName_tc_sty() {
		return ((String) getAttrVal("Name_tc_sty"));
	}	
	/**
	 * 样式名称
	 * @param Name_tc_sty
	 */
	public void setName_tc_sty(String Name_tc_sty) {
		setAttrVal("Name_tc_sty", Name_tc_sty);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
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
		return "Id_tc_sty_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_tc_sty_dep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TcstyDepDODesc.class);
	}
	
}