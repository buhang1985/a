package iih.bd.fc.bdwfdepctr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.bdwfdepctr.d.desc.BdWfDepCtrDODesc;
import java.math.BigDecimal;

/**
 * 流程配置_医嘱流向_整体控制 DO数据 
 * 
 */
public class BdWfDepCtrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱流向整体控制主键
	public static final String ID_WFDEPCTR= "Id_wfdepctr";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//序号
	public static final String SORTNO= "Sortno";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//流向类型
	public static final String EU_WFTP= "Eu_wftp";
	//流向科室
	public static final String ID_DEP= "Id_dep";
	//加急标志限定
	public static final String EU_URGENTCTR= "Eu_urgentctr";
	//出院带药标识限定
	public static final String EU_PRESOUTPCTR= "Eu_presoutpctr";
	//药品最小项目数
	public static final String ITMCNT_MIN= "Itmcnt_min";
	//药品最大项目数
	public static final String ITMCNT_MAX= "Itmcnt_max";
	//排斥其他科室
	public static final String FG_REDEP= "Fg_redep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	//科室编码
	public static final String DEP_CODE= "Dep_code";
	//科室名称
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱流向整体控制主键
	 * @return String
	 */
	public String getId_wfdepctr() {
		return ((String) getAttrVal("Id_wfdepctr"));
	}	
	/**
	 * 医嘱流向整体控制主键
	 * @param Id_wfdepctr
	 */
	public void setId_wfdepctr(String Id_wfdepctr) {
		setAttrVal("Id_wfdepctr", Id_wfdepctr);
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
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 流向类型
	 * @return Integer
	 */
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}	
	/**
	 * 流向类型
	 * @param Eu_wftp
	 */
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}
	/**
	 * 流向科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 流向科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 加急标志限定
	 * @return Integer
	 */
	public Integer getEu_urgentctr() {
		return ((Integer) getAttrVal("Eu_urgentctr"));
	}	
	/**
	 * 加急标志限定
	 * @param Eu_urgentctr
	 */
	public void setEu_urgentctr(Integer Eu_urgentctr) {
		setAttrVal("Eu_urgentctr", Eu_urgentctr);
	}
	/**
	 * 出院带药标识限定
	 * @return Integer
	 */
	public Integer getEu_presoutpctr() {
		return ((Integer) getAttrVal("Eu_presoutpctr"));
	}	
	/**
	 * 出院带药标识限定
	 * @param Eu_presoutpctr
	 */
	public void setEu_presoutpctr(Integer Eu_presoutpctr) {
		setAttrVal("Eu_presoutpctr", Eu_presoutpctr);
	}
	/**
	 * 药品最小项目数
	 * @return Integer
	 */
	public Integer getItmcnt_min() {
		return ((Integer) getAttrVal("Itmcnt_min"));
	}	
	/**
	 * 药品最小项目数
	 * @param Itmcnt_min
	 */
	public void setItmcnt_min(Integer Itmcnt_min) {
		setAttrVal("Itmcnt_min", Itmcnt_min);
	}
	/**
	 * 药品最大项目数
	 * @return Integer
	 */
	public Integer getItmcnt_max() {
		return ((Integer) getAttrVal("Itmcnt_max"));
	}	
	/**
	 * 药品最大项目数
	 * @param Itmcnt_max
	 */
	public void setItmcnt_max(Integer Itmcnt_max) {
		setAttrVal("Itmcnt_max", Itmcnt_max);
	}
	/**
	 * 排斥其他科室
	 * @return FBoolean
	 */
	public FBoolean getFg_redep() {
		return ((FBoolean) getAttrVal("Fg_redep"));
	}	
	/**
	 * 排斥其他科室
	 * @param Fg_redep
	 */
	public void setFg_redep(FBoolean Fg_redep) {
		setAttrVal("Fg_redep", Fg_redep);
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 科室编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 科室名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
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
		return "Id_wfdepctr";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_WF_DEPCTR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdWfDepCtrDODesc.class);
	}
	
}